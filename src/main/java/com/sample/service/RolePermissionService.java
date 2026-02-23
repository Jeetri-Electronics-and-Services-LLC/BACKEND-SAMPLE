//BasedOnRoleNamegivenDisplayListofPermissiones
package com.sample.service;
import com.sample.entity.Role;
import com.sample.entity.RolePermissionDTO;
import com.sample.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RolePermissionService {

    @Autowired
    private RoleRepository roleRepository;

   // BasedOnRoleNamegivenDisplayListofPermissiones
    public Set<RolePermissionDTO> getPermissionsByRoleName(String roleName) {
        Role role = roleRepository.findByName(roleName);

        Set<RolePermissionDTO> permissionsDTO = new HashSet<>();
        if (role != null && role.getPermissions() != null) {
            role.getPermissions().forEach(permission -> {
                permissionsDTO.add(new RolePermissionDTO(permission.getId(), permission.getName()));
            });
        }

        return permissionsDTO;
    }
}
