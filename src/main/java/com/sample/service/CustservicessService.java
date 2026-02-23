package com.sample.service;

import com.sample.entity.CustservicessDTO;
import com.sample.entity.CustservicessResponseDTO;
import com.sample.entity.CustservicessResponseDTO1;
import com.sample.entity.ConnectiondetailsDTO;
import com.sample.entity.ConnectiondetailsDTO1;
import com.sample.entity.ConnectiondetailsResponseDTO;
import com.sample.entity.Custservicess;
import com.sample.entity.Connectiondetails;
import com.sample.repository.CustservicessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustservicessService {

    @Autowired
    private CustservicessRepository custservicessRepository;

    //Add
    public Custservicess createFromDTO(CustservicessDTO dto) {
        Custservicess custservicess = new Custservicess();
        custservicess.setMobilemonthly(dto.getMobilemonthly());
        custservicess.setMobileyearly(dto.getMobileyearly());
        custservicess.setInternetoverairmonthly(dto.getInternetoverairmonthly());
        custservicess.setInternetoverairyearly(dto.getInternetoverairyearly());
        custservicess.setInternetoverfiber(dto.getInternetoverfiber());
        custservicess.setVpn(dto.getVpn());
        custservicess.setStandardprices(dto.getStandardprices());
        custservicess.setServicestartdate(dto.getServicestartdate());
        custservicess.setSpecialprice(dto.getSpecialprice());
        custservicess.setNumberofconnections(dto.getNumberofconnections());

        List<Connectiondetails> connectiondetailsList = new ArrayList<>();
        if (dto.getConnectiondetails() != null) {
            for (ConnectiondetailsDTO cDto : dto.getConnectiondetails()) {
                Connectiondetails cd = new Connectiondetails();
                cd.setFirstname(cDto.getFirstname());
                cd.setLastname(cDto.getLastname());
                cd.setImeinumber(cDto.getImeinumber());
                cd.setMobilenumber(cDto.getMobilenumber());
                cd.setCustservicess(custservicess);
                connectiondetailsList.add(cd);
            }
        }
        custservicess.setConnectiondetails(connectiondetailsList);

        return custservicessRepository.save(custservicess);
    }
    
    
 // display all
    private CustservicessResponseDTO convertToDTO(Custservicess entity) {
        CustservicessResponseDTO dto = new CustservicessResponseDTO();
        dto.setId(entity.getId());
        dto.setMobilemonthly(entity.getMobilemonthly());
        dto.setMobileyearly(entity.getMobileyearly());
        dto.setInternetoverairmonthly(entity.getInternetoverairmonthly());
        dto.setInternetoverairyearly(entity.getInternetoverairyearly());
        dto.setInternetoverfiber(entity.getInternetoverfiber());
        dto.setVpn(entity.getVpn());
        dto.setStandardprices(entity.getStandardprices());
        dto.setServicestartdate(entity.getServicestartdate());
        dto.setSpecialprice(entity.getSpecialprice());
        dto.setNumberofconnections(entity.getNumberofconnections());

        if (entity.getConnectiondetails() != null) {
            List<ConnectiondetailsResponseDTO> connectiondetailsList = entity.getConnectiondetails()
                    .stream()
                    .map(cd -> {
                    	ConnectiondetailsResponseDTO cDto = new ConnectiondetailsResponseDTO();
                    	cDto.setId(cd.getId());
                        cDto.setFirstname(cd.getFirstname());
                        cDto.setLastname(cd.getLastname());
                        cDto.setImeinumber(cd.getImeinumber());
                        cDto.setMobilenumber(cd.getMobilenumber());
                        return cDto;
                    }).collect(Collectors.toList());
            dto.setConnectiondetails(connectiondetailsList);
        }

        return dto;
    }

    public List<CustservicessResponseDTO> getAllAsDTO() {
        return custservicessRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
 // POST API: Fetch custservicess by ID and include its connectiondetails
    public CustservicessResponseDTO1 getCustservicessById(Long id) {
        Custservicess custservicess = custservicessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Custservicess not found with id: " + id));

        CustservicessResponseDTO1 dto = new CustservicessResponseDTO1();
        dto.setId(custservicess.getId());
        dto.setMobilemonthly(custservicess.getMobilemonthly());
        dto.setMobileyearly(custservicess.getMobileyearly());
        dto.setInternetoverairmonthly(custservicess.getInternetoverairmonthly());
        dto.setInternetoverairyearly(custservicess.getInternetoverairyearly());
        dto.setInternetoverfiber(custservicess.getInternetoverfiber());
        dto.setVpn(custservicess.getVpn());
        dto.setStandardprices(custservicess.getStandardprices());
        dto.setServicestartdate(custservicess.getServicestartdate());
        dto.setSpecialprice(custservicess.getSpecialprice());
        dto.setNumberofconnections(custservicess.getNumberofconnections());

        List<ConnectiondetailsDTO1> connectionDTOs = custservicess.getConnectiondetails()
                .stream()
                .map(cd -> {
                    ConnectiondetailsDTO1 cDto = new ConnectiondetailsDTO1();
                    cDto.setId(cd.getId());
                    cDto.setFirstname(cd.getFirstname());
                    cDto.setLastname(cd.getLastname());
                    cDto.setImeinumber(cd.getImeinumber());
                    cDto.setMobilenumber(cd.getMobilenumber());
                    return cDto;
                }).collect(Collectors.toList());

        dto.setConnectiondetails(connectionDTOs);
        return dto;
    }
}
