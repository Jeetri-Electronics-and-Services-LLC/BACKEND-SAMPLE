package com.sample.repository;

import com.sample.entity.Termsandconditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsandconditionsRepository extends JpaRepository<Termsandconditions, Long> {
	
	//display recent/latest description
	@Query(value = "SELECT t FROM Termsandconditions t WHERE t.id = (SELECT MAX(t2.id) FROM Termsandconditions t2)")
    Termsandconditions findMostRecentTermsAndConditions();
}
