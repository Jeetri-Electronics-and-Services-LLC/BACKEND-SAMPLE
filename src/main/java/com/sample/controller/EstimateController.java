//package com.sample.controller;

//
//import com.sample.entity.Estimate;
//
//import com.sample.entity.EstimateDTO;
//import com.sample.entity.EstimateResponseDTO;
//import com.sample.entity.EstimateUpdateDTO;
//import com.sample.service.EstimateService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/estimates")
//public class EstimateController {
//
//    @Autowired
//    private EstimateService estimateService;
//    
//    @PostMapping("/addestimate")
//    public ResponseEntity<Estimate> addEstimate(@RequestBody EstimateDTO estimateDTO) {
//        Estimate estimate = estimateService.addEstimate(estimateDTO);
//        return new ResponseEntity<>(estimate, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public List<Estimate> getAllEstimates() {
//        return estimateService.getAllEstimates();
//    }
//
//    @GetMapping("/estimatewitheproducts/{id}")
//    public ResponseEntity<EstimateResponseDTO> getEstimateById(@PathVariable Long id) {
//        EstimateResponseDTO estimate = estimateService.getEstimateById(id);
//        return ResponseEntity.ok(estimate);
//    }
//    
// 
//
//
//    @PutMapping("/updateestimate/{id}")
//    public ResponseEntity<Estimate> updateEstimate(@PathVariable Long id, @RequestBody EstimateUpdateDTO estimateUpdateDTO) {
//        if (!id.equals(estimateUpdateDTO.getId())) {
//            return ResponseEntity.badRequest().build();
//        }
//        Estimate updatedEstimate = estimateService.updateEstimate(estimateUpdateDTO);
//        return ResponseEntity.ok(updatedEstimate);
//    }
//    @DeleteMapping("/deleteestimate/{id}")
//    public ResponseEntity<Void> deleteEstimate(@PathVariable Long id) {
//        estimateService.deleteEstimate(id);
//        return ResponseEntity.noContent().build();
//    }

//@GetMapping("/estimateparticularprod/{estimateId}")
//    public ResponseEntity<EstimateDTO1> getEstimateDetails(@PathVariable Long estimateId) {
//        EstimateDTO1 estimateDTO = estimateService.getEstimateDetails(estimateId);
//        if (estimateDTO == null) {
//            return ResponseEntity.notFound().build(); // If Estimate is not found
//        }
//        return ResponseEntity.ok(estimateDTO);
//    }
//}





package com.sample.controller;

import com.sample.entity.Brand;
import com.sample.entity.City;
import com.sample.entity.Estimate;
import com.sample.entity.EstimateDTO;
import com.sample.entity.EstimateDTO1;
import com.sample.entity.EstimateDTO2;
import com.sample.entity.EstimateResponseDTO;
import com.sample.entity.EstimateUpdateDTO;
import com.sample.service.EstimateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/estimates")
public class EstimateController {

    @Autowired
    private EstimateService estimateService;

    @PostMapping("/addestimate")
    public ResponseEntity<Estimate> addEstimate(@RequestBody EstimateDTO estimateDTO) {
        Estimate estimate = estimateService.addEstimate(estimateDTO);
        return new ResponseEntity<>(estimate, HttpStatus.CREATED);
    }

    @PostMapping("/getallestimates")
    public ResponseEntity<List<Estimate>> getAllEstimates() {
        List<Estimate> estimates = estimateService.getAllEstimates();
        return ResponseEntity.ok(estimates);
    }

    @PostMapping("/getestimatewitheproductsbyid")
    public ResponseEntity<EstimateResponseDTO> getEstimateById(@RequestBody Map<String, Object> request) {
        Long id = Long.parseLong(request.get("id").toString());
        EstimateResponseDTO estimate = estimateService.getEstimateById(id);

        if (estimate != null) {
            return ResponseEntity.ok(estimate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

 

    @PostMapping("/updateestimate/{id}")
    public ResponseEntity<Estimate> updateEstimate(@PathVariable Long id, @RequestBody EstimateUpdateDTO estimateUpdateDTO) {
        if (!id.equals(estimateUpdateDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Estimate updatedEstimate = estimateService.updateEstimate(estimateUpdateDTO);
        return ResponseEntity.ok(updatedEstimate);
    }

    @PostMapping("/deleteestimate")
    public ResponseEntity<Void> deleteEstimate(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        estimateService.deleteEstimate(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/estimateparticularprod")
    public ResponseEntity<EstimateDTO1> getEstimateDetails(@RequestBody Map<String, Object> request) {
        Long estimateId = Long.parseLong(request.get("estimateId").toString());  // Changed to estimateId
        EstimateDTO1 estimateDTO = estimateService.getEstimateDetails(estimateId);
        if (estimateDTO == null) {
            return ResponseEntity.notFound().build(); // If Estimate is not found
        }
        return ResponseEntity.ok(estimateDTO);
    }
    
    // Display List of All Estimate Particular Fields - Estimate Report
    @PostMapping("/displaylistofestimateparticularfields")
    public List<EstimateDTO2> getAllEstimates1() {
        return estimateService.getAllEstimates1();
    }
    
    
}
