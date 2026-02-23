package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Ordertype;

public interface OrdertypeRepository extends JpaRepository<Ordertype, Integer> {
}
