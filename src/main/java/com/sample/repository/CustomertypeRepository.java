package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Customertype;

public interface CustomertypeRepository extends JpaRepository<Customertype, Long> {
}

