package com.sample.service;

import com.sample.entity.Cc;
import com.sample.repository.CcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CcService {

    @Autowired
    private CcRepository ccRepository;

    public List<Cc> getAllCc() {
        return ccRepository.findAll();
    }

    public Optional<Cc> getCcById(Long id) {
        return ccRepository.findById(id);
    }

    public Cc saveCc(Cc cc) {
        return ccRepository.save(cc);
    }

    public Cc updateCc(Long id, Cc updatedCc) {
        return ccRepository.findById(id)
                .map(cc -> {
                    cc.setCc(updatedCc.getCc());
                    cc.setBcc(updatedCc.getBcc());
                    return ccRepository.save(cc);
                })
                .orElseGet(() -> {
                    updatedCc.setId(id);
                    return ccRepository.save(updatedCc);
                });
    }

    public void deleteCc(Long id) {
        ccRepository.deleteById(id);
    }
}
