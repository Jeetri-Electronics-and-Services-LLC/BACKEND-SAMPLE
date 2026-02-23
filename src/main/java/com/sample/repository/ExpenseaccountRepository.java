package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Expenseaccount;

public interface ExpenseaccountRepository extends JpaRepository<Expenseaccount, Integer> {
	
}
