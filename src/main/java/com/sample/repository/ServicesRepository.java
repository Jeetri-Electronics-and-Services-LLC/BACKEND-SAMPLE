package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sample.entity.Services;

public interface ServicesRepository extends JpaRepository<Services,Integer>   {

}
