//BasedOnRoleNamegivenDisplayListofPermissiones
package com.sample.controller;
import com.sample.entity.RolePermissionDTO;
import com.sample.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/rolespermissionss")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    // BasedOnRoleNamegivenDisplayListofPermissiones
    @PostMapping("/basedonrolenamegivendisplaylistofpermissiones")
    public Set<RolePermissionDTO> getPermissionsByRole(@RequestBody RoleRequest roleRequest) {
        return rolePermissionService.getPermissionsByRoleName(roleRequest.getRolename());
    }

    public static class RoleRequest {
        private String rolename;

        // Getter and Setter

        public String getRolename() {
            return rolename;
        }

        public void setRolename(String rolename) {
            this.rolename = rolename;
        }
    }
}
