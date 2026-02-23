package com.sample.entity;
 import java.util.List;
 public class BundleRequestDTO {
 private String name;
 private String sku;
 private String description;
 private List<ProductRequestDTO> products;
 // Getters & Setters
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public String getSku() {
 return sku;
 }
 public void setSku(String sku) {
 this.sku = sku;
 }
 public String getDescription() {
 return description;
 }
 public void setDescription(String description) {
 this.description = description;
 }
 public List<ProductRequestDTO> getProducts() {
 return products;
 }
 public void setProducts(List<ProductRequestDTO> products) {
 this.products = products;
 }
 }
