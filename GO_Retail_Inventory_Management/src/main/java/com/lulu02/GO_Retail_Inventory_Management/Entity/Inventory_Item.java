package com.lulu02.GO_Retail_Inventory_Management.Entity;





import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="Inventory_Item")
@Entity
public class Inventory_Item {
	@Id
	int itemId;
	int productId;
	int storeId;
	int quantity;
	LocalDate purchaseDate;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Inventory_Item [itemId=" + itemId + ", productId=" + productId + ", storeId=" + storeId + ", quantity="
				+ quantity + ", purchaseDate=" + purchaseDate + "]";
	}
	public Inventory_Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory_Item(int itemId, int productId, int storeId, int quantity, LocalDate purchaseDate) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.storeId = storeId;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
	}
	
	
}
