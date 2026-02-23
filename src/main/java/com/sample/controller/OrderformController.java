package com.sample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Orderform;
import com.sample.entity.OrderformDTO;
import com.sample.service.OrderformService;

@RestController
@RequestMapping("/orderforms")
public class OrderformController {

    @Autowired
    private OrderformService orderformService;

    //Add Orderform with list of OrderProducts
    @PostMapping("/addorderformwithlistoforderproducts")
    public Orderform createOrderform(@RequestBody OrderformDTO dto) {
        return orderformService.saveOrderform(dto);
    }
}
