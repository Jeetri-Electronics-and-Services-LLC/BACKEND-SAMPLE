package com.sample.repository;

import com.sample.entity.Userstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserstatusRepository extends JpaRepository<Userstatus, Long> {
   
}
