package com.sample.service;


import com.sample.entity.EstimateDTOes;
import com.sample.entity.ExpenseDTOes;
import com.sample.entity.InvoiceDTOes;
import com.sample.entity.ReceiptpaymentDTOes;
import com.sample.repository.EstimateInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstimateInvoiceService {

    @Autowired
    private EstimateInvoiceRepository estimateInvoiceRepository;

    public List<Object> getEstimatesAndInvoicesAsSingleList(String customerDisplayName) {
        List<EstimateDTOes> estimates = estimateInvoiceRepository.findEstimatesByCustomerDisplayName(customerDisplayName);
        List<InvoiceDTOes> invoices = estimateInvoiceRepository.findInvoicesByCustomerDisplayName(customerDisplayName);
        List<ExpenseDTOes> expenses = estimateInvoiceRepository.findExpensesByCustomerDisplayName(customerDisplayName);
        List<ReceiptpaymentDTOes> receiptpayments = estimateInvoiceRepository.findReceiptpaymentByCustomerDisplayName(customerDisplayName);

        // Combine both lists into a single list
        List<Object> combinedList = new ArrayList<>();
        combinedList.addAll(estimates);
        combinedList.addAll(invoices);
        combinedList.addAll(expenses);
        combinedList.addAll(receiptpayments);
        

        return combinedList;
    }
}



//public EstimateInvoiceResponseDTOes getEstimatesAndInvoicesByCustomerDisplayName(String customerDisplayName) {
//List<EstimateDTOes> estimates = estimateInvoiceRepository.findEstimatesByCustomerDisplayName(customerDisplayName);
//List<InvoiceDTOes> invoices = estimateInvoiceRepository.findInvoicesByCustomerDisplayName(customerDisplayName);
//return new EstimateInvoiceResponseDTOes(estimates, invoices);
//}