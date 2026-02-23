package com.sample.controller;

import com.sample.entity.History;
import com.sample.entity.HistoryDetailsDTO;
import com.sample.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/getallhistory")
    public List<History> getAllHistories() {
        return historyService.getAllHistories();
    }

    @GetMapping("/gethistorybyid/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable Long id) {
        Optional<History> history = historyService.getHistoryById(id);
        return history.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addhistory")
    public History createHistory(@RequestBody History history) {
        return historyService.saveHistory(history);
    }

    @PutMapping("/updatehistory/{id}")
    public ResponseEntity<History> updateHistory(@PathVariable Long id, @RequestBody History history) {
        if (!historyService.getHistoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        history.setId(id);
        return ResponseEntity.ok(historyService.saveHistory(history));
    }

    @DeleteMapping("/deletehistory/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable Long id) {
        if (!historyService.getHistoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        historyService.deleteHistory(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/details")
    public List<HistoryDetailsDTO> getHistoryDetails() {
        return historyService.getAllHistoryDetails();
    }
    
    
}
