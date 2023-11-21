package com.lulu02.GO_Retail_Inventory_Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table
@Entity(name="ProductCategory")
public class ProductCategory {
	@Id
	int storeId;
	String storeName; 
	String address;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void StoreName(String newInfo) {
		this.storeName = newInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ProductCategory [storeId=" + storeId + ", storeName=" + storeName + ", address=" + address + "]";
	}
	public ProductCategory(int storeId, String storeName, String address) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
	}
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setStoreName(String newInfo) {
		// TODO Auto-generated method stub
		
	}
	
}
