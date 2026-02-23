package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.entity.Permission;
import com.sample.repository.PermissionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    //Get All Permissions
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    //Get Permissions By ID
    public Optional<Permission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    //Add Permissions
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    //Update Permissions
    public Permission updatePermission(Long id, Permission permissionDetails) {
        Permission permission = permissionRepository.findById(id).orElseThrow();
        permission.setName(permissionDetails.getName());
        return permissionRepository.save(permission);
    }

    //Delete Operation
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
    
    
   
}
