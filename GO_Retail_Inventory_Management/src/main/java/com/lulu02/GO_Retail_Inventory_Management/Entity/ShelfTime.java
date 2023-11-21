package com.lulu02.GO_Retail_Inventory_Management.Entity;
import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table
@Entity(name="ShelfTime")
public class ShelfTime {
@Id
int shelfTimeId;
int productId;
int storeId;
LocalDate timeOnShelf;
LocalDate timeToRetail;
public int getShelfTimeId() {
	return shelfTimeId;
}
public void setShelfTimeId(int shelfTimeId) {
	this.shelfTimeId = shelfTimeId;
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
public LocalDate getTimeOnShelf() {
	return timeOnShelf;
}
public void setTimeOnShelf(LocalDate timeOnShelf) {
	this.timeOnShelf = timeOnShelf;
}
public LocalDate getTimeToRetail() {
	return timeToRetail;
}
public void setTimeToRetail(LocalDate timeToRetail) {
	this.timeToRetail = timeToRetail;
}
@Override
public String toString() {
	return "ShelfTime [shelfTimeId=" + shelfTimeId + ", productId=" + productId + ", storeId=" + storeId
			+ ", timeOnShelf=" + timeOnShelf + ", timeToRetail=" + timeToRetail + "]";
}
public ShelfTime(int shelfTimeId, int productId, int storeId, LocalDate timeOnShelf, LocalDate timeToRetail) {
	super();
	this.shelfTimeId = shelfTimeId;
	this.productId = productId;
	this.storeId = storeId;
	this.timeOnShelf = timeOnShelf;
	this.timeToRetail = timeToRetail;
}
public ShelfTime() {
	super();
	// TODO Auto-generated constructor stub
}
 
}