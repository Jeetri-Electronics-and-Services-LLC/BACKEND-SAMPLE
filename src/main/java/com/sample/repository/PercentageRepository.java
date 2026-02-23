package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Percentage;

public interface PercentageRepository extends JpaRepository<Percentage, Long> {
}