package com.sample.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brandaddress;

    // Sales Representative 1 fields
    private String salesrep1title;
    private String salesrep1firstname;
    private String salesrep1lastname;
    private String salesrep1mobilenumber;
    private String salesrep1emailid;

    // Sales Representative 2 fields
    private String salesrep2title;
    private String salesrep2firstname;
    private String salesrep2lastname;
    private String salesrep2mobilenumber;
    private String salesrep2emailid;

    @ManyToMany(mappedBy = "brands")
    private Set<Category> categorys = new HashSet<>();

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Percentage> percentages;

    @ManyToMany
    @JoinTable(
        name = "Brand_User",
        joinColumns = @JoinColumn(name = "brand_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

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

    public String getBrandaddress() {
        return brandaddress;
    }

    public void setBrandaddress(String brandaddress) {
        this.brandaddress = brandaddress;
    }

    public String getSalesrep1title() {
        return salesrep1title;
    }

    public void setSalesrep1title(String salesrep1title) {
        this.salesrep1title = salesrep1title;
    }

    public String getSalesrep1firstname() {
        return salesrep1firstname;
    }

    public void setSalesrep1firstname(String salesrep1firstname) {
        this.salesrep1firstname = salesrep1firstname;
    }

    public String getSalesrep1lastname() {
        return salesrep1lastname;
    }

    public void setSalesrep1lastname(String salesrep1lastname) {
        this.salesrep1lastname = salesrep1lastname;
    }

    public String getSalesrep1mobilenumber() {
        return salesrep1mobilenumber;
    }

    public void setSalesrep1mobilenumber(String salesrep1mobilenumber) {
        this.salesrep1mobilenumber = salesrep1mobilenumber;
    }

    public String getSalesrep1emailid() {
        return salesrep1emailid;
    }

    public void setSalesrep1emailid(String salesrep1emailid) {
        this.salesrep1emailid = salesrep1emailid;
    }

    public String getSalesrep2title() {
        return salesrep2title;
    }

    public void setSalesrep2title(String salesrep2title) {
        this.salesrep2title = salesrep2title;
    }

    public String getSalesrep2firstname() {
        return salesrep2firstname;
    }

    public void setSalesrep2firstname(String salesrep2firstname) {
        this.salesrep2firstname = salesrep2firstname;
    }

    public String getSalesrep2lastname() {
        return salesrep2lastname;
    }

    public void setSalesrep2lastname(String salesrep2lastname) {
        this.salesrep2lastname = salesrep2lastname;
    }

    public String getSalesrep2mobilenumber() {
        return salesrep2mobilenumber;
    }

    public void setSalesrep2mobilenumber(String salesrep2mobilenumber) {
        this.salesrep2mobilenumber = salesrep2mobilenumber;
    }

    public String getSalesrep2emailid() {
        return salesrep2emailid;
    }

    public void setSalesrep2emailid(String salesrep2emailid) {
        this.salesrep2emailid = salesrep2emailid;
    }

    
    
	

	public Set<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Percentage> getPercentages() {
        return percentages;
    }

    public void setPercentages(List<Percentage> percentages) {
        this.percentages = percentages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
