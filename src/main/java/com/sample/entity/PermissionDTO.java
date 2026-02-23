package com.sample.entity;

public class PermissionDTO {
    private Long id;
    private String name;

    public PermissionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
