package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Permission;
import com.sample.entity.Role;
import com.sample.repository.PermissionRepository;
import com.sample.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;

    //Get All Roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // Get Role By ID
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    // Add Role
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    //Update Role 
    public Role updateRole(Long id, Role roleDetails) {
        Role role = roleRepository.findById(id).orElseThrow();
        role.setName(roleDetails.getName());
        role.setPermissions(roleDetails.getPermissions());
        return roleRepository.save(role);
    }

    //Delete Role
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
    
 // Method to add a role
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }
    
 // Based on Role Name given display RoleName
    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
    
    public Set<Permission> getPermissionsByRoleName(String roleName) {
        Role role = roleRepository.findByName(roleName);
        if (role != null) {
            return role.getPermissions();
        } else {
            throw new IllegalArgumentException("Role not found");
        }
    }
}
