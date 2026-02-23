package com.sample.controller;

import com.sample.entity.Cc;
import com.sample.service.CcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cc")
public class CcController {

    @Autowired
    private CcService ccService;

    @GetMapping("/getallcc")
    public List<Cc> getAllCc() {
        return ccService.getAllCc();
    }

    @GetMapping("/getcc/{id}")
    public ResponseEntity<Cc> getCcById(@PathVariable Long id) {
        Optional<Cc> cc = ccService.getCcById(id);
        return cc.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addcc")
    public ResponseEntity<Cc> createCc(@RequestBody Cc cc) {
        Cc savedCc = ccService.saveCc(cc);
        return new ResponseEntity<>(savedCc, HttpStatus.CREATED);
    }

    @PutMapping("/updatecc/{id}")
    public ResponseEntity<Cc> updateCc(@PathVariable Long id, @RequestBody Cc cc) {
        Cc updatedCc = ccService.updateCc(id, cc);
        return ResponseEntity.ok(updatedCc);
    }

    @DeleteMapping("/deletecc/{id}")
    public ResponseEntity<Void> deleteCc(@PathVariable Long id) {
        ccService.deleteCc(id);
        return ResponseEntity.noContent().build();
    }
}
