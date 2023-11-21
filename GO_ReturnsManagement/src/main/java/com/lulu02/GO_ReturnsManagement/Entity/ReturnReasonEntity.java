package com.lulu02.GO_ReturnsManagement.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "return_reason")
public class ReturnReasonEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	int reason_id;
	
	String reasonDescription;

	public ReturnReasonEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReturnReasonEntity(int reason_id, String reasonDescription) {
		super();
		this.reason_id = reason_id;
		this.reasonDescription = reasonDescription;
	}

	@Override
	public String toString() {
		return "ReturnReasonEntity [reason_id=" + reason_id + ", reasonDescription=" + reasonDescription + "]";
	}

	public int getReason_id() {
		return reason_id;
	}

	public void setReason_id(int reason_id) {
		this.reason_id = reason_id;
	}

	public String getReasonDescription() {
		return reasonDescription;
	}

	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reasonDescription, reason_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReturnReasonEntity other = (ReturnReasonEntity) obj;
		return Objects.equals(reasonDescription, other.reasonDescription) && reason_id == other.reason_id;
	}
	
	

}
