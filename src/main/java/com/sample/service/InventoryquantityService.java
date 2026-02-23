package com.sample.service;

import com.sample.entity.Createproduct;
import com.sample.entity.InventoryQuantityDTO;
import com.sample.entity.InventoryQuantityDTO1;
import com.sample.entity.Inventoryquantity;
import com.sample.repository.CreateproductRepository;
import com.sample.repository.InventoryquantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryquantityService {

    @Autowired
    private InventoryquantityRepository repository;
    
    @Autowired
    private CreateproductRepository createproductRepository;

   
    public Inventoryquantity createInventoryquantity(Inventoryquantity inventoryquantity) {
        return repository.save(inventoryquantity);
    }

    public List<Inventoryquantity> getAllInventoryquantities() {
        return repository.findAll();
    }

    public Optional<Inventoryquantity> getInventoryquantityById(Long productid) {
        return repository.findById(productid);
    }

    public Inventoryquantity updateInventoryquantity(Long productid, Inventoryquantity inventoryquantityDetails) {
        Optional<Inventoryquantity> optionalInventory = repository.findById(productid);
        if (optionalInventory.isPresent()) {
            Inventoryquantity existingInventory = optionalInventory.get();
            existingInventory.setProductname(inventoryquantityDetails.getProductname());
            existingInventory.setExistingquantity(inventoryquantityDetails.getExistingquantity());
            existingInventory.setAddedquantity(inventoryquantityDetails.getAddedquantity());
            existingInventory.setTotalavailablequantity(inventoryquantityDetails.getTotalavailablequantity());
            existingInventory.setCreateddate(inventoryquantityDetails.getCreateddate());
            existingInventory.setCreatedby(inventoryquantityDetails.getCreatedby());
            return repository.save(existingInventory);
        } else {
            return null;
        }
    }

    public boolean deleteInventoryquantity(Long productid) {
        if (repository.existsById(productid)) {
            repository.deleteById(productid);
            return true;
        }
        return false;
    }
    
  //Add IventoryQuantity Details Based on product Id and change the quantity value of createproducttable to totalavailablequantity value in inventotyquantitytable
    public String addInventory(Long productId, InventoryQuantityDTO1 inventoryDTO1) {
        Createproduct createproduct = createproductRepository.findById(productId).orElse(null);

        if (createproduct == null) {
            throw new IllegalArgumentException("Product not found for productId: " + productId);
        }

        Inventoryquantity inventoryData = new Inventoryquantity();
        inventoryData.setProductid(productId);
        inventoryData.setProductname(inventoryDTO1.getProductname());
        inventoryData.setExistingquantity(inventoryDTO1.getExistingquantity());
        inventoryData.setAddedquantity(inventoryDTO1.getAddedquantity());
        inventoryData.setTotalavailablequantity(inventoryDTO1.getTotalavailablequantity());
        inventoryData.setCreateddate(inventoryDTO1.getCreateddate());
        inventoryData.setCreatedby(inventoryDTO1.getCreatedby());
        inventoryData.setCreateproduct(createproduct);

        repository.save(inventoryData);

        createproduct.setQuantity(inventoryDTO1.getTotalavailablequantity());
        createproductRepository.save(createproduct);

        return "Inventory added successfully and product quantity updated.";
    }
    
    public List<InventoryQuantityDTO> getInventoryQuantities() {
        List<Inventoryquantity> inventoryQuantities = repository.findAll();

        return inventoryQuantities.stream().map(inventory -> new InventoryQuantityDTO(
                inventory.getProductid(),
                inventory.getProductname(),
                inventory.getAddedquantity(),
                inventory.getCreateddate(),
                inventory.getCreatedby()
        )).collect(Collectors.toList());
    }
}