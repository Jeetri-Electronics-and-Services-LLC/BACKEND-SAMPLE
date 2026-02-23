package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Orderform;
import com.sample.entity.OrderformDTO;
import com.sample.entity.Orderproduct;
import com.sample.entity.OrderproductDTO;
import com.sample.repository.OrderformRepository;

@Service
public class OrderformService {

    @Autowired
    private OrderformRepository orderformRepository;

  //Add Orderform with list of OrderProducts
    public Orderform saveOrderform(OrderformDTO dto) {
        Orderform orderform = new Orderform();
        orderform.setCustomername(dto.getCustomername());
        orderform.setCreateddate(dto.getCreateddate());
        orderform.setCreatedby(dto.getCreatedby());
        orderform.setTotal(dto.getTotal());

        List<Orderproduct> productList = new ArrayList<>();

        for (OrderproductDTO p : dto.getOrderproducts()) {
            Orderproduct product = new Orderproduct();
            product.setProductid(p.getProductid());
            product.setName(p.getName());
            product.setDescription(p.getDescription());
            product.setQty(p.getQty());
            product.setSalesprice(p.getSalesprice());
            product.setAmount(p.getAmount());
            product.setOrderform(orderform);  // set relation
            productList.add(product);
        }

        orderform.setOrderproducts(productList);
        return orderformRepository.save(orderform);
    }
}
