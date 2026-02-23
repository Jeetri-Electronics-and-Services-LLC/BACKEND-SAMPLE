package com.sample.repository;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sample.entity.Notes;
import com.sample.entity.RecentCustomerNoteDTO;

public interface NotesRepository extends JpaRepository<Notes, Long> {
    
	List<Notes> findByCustomerId(Long customerId);
	
	//display only recent createddate and customerstatus of customers
	@Query(value = "SELECT n.customer_id AS customerId, n.createddate AS createdDate, n.customerstatus AS customerStatus " +
            "FROM notes n " +
            "WHERE n.id IN ( " +
            "    SELECT MAX(n1.id) " +
            "    FROM notes n1 " +
            "    GROUP BY n1.customer_id" +
            ") " +
            "ORDER BY n.customer_id", nativeQuery = true)
List<Object[]> findRecentNotesForCustomersNative();



}
