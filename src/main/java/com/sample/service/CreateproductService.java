package com.sample.service;

import com.sample.entity.CreateProductDTO;
import com.sample.entity.CreateProductDTO1;
import com.sample.entity.Createproduct;
import com.sample.entity.ProductDetailsDTO;
import com.sample.entity.ProductNameDTO;
import com.sample.entity.ProductsDTO;
import com.sample.repository.CreateproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateproductService {

    @Autowired
    private CreateproductRepository createproductRepository;

    public List<Createproduct> getAllProducts() {
        return createproductRepository.findAll();
    }

    public Optional<Createproduct> getProductById(Long id) {
        return createproductRepository.findById(id);
    }

    public Createproduct createProduct(Createproduct createproduct) {
        return createproductRepository.save(createproduct);
    }

//    public Createproduct updateProduct(Long id, Createproduct updatedProduct) {
//        Optional<Createproduct> existingProduct = createproductRepository.findById(id);
//        if (existingProduct.isPresent()) {
//            Createproduct product = existingProduct.get();
//            product.setType_id(updatedProduct.getType_id());
//            product.setName(updatedProduct.getName());
//            product.setSku(updatedProduct.getSku());
//            product.setQuantity(updatedProduct.getQuantity());
//            product.setDate(updatedProduct.getDate());
//            product.setReorder(updatedProduct.getReorder());
//            product.setDescription(updatedProduct.getDescription());
//            product.setMsrp(updatedProduct.getMsrp());
//            product.setSalesprice(updatedProduct.getSalesprice());
//            product.setDirectdealerprice(updatedProduct.getDirectdealerprice());
//            product.setPromotionaldealerprice(updatedProduct.getPromotionaldealerprice());
//            product.setIndirectdealerprice(updatedProduct.getIndirectdealerprice());
//            product.setPromotionalindirectdelarprice(updatedProduct.getPromotionalindirectdelarprice());
//            product.setDistributorprice(updatedProduct.getDistributorprice());
//            product.setPromotionaldistributorprice(updatedProduct.getPromotionaldistributorprice());
//            product.setCompanyprice(updatedProduct.getCompanyprice());
//            product.setCategory_id(updatedProduct.getCategory_id());
//            product.setBrand_id(updatedProduct.getBrand_id());
//            product.setPortfolio_id(updatedProduct.getPortfolio_id());
//            return createproductRepository.save(product);
//        } else {
//            return null;
//        }
//    }
    
    public Createproduct updateProduct(Long id, Createproduct productDetails) {
        Optional<Createproduct> existingProductOptional = createproductRepository.findById(id);
        
        if (existingProductOptional.isPresent()) {
            Createproduct existingProduct = existingProductOptional.get();
            
            // Update fields
            existingProduct.setType_id(productDetails.getType_id());
            existingProduct.setName(productDetails.getName());
            existingProduct.setSku(productDetails.getSku());
            existingProduct.setQuantity(productDetails.getQuantity());
            existingProduct.setDate(productDetails.getDate());
            existingProduct.setReorder(productDetails.getReorder());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setMsrp(productDetails.getMsrp());
            existingProduct.setSalesprice(productDetails.getSalesprice());
            existingProduct.setDirectdealerprice(productDetails.getDirectdealerprice());
            existingProduct.setPromotionaldealerprice(productDetails.getPromotionaldealerprice());
            existingProduct.setIndirectdealerprice(productDetails.getIndirectdealerprice());
            existingProduct.setPromotionalindirectdelarprice(productDetails.getPromotionalindirectdelarprice());
            existingProduct.setDistributorprice(productDetails.getDistributorprice());
            existingProduct.setPromotionaldistributorprice(productDetails.getPromotionaldistributorprice());
            existingProduct.setCompanyprice(productDetails.getCompanyprice());
            existingProduct.setCategory_id(productDetails.getCategory_id());
            existingProduct.setBrand_id(productDetails.getBrand_id());
            existingProduct.setPortfolio_id(productDetails.getPortfolio_id());

            // Save the updated product
            return createproductRepository.save(existingProduct);
        } else {
            // Handle the case where the product is not found
            throw new RuntimeException("Product not found with id: " + id);
        }
    }


    public void deleteProduct(Long id) {
        createproductRepository.deleteById(id);
         }
    
    
    public CreateproductService(CreateproductRepository createproductRepository) {
        this.createproductRepository = createproductRepository;
    }

    public List<ProductNameDTO> getAllProductNames() {
        return createproductRepository.findAllProductNames();
    }
   

    public ProductDetailsDTO getProductDetailsByName(String name) {
        return createproductRepository.findProductDetailsByName(name);
    }
    
    public ProductsDTO getProductDescriptionAndPrice(String name) {
        return createproductRepository.findProductDescriptionAndPriceByName(name);
    }
    
 // To Display Only Inventory Data
    public List<CreateProductDTO> getInventoryProducts() {
        return createproductRepository.findByTypeId("inventory")
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private CreateProductDTO convertToDTO(Createproduct product) {
        CreateProductDTO dto = new CreateProductDTO();
        dto.setId(product.getId());
        dto.setType_id(product.getType_id());
        dto.setName(product.getName());
        dto.setQuantity(product.getQuantity());       
        return dto;
    }
    
 // Add Product DEtails
    public Createproduct addCreateProduct(CreateProductDTO1 createProductDTO) {
        Createproduct createproduct = new Createproduct();
        createproduct.setType_id(createProductDTO.getType_id());
        createproduct.setName(createProductDTO.getName());
        createproduct.setSku(createProductDTO.getSku());
        createproduct.setQuantity(createProductDTO.getQuantity());
        createproduct.setDate(createProductDTO.getDate());
        createproduct.setReorder(createProductDTO.getReorder());
        createproduct.setDescription(createProductDTO.getDescription());
        createproduct.setMsrp(createProductDTO.getMsrp());
        createproduct.setSalesprice(createProductDTO.getSalesprice());
        createproduct.setDirectdealerprice(createProductDTO.getDirectdealerprice());
        createproduct.setPromotionaldealerprice(createProductDTO.getPromotionaldealerprice());
        createproduct.setIndirectdealerprice(createProductDTO.getIndirectdealerprice());
        createproduct.setPromotionalindirectdelarprice(createProductDTO.getPromotionalindirectdelarprice());
        createproduct.setDistributorprice(createProductDTO.getDistributorprice());
        createproduct.setPromotionaldistributorprice(createProductDTO.getPromotionaldistributorprice());
        createproduct.setCompanyprice(createProductDTO.getCompanyprice());
        createproduct.setCategory_id(createProductDTO.getCategory_id());
        createproduct.setBrand_id(createProductDTO.getBrand_id());
        createproduct.setPortfolio_id(createProductDTO.getPortfolio_id());
        return createproductRepository.save(createproduct);
    }
}
