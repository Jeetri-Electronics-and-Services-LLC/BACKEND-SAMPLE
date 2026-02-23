package com.sample.repository;

import com.sample.entity.Customername;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomernameRepository extends JpaRepository<Customername, Long> {
    
}

