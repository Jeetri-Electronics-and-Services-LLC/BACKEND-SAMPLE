package com.sample.service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Bundle;
import com.sample.entity.BundleRequestDTO;
import com.sample.entity.ProductRequestDTO;
import com.sample.entity.Products;
=======

import java.util.List;

//
//import com.sample.entity.Bundle;

//import com.sample.entity.ReqBody;
//import com.sample.repository.BundleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//
//@Service
//public class BundleService {
//
//    @Autowired
//    private BundleRepository bundleRepository;
//
//    /*Read Operation*/
//    public List<Bundle> getAllBundles() {
//        return bundleRepository.findAll();
//    }
//
//    
//    /*Create operation*/
//    public void addBundle(ReqBody bundle) {
//        Bundle newBundle = new Bundle();
//        
//        newBundle.setName(bundle.getName());
//        newBundle.setSku(bundle.getSku());
//        newBundle.setDescription(bundle.getDescription());
//        newBundle.setProducts_id(bundle.getProducts_id());
//        
//        bundleRepository.save(newBundle);
//        
//        System.out.println("Bundle data added successfully");
//    }
//    
//
//    /*Update operation*/
//    public void updateBundle(Bundle updatedBundle, int id) {
//        Bundle existingBundle = bundleRepository.findById(id).orElse(null);
//        
//        if (existingBundle != null) {
//            existingBundle.setName(updatedBundle.getName());
//            existingBundle.setSku(updatedBundle.getSku());
//            existingBundle.setDescription(updatedBundle.getDescription());
//            existingBundle.setProducts_id(updatedBundle.getProducts_id());;
//            bundleRepository.save(existingBundle);
//            System.out.println("Bundle data updated successfully");
//        }
//    }
//    
//    
//    /*Delete operation*/
//    public void deleteBundle(int id) {
//        bundleRepository.deleteById(id);
//        System.out.println("Bundle Data Deleted Successfully");
//    }
//}





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Bundle;
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
import com.sample.repository.BundleRepository;

@Service
public class BundleService {

    @Autowired
    private BundleRepository bundleRepository;
    
    /*Read Operation*/
<<<<<<< HEAD
//  public List<Bundle> getAllBundles() {
//     return bundleRepository.findAll();
// }

  // Add Operation
=======
  public List<Bundle> getAllBundles() {
     return bundleRepository.findAll();
 }

>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
    public Bundle saveBundle(Bundle bundle) {
        return bundleRepository.save(bundle);
    }

<<<<<<< HEAD
    //Update operation
//    public Bundle updateBundle(Long id, Bundle bundle) throws Exception {
//        if (!bundleRepository.existsById(id)) {
//            throw new Exception("Bundle not found with id " + id);
//        }
//        bundle.setId(id);
//        return bundleRepository.save(bundle);
//        
//    }
    
 // Delete operation
    public void deleteBundle(Long id) throws Exception {
        if (!bundleRepository.existsById(id)) {
            throw new Exception("Bundle not found with id " + id);
        }
        bundleRepository.deleteById(id);
    }
    
    // bundle with products
    public Bundle createBundleWithProducts(BundleRequestDTO bundleRequest) {
    	 Bundle bundle = new Bundle();
    	 bundle.setName(bundleRequest.getName());
    	 bundle.setSku(bundleRequest.getSku());
    	 bundle.setDescription(bundleRequest.getDescription());
    	 List<ProductRequestDTO> productRequests = bundleRequest.getProducts();
    	 List<Products> products = new ArrayList<>();
    	 for (ProductRequestDTO productRequest : productRequests) {
    	 Products product = new Products();
    	 product.setProductid(productRequest.getProductid());
    	 product.setName(productRequest.getName());
    	 product.setDescription(productRequest.getDescription());
    	 product.setQty(productRequest.getQty());
    	 product.setSalesprice(productRequest.getSalesprice());
    	 product.setAmount(productRequest.getAmount());
  	     product.setBundle(bundle);
    	 products.add(product);
    	 }
    	 bundle.setProducts(products);
    	 return bundleRepository.save(bundle);
    	 }
    	
    public List<Bundle> getAllBundles() {
    	 return bundleRepository.findAll();
    	 }
    	
    public void deleteBundleById(Long id) {
    	 bundleRepository.deleteById(id);
    	 }
    
    public Optional<Bundle> findBundleById(Long id) {
        return bundleRepository.findById(id);
    }
    
    public Optional<Bundle> findBundleByName(String name) {
        return bundleRepository.findByNameWithProducts(name);
    }
    
    //list of products based on bundle name
//    public List<Products> findProductsByBundleName(String name) {
//        return bundleRepository.findByNameWithProducts(name)
//                .map(bundle -> bundle.getProducts())  // Retrieve products only
//                .orElse(null);  // Return null if no bundle is found
//    }
    

    public Bundle updateBundle(Long bundleId, Bundle updatedBundle) {
        Optional<Bundle> existingBundleOpt = bundleRepository.findByIdWithProducts(bundleId);

        if (existingBundleOpt.isPresent()) {
            Bundle existingBundle = existingBundleOpt.get();

            // Update bundle details
            existingBundle.setName(updatedBundle.getName());
            existingBundle.setSku(updatedBundle.getSku());
            existingBundle.setDescription(updatedBundle.getDescription());

            // Update products
            updateProducts(existingBundle, updatedBundle.getProducts());

            // Save the updated bundle
            return bundleRepository.save(existingBundle);
        }

        return null; // or throw a BundleNotFoundException
    }

    private void updateProducts(Bundle existingBundle, List<Products> updatedProducts) {
        // Remove products not in the updated list
        Iterator<Products> iterator = existingBundle.getProducts().iterator();
        while (iterator.hasNext()) {
            Products existingProduct = iterator.next();
            boolean existsInUpdated = updatedProducts.stream()
                    .anyMatch(updatedProduct -> updatedProduct.getId() != null && updatedProduct.getId().equals(existingProduct.getId()));
            
            if (!existsInUpdated) {
                iterator.remove(); // Remove product from the bundle
            }
        }

        // Update or add products
        for (Products updatedProduct : updatedProducts) {
            Optional<Products> existingProductOpt = existingBundle.getProducts().stream()
                    .filter(p -> p.getId() != null && p.getId().equals(updatedProduct.getId()))
                    .findFirst();

            if (existingProductOpt.isPresent()) {
                Products existingProduct = existingProductOpt.get();
                // Update existing product details
                existingProduct.setProductid(updatedProduct.getProductid());
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setQty(updatedProduct.getQty());
                existingProduct.setSalesprice(updatedProduct.getSalesprice());
                existingProduct.setAmount(updatedProduct.getAmount());
            } else {
                // New product, add to bundle
                updatedProduct.setBundle(existingBundle);
                existingBundle.getProducts().add(updatedProduct);
            }
        }
    }
    
    public List<String> getAllBundleNames() {
        List<Bundle> bundles = bundleRepository.findAll();
        return bundles.stream()
                .map(Bundle::getName)
                .collect(Collectors.toList());
    }
    
    public List<Object[]> getBundleDetails(String bundleName) {
        return bundleRepository.findBundleDetailsByName(bundleName);
    }

=======
    public Bundle updateBundle(Long id, Bundle bundle) throws Exception {
        if (!bundleRepository.existsById(id)) {
            throw new Exception("Bundle not found with id " + id);
        }
        bundle.setId(id);
        return bundleRepository.save(bundle);
        
    }
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
}
