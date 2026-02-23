package com.sample.repository;

import com.sample.entity.Custservicess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustservicessRepository extends JpaRepository<Custservicess, Long> {
}
