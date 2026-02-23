//package com.sample.controller;
//
//import com.sample.entity.Estimatestatus;
//import com.sample.service.EstimatestatusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/estimatestatuses")
//public class EstimatestatusController {
//
//    @Autowired
//    private EstimatestatusService estimatestatusService;
//
//    @GetMapping
//    public List<Estimatestatus> getAllEstimatestatuses() {
//        return estimatestatusService.getAllEstimatestatuses();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Estimatestatus> getEstimatestatusById(@PathVariable Long id) {
//        Optional<Estimatestatus> estimatestatus = estimatestatusService.getEstimatestatusById(id);
//        return estimatestatus.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public Estimatestatus createEstimatestatus(@RequestBody Estimatestatus estimatestatus) {
//        return estimatestatusService.createOrUpdateEstimatestatus(estimatestatus);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Estimatestatus> updateEstimatestatus(@PathVariable Long id, @RequestBody Estimatestatus estimatestatus) {
//        if (!estimatestatusService.getEstimatestatusById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        estimatestatus.setId(id);
//        Estimatestatus updatedEstimatestatus = estimatestatusService.createOrUpdateEstimatestatus(estimatestatus);
//        return ResponseEntity.ok(updatedEstimatestatus);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEstimatestatus(@PathVariable Long id) {
//        if (!estimatestatusService.getEstimatestatusById(id).isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        estimatestatusService.deleteEstimatestatus(id);
//        return ResponseEntity.noContent().build();
//    }
//}





package com.sample.controller;

import com.sample.entity.Estimatestatus;
import com.sample.service.EstimatestatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estimatestatuses")
public class EstimatestatusController {

    @Autowired
    private EstimatestatusService estimatestatusService;

    @PostMapping("/getAllestimatestatuses")
    public List<Estimatestatus> getAllEstimatestatuses() {
        return estimatestatusService.getAllEstimatestatuses();
    }

    @PostMapping("/getByIdestimatestatuses")
    public ResponseEntity<Estimatestatus> getEstimatestatusById(@RequestParam Long id) {
        Optional<Estimatestatus> estimatestatus = estimatestatusService.getEstimatestatusById(id);
        return estimatestatus.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/createestimatestatuses")
    public Estimatestatus createEstimatestatus(@RequestBody Estimatestatus estimatestatus) {
        return estimatestatusService.createOrUpdateEstimatestatus(estimatestatus);
    }

    @PostMapping("/updateestimatestatuses")
    public ResponseEntity<Estimatestatus> updateEstimatestatus(@RequestParam Long id, @RequestBody Estimatestatus estimatestatus) {
        if (!estimatestatusService.getEstimatestatusById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estimatestatus.setId(id);
        Estimatestatus updatedEstimatestatus = estimatestatusService.createOrUpdateEstimatestatus(estimatestatus);
        return ResponseEntity.ok(updatedEstimatestatus);
    }

    @PostMapping("/deleteestimatestatuses")
    public ResponseEntity<Void> deleteEstimatestatus(@RequestParam Long id) {
        if (!estimatestatusService.getEstimatestatusById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estimatestatusService.deleteEstimatestatus(id);
        return ResponseEntity.noContent().build();
    }
}
