<<<<<<< HEAD
package com.sample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.entity.Services;
import com.sample.service.ServiceService;

@RestController
@RequestMapping("/servicesdata")
public class ServicesController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/servicesdata/get")
    public List<Services> getAllServiceData() {
        return serviceService.getAllServices();
    }

    @PostMapping("/addservicesdata")
   
    public void addServices(@RequestBody Services services) {
        serviceService.addServices(services);
    }

    @PutMapping("/updateservicedata/{id}")
    
    public void updateService(@RequestBody Services services, @PathVariable int id) {
        serviceService.updateService(services, id);
    }

    @DeleteMapping("/deleteservicedata/{id}")
   
    public void deleteInventory(@PathVariable int id) {
        serviceService.deleteService(id);
    }
}
=======
package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Services;
import com.sample.service.ServiceService;

@RestController
@RequestMapping("/servicesdata")
public class ServicesController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/servicesdata/get")
    public List<Services> getAllServiceData() {
        return serviceService.getAllServices();
    }

    @PostMapping("/addservicesdata")
    @PreAuthorize("hasRole('ADMIN')")
    public void addServices(@RequestBody Services services) {
        serviceService.addServices(services);
    }

    @PutMapping("/updateservicedata/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateService(@RequestBody Services services, @PathVariable int id) {
        serviceService.updateService(services, id);
    }

    @DeleteMapping("/deleteservicedata/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteInventory(@PathVariable int id) {
        serviceService.deleteService(id);
    }
}
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
