package com.sample.service;

import com.sample.entity.Ordertype;
import com.sample.repository.OrdertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdertypeService {

    @Autowired
    private OrdertypeRepository ordertypeRepository;

    // Create
    public Ordertype createOrdertype(Ordertype ordertype) {
        return ordertypeRepository.save(ordertype);
    }

    // Retrieve all
    public List<Ordertype> getAllOrdertypes() {
        return ordertypeRepository.findAll();
    }

    // Retrieve by ID
    public Optional<Ordertype> getOrdertypeById(int id) {
        return ordertypeRepository.findById(id);
    }

    // Update
    public Ordertype updateOrdertype(int id, Ordertype updatedOrdertype) {
        return ordertypeRepository.findById(id).map(ordertype -> {
            ordertype.setType(updatedOrdertype.getType());
            return ordertypeRepository.save(ordertype);
        }).orElse(null);
    }

    // Delete
    public boolean deleteOrdertype(int id) {
        if (ordertypeRepository.existsById(id)) {
            ordertypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
