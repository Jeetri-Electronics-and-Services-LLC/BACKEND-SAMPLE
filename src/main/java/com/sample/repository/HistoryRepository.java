package com.sample.repository;

import com.sample.entity.History;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
	@Query("SELECT h.id, h.createddate, h.createdby, h.notes, h.followupdate FROM History h")
    List<Object[]> findAllHistoryDetails();
}
