//package com.sample.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.entity.Expense;
//import com.sample.entity.ExpenseDTO1;
//import com.sample.entity.ExpenseDTO2;
//import com.sample.service.ExpenseService;	
//
//@RestController
//@RequestMapping("/expenses")
//public class ExpenseController {
//
//    @Autowired
//    private ExpenseService expenseService;
//    
//    @PostMapping("/addexpensebasedonid/{invoiceId}")
//    public ResponseEntity<Expense> addExpenseToInvoice(@PathVariable String invoiceId, @RequestBody Expense expense) {
//        try {
//            Expense savedExpense = expenseService.addExpenseToInvoice(invoiceId, expense);
//            return ResponseEntity.ok(savedExpense);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @GetMapping("/getallexpenses")
//    public List<Expense> getAllExpenses() {
//        return expenseService.getAllExpenses();
//    }
//
//    @GetMapping("getexpensebyid/{id}")
//    public ExpenseDTO1 getExpenseById(@PathVariable Long id) {
//        return expenseService.getExpenseById(id);
//    }
//
//    @PostMapping
//    public Expense createExpense(@RequestBody Expense expense) {
//        return expenseService.saveExpense(expense);
//    }
//
//    @PutMapping("/updateexpense/{id}")
//    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO2 expenseDTO2) {
//        Expense updatedExpense = expenseService.updateExpense(id, expenseDTO2);
//        return ResponseEntity.ok(updatedExpense);
//    }
//
//    @DeleteMapping("/deleteexpense/{id}")
//    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
//        try {
//            expenseService.deleteExpense(id);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
//
//
//
//
//
//
//
//










package com.sample.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Brand;
import com.sample.entity.City;
import com.sample.entity.Expense;
import com.sample.entity.ExpenseDTO1;
import com.sample.entity.ExpenseDTO2;
import com.sample.entity.ReceiptpaymentDTO;
import com.sample.service.ExpenseService;	

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    
    @PostMapping("/addexpensebasedonid/{invoiceId}")
    public ResponseEntity<Expense> addExpenseToInvoice(@PathVariable String invoiceId, @RequestBody Expense expense) {
        try {
            Expense savedExpense = expenseService.addExpenseToInvoice(invoiceId, expense);
            return ResponseEntity.ok(savedExpense);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

 // Get all expenses (Converted from GET to POST)
    @PostMapping("/getallexpenses")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        try {
            List<Expense> expenses = expenseService.getAllExpenses();
            return ResponseEntity.ok(expenses);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Get expense by ID (Converted from GET to POST)
    @PostMapping("/getexpensebyid")
    public ResponseEntity<ExpenseDTO1> getExpenseById(@RequestBody Map<String, Long> requestBody) {
        try {
            Long id = requestBody.get("id");
            ExpenseDTO1 expenseDTO = expenseService.getExpenseById(id);
            return ResponseEntity.ok(expenseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    

    // Create expense
    @PostMapping("/createexpense")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        try {
            Expense createdExpense = expenseService.saveExpense(expense);
            return ResponseEntity.ok(createdExpense);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/updateexpense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO2 expenseDTO2) {
        try {
            Expense updatedExpense = expenseService.updateExpense(id, expenseDTO2);
            return ResponseEntity.ok(updatedExpense);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
 // Delete expense (Converted from DELETE to POST)
    @PostMapping("/deleteexpense")
    public ResponseEntity<Void> deleteExpense(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
    
    
}








