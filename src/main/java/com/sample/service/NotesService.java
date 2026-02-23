package com.sample.service;



import java.math.BigInteger;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sample.entity.Customer;
import com.sample.entity.Notes;
import com.sample.entity.NotesDTO;
import com.sample.entity.NotesDTO1;
import com.sample.entity.RecentCustomerNoteDTO;
import com.sample.repository.CustomerRepository;
import com.sample.repository.NotesRepository;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    public Notes addNotes(NotesDTO notesDTO) {
        Notes notes = new Notes();

        // Map DTO to entity
        notes.setCustomerdisplayname_id(notesDTO.getCustomerdisplayname_id());
        notes.setMobilenumber(notesDTO.getMobilenumber());
        notes.setCreatedby(notesDTO.getCreatedby());
        notes.setCreateddate(notesDTO.getCreateddate());
        notes.setCustomerstatus(notesDTO.getCustomerstatus());
        notes.setAddnotes(notesDTO.getAddnotes());

     // Set the customer based on the customerdisplayname_id
        String customerDisplayName = notesDTO.getCustomerdisplayname_id();
        Customer customer = customerRepository.findBycustomerdisplayname(customerDisplayName);
        if (customer != null) {
            notes.setCustomer(customer);  // Set the customer entity in the invoice
        } else {
            throw new IllegalArgumentException("Customer with display name " + customerDisplayName + " not found");
        }

        return notesRepository.save(notes);
    }

    public List<NotesDTO1> getNotesByCustomerId(Long customerId) {
        List<Notes> notes = notesRepository.findByCustomerId(customerId);
        return notes.stream().map(this::convertToDTO1).collect(Collectors.toList());
    }

    private NotesDTO1 convertToDTO1(Notes note) {
        NotesDTO1 dto = new NotesDTO1();
        dto.setId(note.getId());
        dto.setCustomerdisplayname_id(note.getCustomerdisplayname_id());
        dto.setMobilenumber(note.getMobilenumber());
        dto.setCreatedby(note.getCreatedby());
        dto.setCreateddate(note.getCreateddate());
        dto.setCustomerstatus(note.getCustomerstatus());
        dto.setAddnotes(note.getAddnotes());
        return dto;
    }
    
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Optional<Notes> getNoteById(Long id) {
        return notesRepository.findById(id);
    }

    public Notes createOrUpdateNote(Notes note) {
        return notesRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        notesRepository.deleteById(id);
    }
     
    //display only recent createddate and customerstatus of customers
    public List<RecentCustomerNoteDTO> getRecentCustomerNotes() {
        List<Object[]> results = notesRepository.findRecentNotesForCustomersNative();
        return results.stream()
            .map(record -> new RecentCustomerNoteDTO(
                ((Number) record[0]).longValue(), // Handle both Long and BigInteger
                record[1].toString(), 
                record[2].toString()))
            .collect(Collectors.toList());
    }



}

