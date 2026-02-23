
package com.sample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Inventory;
import com.sample.entity.ReqBody;
import com.sample.repository.InventoryRepository;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepo;
    
    /*Read operation*/
    public List<Inventory> getAllInventories() {
        return inventoryRepo.findAll();
    }
    
    /*Create operation*/
    public void addInventory(ReqBody inventory) {
        Inventory newInventory = new Inventory();
        newInventory.setDate(inventory.getDate());
        newInventory.setSku(inventory.getSku());
        newInventory.setDescription(inventory.getDescription());
        newInventory.setCategory_id(inventory.getCategory_id());
        newInventory.setName(inventory.getName());
        newInventory.setPurchasinginformation(inventory.getPurchasinginformation());
        newInventory.setReorder(inventory.getReorder());
        newInventory.setDescription(inventory.getDescription());
        newInventory.setAsset_account_id(inventory.getAsset_account_id());
        newInventory.setIncome_account_id(inventory.getIncome_account_id());
        newInventory.setCost(Double.valueOf(inventory.getCost()));
        newInventory.setPreferred_vendor_id(inventory.getPreferred_vendor_id());
        newInventory.setQuantity(Integer.valueOf(inventory.getQuantity()));
        newInventory.setReorder(String.valueOf(inventory.getReorder()));
        newInventory.setSalesprice(Double.valueOf(inventory.getSalesprice()));
        newInventory.setSalestax(Double.valueOf(inventory.getSalestax()));
        newInventory.setExpense_account_id(inventory.getExpense_account_id());
        newInventory.setType(inventory.getType());
        inventoryRepo.save(newInventory);
        
        System.out.println("Inventory data added successfully");
    }
    
    /*Update operation*/
    public void updateInventory(Inventory updatedInventory, int id) {
        Inventory existingInventory = inventoryRepo.findById(id).orElse(null);
        
        if (existingInventory != null) {
            existingInventory.setAsset_account_id(updatedInventory.getAsset_account_id());
            existingInventory.setType(updatedInventory.getType());
            existingInventory.setDate(updatedInventory.getDate());
            existingInventory.setName(updatedInventory.getName());
            existingInventory.setSku(updatedInventory.getSku());
            existingInventory.setCategory_id(updatedInventory.getCategory_id());
            existingInventory.setQuantity(updatedInventory.getQuantity());
            existingInventory.setReorder(updatedInventory.getReorder());
            existingInventory.setDescription(updatedInventory.getDescription());
            existingInventory.setSalesprice(updatedInventory.getSalesprice());
            existingInventory.setIncome_account_id(updatedInventory.getIncome_account_id());
            existingInventory.setSalestax(updatedInventory.getSalestax());
            existingInventory.setPurchasinginformation(updatedInventory.getPurchasinginformation());
            existingInventory.setCost(updatedInventory.getCost());
            existingInventory.setExpense_account_id(updatedInventory.getExpense_account_id());
            existingInventory.setPreferred_vendor_id(updatedInventory.getPreferred_vendor_id());
            inventoryRepo.save(existingInventory);
            System.out.println("Inventory data updated successfully");
        }
    }
    
    /*Delete operation*/
    public void deleteInventory(int id) {
        inventoryRepo.deleteById(id);
        System.out.println("Inventory Data Deleted Successfully");
    }
    
    /* Filter by type */
    public List<Inventory> getInventoryByType(String type) {
        return inventoryRepo.findAll().stream()
                            .filter(inventory -> type.equals(inventory.getType()))
                            .collect(Collectors.toList());
    }
}

