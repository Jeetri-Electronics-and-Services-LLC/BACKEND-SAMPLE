package com.sample.service;

import com.sample.entity.History;
import com.sample.entity.HistoryDetailsDTO;
import com.sample.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }

    public Optional<History> getHistoryById(Long id) {
        return historyRepository.findById(id);
    }

    public History saveHistory(History history) {
        return historyRepository.save(history);
    }

    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }
    
    
    public List<HistoryDetailsDTO> getAllHistoryDetails() {
        List<Object[]> historyDetails = historyRepository.findAllHistoryDetails();

        return historyDetails.stream()
                .map(record -> new HistoryDetailsDTO(
                        (Long) record[0],  // id
                        (String) record[1],  // createddate
                        (String) record[2],  // createdby
                        (String) record[3],  // notes
                        (String) record[4])) // followupdate
                .collect(Collectors.toList());
    }
}
