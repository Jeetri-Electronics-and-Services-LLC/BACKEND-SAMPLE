package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.Permission;
import com.sample.service.PermissionService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/getallpermissions")
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/getallpermission/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        Optional<Permission> permission = permissionService.getPermissionById(id);
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addpermissions")
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionService.savePermission(permission);
    }

    @PutMapping("/updatepermission/{id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable Long id, @RequestBody Permission permissionDetails) {
        return ResponseEntity.ok(permissionService.updatePermission(id, permissionDetails));
    }

    @DeleteMapping("/deletepermission/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
