package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.entity.Permission;
import com.sample.entity.Role;
import com.sample.service.RoleService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/getroles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/getroles/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Optional<Role> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addrole")
    public Role createRole(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @PutMapping("/updaterole/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
        return ResponseEntity.ok(roleService.updateRole(id, roleDetails));
    }

    @DeleteMapping("/deleterole/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
    
 // POST API to add a role only
    @PostMapping("/addrolewithuser")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        try {
            Role savedRole = roleService.addRole(role);
            return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    // Based on Role Name given display RoleName
    @PostMapping("/findByRoleName")
    public ResponseEntity<String> getRoleByName(@RequestBody Map<String, String> request) {
        String roleName = request.get("rolename");
        Role role = roleService.findRoleByName(roleName);
        if (role != null) {
            return ResponseEntity.ok(role.getName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/basedonrolenamegivendisplaylistofpermissions")
    public ResponseEntity<Set<Permission>> getPermissionsByRoleName(@RequestBody Map<String, String> requestBody) {
        try {
            String roleName = requestBody.get("rolename");
            Set<Permission> permissions = roleService.getPermissionsByRoleName(roleName);
            return ResponseEntity.ok(permissions);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

