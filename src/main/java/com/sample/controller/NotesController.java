//package com.sample.controller;


//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sample.entity.Notes;
//import com.sample.entity.NotesDTO;
//import com.sample.entity.NotesDTO1;
//import com.sample.service.NotesService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/notes")
//public class NotesController {
//
//    @Autowired
//    private NotesService notesService;
//    
//    @PostMapping("/addnotes")
//    public ResponseEntity<Notes> addNotes(@RequestBody NotesDTO notesDTO) {
//        Notes savedNotes = notesService.addNotes(notesDTO);
//        return new ResponseEntity<>(savedNotes, HttpStatus.CREATED);
//    }
//    
//    @GetMapping("/displaylistofnotesdetailsbycustomerid/{customerId}")
//    public ResponseEntity<List<NotesDTO1>> getNotesByCustomerId(@PathVariable Long customerId) {
//        List<NotesDTO1> notes = notesService.getNotesByCustomerId(customerId);
//        return ResponseEntity.ok(notes);
//    }
//
//    // Get all notes
//    @GetMapping
//    public ResponseEntity<List<Notes>> getAllNotes() {
//        List<Notes> notes = notesService.getAllNotes();
//        return ResponseEntity.ok(notes);
//    }
//
//    // Get note by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Notes> getNoteById(@PathVariable Long id) {
//        return notesService.getNoteById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    // Create or update note
//    @PostMapping
//    public ResponseEntity<Notes> createOrUpdateNote(@RequestBody Notes note) {
//        Notes savedNote = notesService.createOrUpdateNote(note);
//        return ResponseEntity.ok(savedNote);
//    }
//
//    // Delete note by ID
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
//        notesService.deleteNoteById(id);
//        return ResponseEntity.noContent().build();
//    }

//@GetMapping("/recent-status/{customerId}")
//    public ResponseEntity<CustomerStatusDTO> getRecentCustomerStatus(@PathVariable Long customerId) {
//        CustomerStatusDTO recentStatus = notesService.getRecentCustomerStatus(customerId);
//
//        if (recentStatus != null) {
//            return ResponseEntity.ok(recentStatus); // Return the result with 200 OK
//        } else {
//            return ResponseEntity.notFound().build(); // Return 404 if no data is found
//        }
//    }

// @GetMapping("/recent")
//    public List<RecentCustomerNoteDTO> getRecentCustomerNotes() {
//        return notesService.getRecentCustomerNotes();
//    }

//}








package com.sample.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.Notes;
import com.sample.entity.NotesDTO;
import com.sample.entity.NotesDTO1;
import com.sample.entity.RecentCustomerNoteDTO;
import com.sample.service.NotesService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;
    
    @PostMapping("/addnotes")
    public ResponseEntity<Notes> addNotes(@RequestBody NotesDTO notesDTO) {
        Notes savedNotes = notesService.addNotes(notesDTO);
        return new ResponseEntity<>(savedNotes, HttpStatus.CREATED);
    }
    
 // Display list of notes details by customer ID
    @PostMapping("/displaylistofnotesdetailsbycustomerid")
    public ResponseEntity<List<NotesDTO1>> getNotesByCustomerId(@RequestBody Map<String, Long> request) {
        Long customerId = request.get("customerId");
        List<NotesDTO1> notes = notesService.getNotesByCustomerId(customerId);
        return ResponseEntity.ok(notes);
    }

    // Get all notes
    @PostMapping("/getallnotes")
    public ResponseEntity<List<Notes>> getAllNotes() {
        List<Notes> notes = notesService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Get note by ID
    @PostMapping("/getnotebyid")
    public ResponseEntity<Notes> getNoteById(@RequestBody Long id) {
        return notesService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update note
    @PostMapping("/createorupdatenote")
    public ResponseEntity<Notes> createOrUpdateNote(@RequestBody Notes note) {
        Notes savedNote = notesService.createOrUpdateNote(note);
        return ResponseEntity.ok(savedNote);
    }

    // Delete note by ID
    @PostMapping("/deletenotebyid")
    public ResponseEntity<Void> deleteNoteById(@RequestBody Map<String, Object> request) {
    	Long id = Long.parseLong(request.get("id").toString());
        notesService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
    
    
 //Post Api to get Recent CustomerStatus and createddate of Customers
    @PostMapping("/recent")
    public ResponseEntity<List<RecentCustomerNoteDTO>> getRecentCustomerNotes() {
    	List<RecentCustomerNoteDTO> notes = notesService.getRecentCustomerNotes();
    	return ResponseEntity.ok(notes);
       
    }
    
    

    
    
}

