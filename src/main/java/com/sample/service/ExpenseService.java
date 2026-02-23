package com.sample.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Customer;
import com.sample.entity.Expense;
import com.sample.entity.ExpenseDTO1;
import com.sample.entity.ExpenseDTO2;
import com.sample.entity.Invoice;
import com.sample.repository.CustomerRepository;
import com.sample.repository.ExpenseRepository;
import com.sample.repository.InvoiceRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    
    @Autowired
    private InvoiceRepository invoiceRepository; // Assume this exists to fetch Invoice by ID
    
    @Autowired
    private CustomerRepository customerRepository;

    public Expense addExpenseToInvoice(String invoiceId, Expense expense) {
        Long invoiceIdLong;
        try {
            invoiceIdLong = Long.parseLong(invoiceId); // Convert String to Long
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid invoice ID: " + invoiceId);
        }

        // Set the invoiceId field in Expense
        expense.setInvoiceid(invoiceId);

        // Fetch the Invoice and set it in the Expense
        Invoice invoice = invoiceRepository.findById(invoiceIdLong)
                .orElseThrow(() -> new RuntimeException("Invoice not found with ID: " + invoiceId));
        expense.setInvoice(invoice); // Link the Invoice object to the Expense
     // Set the customer based on the customerdisplayname_id
        String customerDisplayName = expense.getCustomerdisplayname_id();
        Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
        if (customer != null) {
            expense.setCustomer(customer);  // Set the customer entity in the invoice
        } else {
            throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
        }

        return expenseRepository.save(expense); // Save and return the Expense
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public ExpenseDTO1 getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Expense not found with id: " + id));
        
        ExpenseDTO1 expenseDTO1 = new ExpenseDTO1();
        expenseDTO1.setId(expense.getId());
        expenseDTO1.setInvoiceid(expense.getInvoiceid());
        expenseDTO1.setOrdertype(expense.getOrdertype());
        expenseDTO1.setCustomerdisplayname_id(expense.getCustomerdisplayname_id());
        expenseDTO1.setAmount(expense.getAmount());
        expenseDTO1.setDescription(expense.getDescription());
        expenseDTO1.setPaidfromaccount(expense.getPaidfromaccount());
        expenseDTO1.setCreatedby(expense.getCreatedby());
        expenseDTO1.setCreateddate(expense.getCreateddate());

        return expenseDTO1;
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, ExpenseDTO2 expenseDTO2) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            // Update fields only if provided
            if (expenseDTO2.getInvoiceid() != null) expense.setInvoiceid(expenseDTO2.getInvoiceid());
            if (expenseDTO2.getOrdertype() != null) expense.setOrdertype(expenseDTO2.getOrdertype());
            if (expenseDTO2.getCustomerdisplayname_id() != null) expense.setCustomerdisplayname_id(expenseDTO2.getCustomerdisplayname_id());
            if (expenseDTO2.getAmount() != null) expense.setAmount(expenseDTO2.getAmount());
            if (expenseDTO2.getDescription() != null) expense.setDescription(expenseDTO2.getDescription());
            if (expenseDTO2.getPaidfromaccount() != null) expense.setPaidfromaccount(expenseDTO2.getPaidfromaccount());
            if (expenseDTO2.getCreateddate() != null)expense.setCreateddate(expenseDTO2.getCreateddate());
            if (expenseDTO2.getCreatedby() != null) expense.setCreatedby(expenseDTO2.getCreatedby());

            
            
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Expense not found with id: " + id);
        }
    }
    
    public void deleteExpense(Long id) {
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
        expenseRepository.delete(existingExpense);
    }
}

