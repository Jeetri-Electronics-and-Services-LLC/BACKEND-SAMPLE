<<<<<<< HEAD
package com.sample.entity;

import java.util.List;

public class ReqBody {
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPreferredvendor() {
		return preferredvendor;
	}
	public void setPreferredvendor(String preferredvendor) {
		this.preferredvendor = preferredvendor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPurchasinginformation() {
		return purchasinginformation;
	}
	public void setPurchasinginformation(String purchasinginformation) {
		this.purchasinginformation = purchasinginformation;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getReorder() {
		return reorder;
	}
	public void setReorder(String reorder) {
		this.reorder = reorder;
	}
	public String getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	private String category;
	private String cost;
	private String date;
	private String description;
	
	private String name;
	private String preferredvendor;
	private String purchasinginformation;
	private String quantity;
	private String reorder;
	private String salesprice;
	private String msrp;
    private String location;
    private String msrpdescription;
    private String directdealercost ;
    private String Indirectdealercost ;
	
	private String sku;
	private String type;
	private String qty;
	private String product;
	private String products_id;
	public String username;
	public String password;
	
	private Long customerid;

    private String firstname;
    private String lastname;
    private String mobilenumber;
    private String email;
    
    private String customer_type_id;
    private String customernumber;

	
	
	
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMsrpdescription() {
		return msrpdescription;
	}
	public void setMsrpdescription(String msrpdescription) {
		this.msrpdescription = msrpdescription;
	}
	public String getDirectdealercost() {
		return directdealercost;
	}
	public void setDirectdealercost(String directdealercost) {
		this.directdealercost = directdealercost;
	}
	public String getIndirectdealercost() {
		return Indirectdealercost;
	}
	public void setIndirectdealercost(String indirectdealercost) {
		Indirectdealercost = indirectdealercost;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProducts_id() {
		return products_id;
	}
	public void setProducts_id(String products_id) {
		this.products_id = products_id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public Long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustomer_type_id() {
		return customer_type_id;
	}
	public void setCustomer_type_id(String customer_type_id) {
		this.customer_type_id = customer_type_id;
	}
	public String getCustomernumber() {
		return customernumber;
	}
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	
	
}
=======
package com.sample.entity;

import java.util.List;

public class ReqBody {
	private String asset_account_id;
	public String getAsset_account_id() {
		return asset_account_id;
	}
	public void setAsset_account_id(String asset_account_id) {
		this.asset_account_id = asset_account_id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExpense_account_id() {
		return expense_account_id;
	}
	public void setExpense_account_id(String expense_account_id) {
		this.expense_account_id = expense_account_id;
	}
	public String getIncome_account_id() {
		return income_account_id;
	}
	public void setIncome_account_id(String income_account_id) {
		this.income_account_id = income_account_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreferred_vendor_id() {
		return preferred_vendor_id;
	}
	public void setPreferred_vendor_id(String preferred_vendor_id) {
		this.preferred_vendor_id = preferred_vendor_id;
	}
	public String getPurchasinginformation() {
		return purchasinginformation;
	}
	public void setPurchasinginformation(String purchasinginformation) {
		this.purchasinginformation = purchasinginformation;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getReorder() {
		return reorder;
	}
	public void setReorder(String reorder) {
		this.reorder = reorder;
	}
	public String getSalesprice() {
		return salesprice;
	}
	public void setSalesprice(String salesprice) {
		this.salesprice = salesprice;
	}
	public String getSalestax() {
		return salestax;
	}
	public void setSalestax(String salestax) {
		this.salestax = salestax;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	private String category_id;
	private String cost;
	private String date;
	private String description;
	private String expense_account_id;
	private String income_account_id;
	private String name;
	private String preferred_vendor_id;
	private String purchasinginformation;
	private String quantity;
	private String reorder;
	private String salesprice;
	private String salestax;
	private String sku;
	private String type;
	private String qty;
	private String product;
	private String products_id;
	
	
	
	public String getProducts_id() {
		return products_id;
	}
	public void setProducts_id(String products_id) {
		this.products_id = products_id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	
	
	
		

}
>>>>>>> 8bfaa7541c83154cb3d6764d7c184976329f6125
