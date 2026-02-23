package com.sample.entity;

public class CategoryDTO4 {
    private int id;
    private String name;
    private String createddate;
    private String createdby;

    public CategoryDTO4() {
    }

    public CategoryDTO4(int id, String name, String createddate, String createdby) {
        this.id = id;
        this.name = name;
        this.createddate = createddate;
        this.createdby = createdby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }
}
