package com.sample.repository;


import com.sample.entity.Paidfromaccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidfromaccountRepository extends JpaRepository<Paidfromaccount, Long> {
}

