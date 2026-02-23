package com.sample.service;

import com.sample.entity.Orderproduct;
import com.sample.repository.OrderproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderproductService {

    @Autowired
    private OrderproductRepository orderproductRepository;

    public Orderproduct saveOrderproduct(Orderproduct orderproduct) {
        return orderproductRepository.save(orderproduct);
    }

    public List<Orderproduct> getAllOrderproducts() {
        return orderproductRepository.findAll();
    }

    public Optional<Orderproduct> getOrderproductById(Long id) {
        return orderproductRepository.findById(id);
    }

    public Orderproduct updateOrderproduct(Long id, Orderproduct orderproductDetails) {
        Optional<Orderproduct> optionalOrderproduct = orderproductRepository.findById(id);

        if (optionalOrderproduct.isPresent()) {
            Orderproduct orderproduct = optionalOrderproduct.get();
            orderproduct.setProductid(orderproductDetails.getProductid());
            orderproduct.setName(orderproductDetails.getName());
            orderproduct.setDescription(orderproductDetails.getDescription());
            orderproduct.setQty(orderproductDetails.getQty());
            orderproduct.setSalesprice(orderproductDetails.getSalesprice());
            orderproduct.setAmount(orderproductDetails.getAmount());
            return orderproductRepository.save(orderproduct);
        } else {
            return null;
        }
    }

    public boolean deleteOrderproduct(Long id) {
        if (orderproductRepository.existsById(id)) {
            orderproductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
