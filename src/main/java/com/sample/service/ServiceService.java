<<<<<<< HEAD
package com.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Services;
import com.sample.repository.ServicesRepository;

@Service
public class ServiceService {
	
	@Autowired
	private ServicesRepository serviceRepo;
	
	/*Read operation*/
	public List<Services> getAllServices(){
		return serviceRepo.findAll();	
	}
	
	/*create operation*/
    public void addServices(Services services) {
	serviceRepo.save(services);
	System.out.println("Service data added sucessfully");
    }

    /*update operation*/
    public void updateService(Services updatedService, int id) {
	Services existingServices=serviceRepo.findById(id).orElse(null);
	
	if(existingServices !=null) {
		existingServices.setName(updatedService.getName());
		existingServices.setSku(updatedService.getSku());
		existingServices.setCategory_id(updatedService.getCategory_id());
		existingServices.setDescription(updatedService.getDescription());
		existingServices.setSalesprice(updatedService.getSalesprice());
		existingServices.setIncome_account_id(updatedService.getIncome_account_id());
		existingServices.setSalestax(updatedService.getSalestax());
		serviceRepo.save(existingServices);
		System.out.println("service data updated successfully");		
	}		
}

/*Delete operation*/
public void deleteService(int id) {
	serviceRepo.deleteById(id);
	System.out.println("Service Data Deleted Successfully");
}

}
=======
package com.sample.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Services;
import com.sample.repository.ServicesRepository;

@Service
public class ServiceService {
	
	@Autowired
	private ServicesRepository serviceRepo;
	
	/*Read operation*/
	public List<Services> getAllServices(){
		return serviceRepo.findAll();	
	}
	
	/*create operation*/
public void addServices(Services services) {
	serviceRepo.save(services);
	System.out.println("Service data added sucessfully");
}

/*update operation*/
public void updateService(Services updatedService, int id) {
	Services existingServices=serviceRepo.findById(id).orElse(null);
	
	if(existingServices !=null) {
		existingServices.setName(updatedService.getName());
		existingServices.setSku(updatedService.getSku());
		existingServices.setCategory_id(updatedService.getCategory_id());
		existingServices.setDescription(updatedService.getDescription());
		existingServices.setSalesprice(updatedService.getSalesprice());
		existingServices.setIncome_account_id(updatedService.getIncome_account_id());
		existingServices.setSalestax(updatedService.getSalestax());
		//existingServices.setPurchasinginformation(updatedService.getPurchasinginformation());
		serviceRepo.save(existingServices);
		System.out.println("service data updated successfully");		
	}		
}

/*Delete operation*/

public void deleteService(int id) {
	serviceRepo.deleteById(id);
	System.out.println("Service Data Deleted Successfully");

}
}
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
