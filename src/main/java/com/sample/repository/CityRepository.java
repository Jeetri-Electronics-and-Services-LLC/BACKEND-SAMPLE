package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
