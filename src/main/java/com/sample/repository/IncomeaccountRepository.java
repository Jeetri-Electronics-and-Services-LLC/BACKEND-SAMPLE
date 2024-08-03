package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Incomeaccount;

public interface IncomeaccountRepository extends JpaRepository<Incomeaccount, Integer> {
	
}
