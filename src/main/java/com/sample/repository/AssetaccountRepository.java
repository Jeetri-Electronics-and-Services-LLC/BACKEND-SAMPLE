package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Assetaccount;

public interface AssetaccountRepository extends JpaRepository<Assetaccount, Integer> {
	
}
