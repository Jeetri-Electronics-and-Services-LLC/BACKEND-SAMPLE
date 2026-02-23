package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Orderform;

public interface OrderformRepository extends JpaRepository<Orderform, Long> {
}
