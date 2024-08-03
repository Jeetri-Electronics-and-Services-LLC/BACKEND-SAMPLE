package com.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sku;
    private int quantity;
    private String date;
    private String reorder;
    private String description;
    private double salesprice;
    private double salestax;
    private String purchasinginformation;
    private double cost;
    private String category_id;
    private String expense_account_id;
    private String type;
    private String asset_account_id;
    private String income_account_id;
    private String preferred_vendor_id;

    
	public String getExpense_account_id() {
		return expense_account_id;
	}

	public void setExpense_account_id(String expense_account_id) {
		this.expense_account_id = expense_account_id;
	}

	public String getAsset_account_id() {
		return asset_account_id;
	}

	public void setAsset_account_id(String asset_account_id) {
		this.asset_account_id = asset_account_id;
	}

	public String getIncome_account_id() {
		return income_account_id;
	}

	public void setIncome_account_id(String income_account_id) {
		this.income_account_id = income_account_id;
	}

	public String getPreferred_vendor_id() {
		return preferred_vendor_id;
	}

	public void setPreferred_vendor_id(String preferred_vendor_id) {
		this.preferred_vendor_id = preferred_vendor_id;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReorder() {
        return reorder;
    }

    public void setReorder(String reorder) {
        this.reorder = reorder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(double salesprice) {
        this.salesprice = salesprice;
    }

    public double getSalestax() {
        return salestax;
    }

    public void setSalestax(double salestax) {
        this.salestax = salestax;
    }

    public String getPurchasinginformation() {
        return purchasinginformation;
    }

    public void setPurchasinginformation(String purchasinginformation) {
        this.purchasinginformation = purchasinginformation;
    }

    public double getCost() {
        return cost;
   }

    public void setCost(double cost) {
        this.cost = cost;
    }

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	
	
	

   
    
}







