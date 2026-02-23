////correct
//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.service.EmailService;
//
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/email")
//public class EmailController {
//
//    @Autowired
//    private EmailService emailService;
//
//    
//    
//    @PostMapping("/send")
//    public String sendEmail(@RequestBody EmailRequest emailRequest) {
//        try {
//            // Extract structured invoice details
//            Map<String, Object> invoiceDetails = emailRequest.getInvoiceDetails();
//
//            // Generate the PDF
//            byte[] pdfData = emailService.generateInvoicePDF(invoiceDetails);
//
//            // Send the email
//            emailService.sendEmailWithAttachment(
//                emailRequest.getTo(),
//                emailRequest.getSubject(),
//                emailRequest.getBody(),
//                pdfData
//            );
//
//            return "Email sent successfully with PDF attachment!";
//        } catch (Exception e) {
//            return "Error sending email: " + e.getMessage();
//        }
//    }
//
//    public static class EmailRequest {
//        private String to;
//        private String subject;
//        private String body;
//        private Map<String, Object> invoiceDetails; // Updated to Map<String, Object>
//        
//     // Getters and setters
//        
//		public String getTo() {
//			return to;
//		}
//		public void setTo(String to) {
//			this.to = to;
//		}
//		public String getSubject() {
//			return subject;
//		}
//		public void setSubject(String subject) {
//			this.subject = subject;
//		}
//		public String getBody() {
//			return body;
//		}
//		public void setBody(String body) {
//			this.body = body;
//		}
//		public Map<String, Object> getInvoiceDetails() {
//			return invoiceDetails;
//		}
//		public void setInvoiceDetails(Map<String, Object> invoiceDetails) {
//			this.invoiceDetails = invoiceDetails;
//		}
//
//        
//        
//        
//    }
//
//}
//
//correct
package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.service.EmailService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    
    
    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            // Extract structured invoice details
            Map<String, Object> invoiceDetails = emailRequest.getInvoiceDetails();

            // Generate the PDF
            byte[] pdfData = emailService.generateInvoicePDF(invoiceDetails);

            // Send the email
            emailService.sendEmailWithAttachment(
                emailRequest.getTo(),
                emailRequest.getSubject(),
                emailRequest.getBody(),
                pdfData
            );

            return "Email sent successfully with PDF attachment!";
        } catch (Exception e) {
            return "Error sending email: " + e.getMessage();
        }
    }

    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;
        private Map<String, Object> invoiceDetails; // Updated to Map<String, Object>
        
     // Getters and setters
        
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public Map<String, Object> getInvoiceDetails() {
			return invoiceDetails;
		}
		public void setInvoiceDetails(Map<String, Object> invoiceDetails) {
			this.invoiceDetails = invoiceDetails;
		}

        
        
        
    }

}








