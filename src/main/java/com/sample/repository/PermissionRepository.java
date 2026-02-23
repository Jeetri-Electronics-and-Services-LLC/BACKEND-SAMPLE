package com.sample.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sample.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
/*Query To Fetch Permissions-Based On Roleid, go to role_permissiontable fetch permission_id based on role_id and go to permission table fetch permissions based on permission_id */
	@Query("SELECT p FROM Permission p JOIN p.roles r WHERE r.id = :roleId")
    List<Permission> findPermissionsByRoleId(@Param("roleId") Long roleId);
	
}
