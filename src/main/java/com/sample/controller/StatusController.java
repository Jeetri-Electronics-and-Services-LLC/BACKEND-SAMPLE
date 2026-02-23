//package com.sample.controller;
//
//import com.sample.entity.Status;
//import com.sample.service.StatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/statuses")
//public class StatusController {
//
//    @Autowired
//    private StatusService statusService;
//
//    @GetMapping("/getallstatus")
//    public List<Status> getAllStatuses() {
//        return statusService.getAllStatuses();
//    }
//
//    @GetMapping("/getstatus/{id}")
//    public ResponseEntity<Status> getStatusById(@PathVariable Long id) {
//        Optional<Status> status = statusService.getStatusById(id);
//        return status.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addallstatus")
//    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
//        Status savedStatus = statusService.saveStatus(status);
//        return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/updateallstatus/{id}")
//    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
//        Status updatedStatus = statusService.updateStatus(id, status);
//        return ResponseEntity.ok(updatedStatus);
//    }
//
//    @DeleteMapping("/deleteallstatus/{id}")
//    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
//        statusService.deleteStatus(id);
//        return ResponseEntity.noContent().build();
//    }
//}










package com.sample.controller;

import com.sample.entity.City;
import com.sample.entity.Status;
import com.sample.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    @Autowired
    private StatusService statusService;

    // Change to POST and accept request with JSON payload
    @PostMapping("/getallstatus")
    public ResponseEntity<List<Status>> getAllStatuses() {
        List<Status> statuses = statusService.getAllStatuses();
        return ResponseEntity.ok(statuses);
    }

    // Change to POST and accept request with JSON payload
    @PostMapping("/getstatusbyid")
    public ResponseEntity<Status> getStatusById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        return statusService.getStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   

    // No changes here; already uses POST correctly
    @PostMapping("/addallstatus")
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status savedStatus = statusService.saveStatus(status);
        return new ResponseEntity<>(savedStatus, HttpStatus.CREATED);
    }

    // Change to POST and accept request with JSON payload
    @PostMapping("/updateallstatus/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();

        // Retrieve the existing city and update its name
    	Status existingStatus = statusService.getStatusById(id).orElse(null);
        if (existingStatus == null) {
            return ResponseEntity.notFound().build();
        }

        existingStatus.setName(name);
        Status updatedStatus = statusService.updateStatus(id, existingStatus);

        return ResponseEntity.ok(updatedStatus);
    }
    

    // Change to POST and accept request with JSON payload
    @PostMapping("/deleteallstatus")
    public ResponseEntity<String> deleteStatus(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	statusService.deleteStatus(id);
    	return new ResponseEntity<>("Status deleted successfully", HttpStatus.OK);
    }
    
}
