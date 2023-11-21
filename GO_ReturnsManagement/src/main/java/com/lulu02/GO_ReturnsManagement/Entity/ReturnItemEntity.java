package com.lulu02.GO_ReturnsManagement.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "return_item")
public class ReturnItemEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	int returnId;
	//returnId`, `productId`, `reasonId`, `returnDate`
	int productId;
	int reasonId;
	LocalDate returnDate;
	public ReturnItemEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReturnItemEntity(int returnId, int productId, int reasonId, LocalDate returnDate) {
		super();
		this.returnId = returnId;
		this.productId = productId;
		this.reasonId = reasonId;
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "ReturnItemEntity [returnId=" + returnId + ", productId=" + productId + ", reasonId=" + reasonId
				+ ", returnDate=" + returnDate + "]";
	}
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(productId, reasonId, returnDate, returnId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReturnItemEntity other = (ReturnItemEntity) obj;
		return productId == other.productId && reasonId == other.reasonId
				&& Objects.equals(returnDate, other.returnDate) && returnId == other.returnId;
	}
	
	
	
	

}
