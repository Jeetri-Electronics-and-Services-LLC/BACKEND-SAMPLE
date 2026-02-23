package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

}
