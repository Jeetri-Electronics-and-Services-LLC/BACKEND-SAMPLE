package com.sample.repository;

import com.sample.entity.Customerstatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerstatusRepository extends JpaRepository<Customerstatus, Long> {
}
