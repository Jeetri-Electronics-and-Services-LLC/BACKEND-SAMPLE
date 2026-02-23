package com.sample.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // Method to generate a dynamic invoice PDF based on the provided invoice data
    public byte[] generateInvoicePDF(Map<String, Object> orderDetails) throws IOException, DocumentException {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);

        // Add footer to every page
        writer.setPageEvent(new PdfFooter());

        document.open();

        // Add logo and company details in the same row
        PdfPTable headerTable = new PdfPTable(2); // Two columns: Logo and Company Details
        headerTable.setWidthPercentage(100); // Full width
        headerTable.setWidths(new float[]{2, 5}); // Column width ratio

        // Add logo
        String logoPath = getClass().getClassLoader().getResource("images/logo.png").getPath();
        Image logo = Image.getInstance(logoPath);
        logo.scaleToFit(150, 70);
        PdfPCell logoCell = new PdfPCell(logo);
        logoCell.setBorder(PdfPCell.NO_BORDER);
        logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);

        // Add company details aligned to the right
        Paragraph companyDetails = new Paragraph();
        companyDetails.add(new Chunk("Jeetri Electronics and Services\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        companyDetails.add(new Chunk("123 Business St, Tech City\n"));
        companyDetails.add(new Chunk("Phone: (123) 456-7890\n"));
        companyDetails.add(new Chunk("Email: info@jeetrielectronics.com\n"));
        companyDetails.add(new Chunk("Website: www.jeetrielectronics.com\n"));
        PdfPCell detailsCell = new PdfPCell(companyDetails);
        detailsCell.setBorder(PdfPCell.NO_BORDER);
        detailsCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Align to the right
        detailsCell.setPaddingRight(10); // Add some padding to prevent overlap

        // Add cells to the header table
        headerTable.addCell(logoCell);
        headerTable.addCell(detailsCell);

        // Add header table to document
        document.add(headerTable);

        document.add(Chunk.NEWLINE); // Add space

        // Add order type (Invoice or Estimate) above "Bill To"
        String ordertype = (String) orderDetails.get("ordertype");
        Paragraph orderTypeParagraph = new Paragraph(ordertype.equalsIgnoreCase("Invoice") ? "Invoice" : "Estimate",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
        orderTypeParagraph.setAlignment(Element.ALIGN_LEFT);
        document.add(orderTypeParagraph);

        document.add(new Paragraph("Bill To: " + orderDetails.get("billTo")));
       

        // Add basic order details
        document.add(new Paragraph("Order ID: " + orderDetails.get("id")));
        document.add(new Paragraph("Customer: " + orderDetails.get("customer")));
        document.add(new Paragraph("CreatedDate: " + orderDetails.get("createddate")));

        // Add order details table
        document.add(new Paragraph("\nOrder Details:"));
        PdfPTable table = new PdfPTable(4); // Name, Description, Quantity, Price
        table.setWidthPercentage(100);
        Stream.of("Name", "Description", "Quantity", "Price").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setPhrase(new Phrase(columnTitle, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            table.addCell(header);
        });

        List<Map<String, String>> items = (List<Map<String, String>>)
                (orderDetails.get("products") != null
                        ? orderDetails.get("products")
                        : orderDetails.get("estimateProductDetails"));

        for (Map<String, String> item : items) {
            table.addCell(item.get("name"));
            table.addCell(item.get("description"));
            table.addCell(item.get("qty"));
            table.addCell(item.get("salesprice"));
        }
        
        document.add(new Paragraph("\nOrder Detailswithouttax:"));
        PdfPTable table1 = new PdfPTable(2); // Name, Description, Quantity, Price
        table1.setWidthPercentage(100);
        Stream.of("descriptionwot", "pricewot").forEach(columnTitle -> {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setPhrase(new Phrase(columnTitle, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
            table1.addCell(header);
        });

        List<Map<String, String>> items1 = (List<Map<String, String>>)
                (orderDetails.get("invoicewithouttax") != null
                        ? orderDetails.get("invoicewithouttax")
                        : orderDetails.get("estimateWithoutTax"));

        for (Map<String, String> item1 : items1) {
            table1.addCell(item1.get("descriptionwot"));
            table1.addCell(item1.get("pricewot"));
           
        }

        document.add(table);
        document.add(table1);

        // Create a table for financial summary aligned to the right
        PdfPTable summaryTable = new PdfPTable(2); // Two columns: Field and Value
        summaryTable.setHorizontalAlignment(Element.ALIGN_RIGHT); // Align to the right of the page
        summaryTable.setWidths(new float[]{1.5f, 1.0f}); // Adjust column widths for closeness
        summaryTable.setWidthPercentage(40); // Set overall table width to 40% of the page

        // Add financial summary rows
        addFinancialRow(summaryTable, "Subtotal:", orderDetails.get("subtotal").toString());
        addFinancialRow(summaryTable, "Sales Tax:", orderDetails.get("salesTax").toString());
        addFinancialRow(summaryTable, "Total:", orderDetails.get("total").toString());

        // Add Balance Amount for Invoice only
        if ("Invoice".equalsIgnoreCase(ordertype)) {
            addFinancialRow(summaryTable, "Balance Amount:", orderDetails.get("balanceamount").toString());
        }

        // Add financial summary table to document
        document.add(summaryTable);

        // Add terms and conditions on a new page
        document.newPage();
        document.add(new Paragraph("Terms and Conditions:"));
        document.add(new Paragraph(orderDetails.get("notetocustomer").toString()));

        document.close();
        return byteArrayOutputStream.toByteArray();
    }

    // Utility method to add rows to the financial summary table
    private void addFinancialRow(PdfPTable table, String label, String value) {
        // Create cell for the label (heading)
        PdfPCell labelCell = new PdfPCell(new Phrase(label, FontFactory.getFont(FontFactory.HELVETICA, 10)));
        labelCell.setBorder(PdfPCell.NO_BORDER); // Remove borders
        labelCell.setHorizontalAlignment(Element.ALIGN_LEFT); // Align left
        labelCell.setPaddingTop(2); // Reduce top padding
        labelCell.setPaddingBottom(2); // Reduce bottom padding
        labelCell.setPaddingRight(5); // Optional: Add slight space between columns
        table.addCell(labelCell);

        // Create cell for the value
        PdfPCell valueCell = new PdfPCell(new Phrase(value, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10)));
        valueCell.setBorder(PdfPCell.NO_BORDER); // Remove borders
        valueCell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Align right
        valueCell.setPaddingTop(2); // Reduce top padding
        valueCell.setPaddingBottom(2); // Reduce bottom padding
        valueCell.setPaddingLeft(3); // Optional: Add slight space between columns
        table.addCell(valueCell);
    }




    // Method to send the email with the generated PDF attached
    public void sendEmailWithAttachment(String to, String subject, String body, byte[] pdfData) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body);

        // Add the PDF attachment
        helper.addAttachment("Invoice.pdf", new ByteArrayDataSource(pdfData, "application/pdf"));

        // Send the email
        javaMailSender.send(message);
    }

    // Inner class to add footer to each page
    private static class PdfFooter extends com.itextpdf.text.pdf.PdfPageEventHelper {
        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            try {
                // Footer text split into three lines
                String line1 = "This email and any attachments are confidential Jeetri Electronics and Services property intended solely for the recipients.";
                String line2 = "If you received this message in error, please notify corporation @978-953-3874 and immediately delete this message from your computer.";
                String line3 = "Any retention, distribution or other use of this email is strictly prohibited.";

                // Set font and size for the footer
                writer.getDirectContent().beginText();
                writer.getDirectContent().setFontAndSize(FontFactory.getFont(FontFactory.HELVETICA, 8).getBaseFont(), 8);

                // Adjusting the positions for each line (you may tweak the Y positions as needed)
                writer.getDirectContent().setTextMatrix(30, 30); // X, Y for line 1
                writer.getDirectContent().showText(line1);

                writer.getDirectContent().setTextMatrix(30, 20); // X, Y for line 2 (move down a bit)
                writer.getDirectContent().showText(line2);

                writer.getDirectContent().setTextMatrix(30, 10); // X, Y for line 3 (move down further)
                writer.getDirectContent().showText(line3);

                writer.getDirectContent().endText();
            } catch (Exception e) {
                e.printStackTrace(); // Handle exception as needed
            }
        }
    }
}
