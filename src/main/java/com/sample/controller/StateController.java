//package com.sample.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.entity.State;
//import com.sample.service.StateService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/states")
//public class StateController {
//
//    @Autowired
//    private StateService stateService;
//
//    @GetMapping("/getallstates")
//    public List<State> getAllStates() {
//        return stateService.getAllStates();
//    }
//
//    @GetMapping("/getstate/{id}")
//    public ResponseEntity<State> getStateById(@PathVariable Long id) {
//        return stateService.getStateById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/addstate")
//    public State createState(@RequestBody State state) {
//        return stateService.createState(state);
//    }
//
//    @PutMapping("/updatestate/{id}")
//    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody State stateDetails) {
//        return ResponseEntity.ok(stateService.updateState(id, stateDetails));
//    }
//
//    @DeleteMapping("/deletestate/{id}")
//    public ResponseEntity<Void> deleteState(@PathVariable Long id) {
//        stateService.deleteState(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//








package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.City;
import com.sample.entity.State;
import com.sample.service.StateService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping("/getallstates")
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = stateService.getAllStates();
        return ResponseEntity.ok(states);
    }

    @PostMapping("/getstatebyid")
    public ResponseEntity<State> getStateById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	return stateService.getStateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
   
    @PostMapping("/addstate")
    public ResponseEntity<State> createState(@RequestBody State state) {
        State createdState = stateService.createState(state);
        return ResponseEntity.ok(createdState);
    }

    @PostMapping("/updatestate/{id}")
    public ResponseEntity<State> updateState(@PathVariable Long id, @RequestBody Map<String, Object> request) {
    	String name = request.get("name").toString();

        // Retrieve the existing city and update its name
    	State existingState = stateService.getStateById(id).orElse(null);
        if (existingState == null) {
            return ResponseEntity.notFound().build();
        }

        existingState.setName(name);
        State updatedState = stateService.updateState(id, existingState);

        return ResponseEntity.ok(updatedState);
    }
    
    

    @PostMapping("/deletestate")
    public ResponseEntity<String> deleteState(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
    	stateService.deleteState(id);
    	return new ResponseEntity<>("State deleted successfully", HttpStatus.OK);
    }
    
}

