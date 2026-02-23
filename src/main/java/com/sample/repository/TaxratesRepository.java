//for customer dd
package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sample.entity.Taxrates;

public interface TaxratesRepository extends JpaRepository<Taxrates, Long> {
}
