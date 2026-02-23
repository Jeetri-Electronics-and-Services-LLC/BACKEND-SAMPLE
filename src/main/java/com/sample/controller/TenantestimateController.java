package com.sample.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.Tenantestimate;
import com.sample.entity.TenantestimateFetchRequestDto;
import com.sample.entity.TenantestimateRequestDto;
import com.sample.entity.TenantestimateResponseDto;
import com.sample.service.TenantestimateService;

@RestController
@RequestMapping("/tenantestimate")
public class TenantestimateController {

    @Autowired
    private TenantestimateService tenantestimateService;

    @PostMapping("/addtenantestimate")
    public Tenantestimate addTenantestimate(
            @RequestBody TenantestimateRequestDto dto) {
        return tenantestimateService.addTenantestimate(dto);
    }
    
    @PostMapping("/fetchtenantestimate")
    public TenantestimateResponseDto fetchTenantestimate(
            @RequestBody TenantestimateFetchRequestDto requestDto) {

        return tenantestimateService.fetchTenantestimate(requestDto);
    }
   
}
