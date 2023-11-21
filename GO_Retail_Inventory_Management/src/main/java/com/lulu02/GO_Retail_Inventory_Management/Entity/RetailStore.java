package com.lulu02.GO_Retail_Inventory_Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table
@Entity
public class RetailStore {
	@Id
	int categoryId;
	String categoryName;
	String description;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RetailStore [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description="
				+ description + "]";
	}
	public RetailStore(int categoryId, String categoryName, String description) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
	}
	public RetailStore() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
