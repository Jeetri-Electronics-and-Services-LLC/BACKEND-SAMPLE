<<<<<<< HEAD
//package com.sample.controller;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import com.sample.entity.*;
//import com.sample.service.DropdownService;
//import java.util.List;
//
//@RestController
//@RequestMapping("/drop")
//
//public class DropdownController {
//
//    @Autowired
//    private DropdownService dropdownService;
//
//    // Category
//    @GetMapping("/getcategories")
//    public List<Category> getCategories() {
//        return dropdownService.getCategories();
//    }
//
//    @PostMapping("/addcategories")
//    public Category addCategory(@RequestBody Category category) {
//        return dropdownService.addCategory(category);
//    }
//
//    @PutMapping("/updatecategories/{id}")
//    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
//        category.setId(id); // Assuming Category entity has setId method
//        return dropdownService.updateCategory(category);
//    }
//
//    @DeleteMapping("/deletecategories/{id}")
//    public void deleteCategory(@PathVariable int id) {
//        dropdownService.deleteCategory(id);
//    }
//
//    // Asset Account
//    @GetMapping("/getassetAccounts")
//    public List<Assetaccount> getAssetaccounts() {
//        return dropdownService.getAssetaccounts();
//    }
//
//    @PostMapping("/addassetAccounts")
//    public Assetaccount addAssetaccount(@RequestBody Assetaccount assetaccount) {
//        return dropdownService.addAssetaccount(assetaccount);
//    }
//
//    @PutMapping("/updateassetAccounts/{id}")
//    public Assetaccount updateAssetaccount(@PathVariable int id, @RequestBody Assetaccount assetaccount) {
//        assetaccount.setId(id); // Assuming Assetaccount entity has setId method
//        return dropdownService.updateAssetAccount(assetaccount);
//    }
//
//    @DeleteMapping("/deleteassetAccounts/{id}")
//    public void deleteAssetaccount(@PathVariable int id) {
//        dropdownService.deleteAssetaccount(id);
//    }
//
//    // Income Account
//    @GetMapping("/getincomeAccounts")
//    public List<Incomeaccount> getIncomeaccounts() {
//        return dropdownService.getIncomeaccounts();
//    }
//
//    @PostMapping("/addincomeAccounts")
//    public Incomeaccount addIncomeAccount(@RequestBody Incomeaccount incomeaccount) {
//        return dropdownService.addIncomeaccount(incomeaccount);
//    }
//
//    @PutMapping("/updateincomeAccounts/{id}")
//    public Incomeaccount updateIncomeaccount(@PathVariable int id, @RequestBody Incomeaccount incomeaccount) {
//        incomeaccount.setId(id); // Assuming Incomeaccount entity has setId method
//        return dropdownService.updateIncomeaccount(incomeaccount);
//    }
//
//    @DeleteMapping("/deleteincomeAccounts/{id}")
//    public void deleteIncomeaccount(@PathVariable int id) {
//        dropdownService.deleteIncomeaccount(id);
//    }
//
//    // Expense Account
//    @GetMapping("/getexpenseAccounts")
//    public List<Expenseaccount> getExpenseAccounts() {
//        return dropdownService.getExpenseaccounts();
//    }
//
//    @PostMapping("/addexpenseAccounts")
//    public Expenseaccount addExpenseaccount(@RequestBody Expenseaccount expenseaccount) {
//        return dropdownService.addExpenseaccount(expenseaccount);
//    }
//
//    @PutMapping("/updateexpenseAccounts/{id}")
//    public Expenseaccount updateExpenseaccount(@PathVariable int id, @RequestBody Expenseaccount expenseaccount) {
//        expenseaccount.setId(id); // Assuming Expenseaccount entity has setId method
//        return dropdownService.updateExpenseaccount(expenseaccount);
//    }
//
//
//    @DeleteMapping("/deleteexpenseAccounts/{id}")
//    public void deleteExpenseaccount(@PathVariable int id) {
//        dropdownService.deleteExpenseaccount(id);
//    }
//
//    // Preferred Vendor
//    @GetMapping("/getpreferredVendors")
//    public List<Preferredvendor> getPreferredVendors() {
//        return dropdownService.getPreferredvendors();
//    }
//
//    @PostMapping("/addpreferredVendors")
//    public Preferredvendor addPreferredVendor(@RequestBody Preferredvendor preferredVendor) {
//        return dropdownService.addPreferredvendor(preferredVendor);
//    }
//
//    @PutMapping("/updatepreferredVendors/{id}")
//    public Preferredvendor updatePreferredvendor(@PathVariable int id, @RequestBody Preferredvendor preferredvendor) {
//        preferredvendor.setId(id); // Assuming Preferredvendor entity has setId method
//        return dropdownService.updatePreferredvendor(preferredvendor);
//    }
//
//    @DeleteMapping("/deletepreferredVendors/{id}")
//    public void deletePreferredvendor(@PathVariable int id) {
//        dropdownService.deletePreferredvendor(id);
//    }
//    
// // Type
//    @GetMapping("/gettype")
//    public List<Type> getTypes() {
//        return dropdownService.getTypes();
//    }
//
//    @PostMapping("/addtypes")
//    public Type addType(@RequestBody Type type) {
//        return dropdownService.addType(type);
//    }
//
//    @PutMapping("/updatetypes/{id}")
//    public Type updateTpe(@PathVariable int id, @RequestBody Type type) {
//        type.setId(id); 
//        return dropdownService.updateType(type);
//    }
//
//    @DeleteMapping("/deletetypes/{id}")
//    public void deleteType(@PathVariable int id) {
//        dropdownService.deleteType(id);
//    }
//}









package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.*;
import com.sample.service.DropdownService;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drop")
public class DropdownController {

    @Autowired
    private DropdownService dropdownService;

  //Post Api To Add Only Category Details only
    @PostMapping("/addcategorydetailsonly")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO2 categoryDTO2) {
        Category category = dropdownService.addCategory(categoryDTO2);
        return ResponseEntity.ok(category);
    }
    
 // Post Api To Display Only ID AND NAMES LIST
    @PostMapping("/get-id-namesofcategory")
    public List<CategoryDTO3> getCategoryIdAndNames() {
        return dropdownService.getCategoryIdAndNames();
    }
    
    // Post Api To Display List Of Category Details
    @PostMapping("/displaylistofcategorydetailsonly")
    public List<CategoryDTO4> getCategoryDetails() {
        return dropdownService.getAllCategories();
    }
    
    // Get Categories (now using POST)
    @PostMapping("/getcategories")
    public ResponseEntity<List<Category>> getCategories(@RequestBody (required = false) Map<String, Object> request) {

    	List<Category> categories = dropdownService.getCategories();
    	return ResponseEntity.ok( categories);
    }
    
    // Add Category
    @PostMapping("/addcategories")
    public Category addCategory(@RequestBody Category category) {
        return dropdownService.addCategory(category);
    }

 // Update Category (now using POST)
    @PostMapping("/updatecategories/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setId(id); // Assuming Category entity has setId method
        return dropdownService.updateCategory(category);
    }
    
    // Delete Category (now using POST)
    @PostMapping("/deletecategories")
    public ResponseEntity<Void> deleteCategory(@RequestBody Map<String, Object> request) {
    	int id = Integer.parseInt(request.get("id").toString());

        dropdownService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

 // Type
    @PostMapping("/getalltype")
    public ResponseEntity<List<Type>> getTypes(@RequestBody(required = false) Map<String, Object> request) {
    	 List<Type> types = dropdownService.getTypes();
    	 return ResponseEntity.ok(types);
  }
  
    @PostMapping("/addtypes")
  public Type addType(@RequestBody Type type) {
      return dropdownService.addType(type);
  }	

    @PostMapping("/updatetypes/{id}")
    public Type updateType(@PathVariable int id, @RequestBody Type type) {
        type.setId(id); // Assuming Category entity has setId method
        return dropdownService.updateType(type);
    }
 
  @PostMapping("/deletetypes")
  public ResponseEntity<Void> deleteType(@RequestBody Map<String, Object> request) {
	  int id = Integer.parseInt(request.get("id").toString());
	  dropdownService.deleteType(id);
      return ResponseEntity.noContent().build();
  }
  
}
 


=======
package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.*;
import com.sample.service.DropdownService;

import java.util.List;

@RestController
@RequestMapping("/drop")
//@CrossOrigin(origins = "*")
public class DropdownController {

    @Autowired
    private DropdownService dropdownService;

    // Category
    @GetMapping("/getcategories")
    public List<Category> getCategories() {
        return dropdownService.getCategories();
    }

    @PostMapping("/addcategories")
    public Category addCategory(@RequestBody Category category) {
        return dropdownService.addCategory(category);
    }

    @PutMapping("/updatecategories/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setId(id); // Assuming Category entity has setId method
        return dropdownService.updateCategory(category);
    }

    @DeleteMapping("/deletecategories/{id}")
    public void deleteCategory(@PathVariable int id) {
        dropdownService.deleteCategory(id);
    }

    // Asset Account
    @GetMapping("/getassetAccounts")
    public List<Assetaccount> getAssetaccounts() {
        return dropdownService.getAssetaccounts();
    }

    @PostMapping("/addassetAccounts")
    public Assetaccount addAssetaccount(@RequestBody Assetaccount assetaccount) {
        return dropdownService.addAssetaccount(assetaccount);
    }

    @PutMapping("/updateassetAccounts/{id}")
    public Assetaccount updateAssetaccount(@PathVariable int id, @RequestBody Assetaccount assetaccount) {
        assetaccount.setId(id); // Assuming Assetaccount entity has setId method
        return dropdownService.updateAssetAccount(assetaccount);
    }

    @DeleteMapping("/deleteassetAccounts/{id}")
    public void deleteAssetaccount(@PathVariable int id) {
        dropdownService.deleteAssetaccount(id);
    }

    // Income Account
    @GetMapping("/getincomeAccounts")
    public List<Incomeaccount> getIncomeaccounts() {
        return dropdownService.getIncomeaccounts();
    }

    @PostMapping("/addincomeAccounts")
    public Incomeaccount addIncomeAccount(@RequestBody Incomeaccount incomeaccount) {
        return dropdownService.addIncomeaccount(incomeaccount);
    }

    @PutMapping("/updateincomeAccounts/{id}")
    public Incomeaccount updateIncomeaccount(@PathVariable int id, @RequestBody Incomeaccount incomeaccount) {
        incomeaccount.setId(id); // Assuming Incomeaccount entity has setId method
        return dropdownService.updateIncomeaccount(incomeaccount);
    }

    @DeleteMapping("/deleteincomeAccounts/{id}")
    public void deleteIncomeaccount(@PathVariable int id) {
        dropdownService.deleteIncomeaccount(id);
    }

    // Expense Account
    @GetMapping("/getexpenseAccounts")
    public List<Expenseaccount> getExpenseAccounts() {
        return dropdownService.getExpenseaccounts();
    }

    @PostMapping("/addexpenseAccounts")
    public Expenseaccount addExpenseaccount(@RequestBody Expenseaccount expenseaccount) {
        return dropdownService.addExpenseaccount(expenseaccount);
    }

    @PutMapping("/updateexpenseAccounts/{id}")
    public Expenseaccount updateExpenseaccount(@PathVariable int id, @RequestBody Expenseaccount expenseaccount) {
        expenseaccount.setId(id); // Assuming Expenseaccount entity has setId method
        return dropdownService.updateExpenseaccount(expenseaccount);
    }


    @DeleteMapping("/deleteexpenseAccounts/{id}")
    public void deleteExpenseaccount(@PathVariable int id) {
        dropdownService.deleteExpenseaccount(id);
    }

    // Preferred Vendor
    @GetMapping("/getpreferredVendors")
    public List<Preferredvendor> getPreferredVendors() {
        return dropdownService.getPreferredvendors();
    }

    @PostMapping("/addpreferredVendors")
    public Preferredvendor addPreferredVendor(@RequestBody Preferredvendor preferredVendor) {
        return dropdownService.addPreferredvendor(preferredVendor);
    }

    @PutMapping("/updatepreferredVendors/{id}")
    public Preferredvendor updatePreferredvendor(@PathVariable int id, @RequestBody Preferredvendor preferredvendor) {
        preferredvendor.setId(id); // Assuming Preferredvendor entity has setId method
        return dropdownService.updatePreferredvendor(preferredvendor);
    }

    @DeleteMapping("/deletepreferredVendors/{id}")
    public void deletePreferredvendor(@PathVariable int id) {
        dropdownService.deletePreferredvendor(id);
    }
    
 // Type
    @GetMapping("/gettype")
    public List<Type> getTypes() {
        return dropdownService.getTypes();
    }

    @PostMapping("/addtypes")
    public Type addType(@RequestBody Type type) {
        return dropdownService.addType(type);
    }

    @PutMapping("/updatetypes/{id}")
    public Type updateTpe(@PathVariable int id, @RequestBody Type type) {
        type.setId(id); 
        return dropdownService.updateType(type);
    }

    @DeleteMapping("/deletetypes/{id}")
    public void deleteType(@PathVariable int id) {
        dropdownService.deleteType(id);
    }
}
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
