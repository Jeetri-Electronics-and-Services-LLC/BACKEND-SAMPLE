package com.sample.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sample.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	// Method & Query To Fetch Role_Id based on User_Id
	@Query("SELECT r FROM Role r WHERE r.user.id = :userId")
	List<Role> findRolesByUserId(@Param("userId") Long userId);
	
	// Based on Role Name given display RoleName
	  Role findByName(String name);
	 
	  
	  

}
