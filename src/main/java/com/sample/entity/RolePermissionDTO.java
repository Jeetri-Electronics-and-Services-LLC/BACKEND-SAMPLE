//BasedOnRoleNamegivenDisplayListofPermissiones
package com.sample.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "name" }) // Ensures the order of fields in the JSON output
public class RolePermissionDTO {

    private Long id;
    private String name;

    public RolePermissionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
