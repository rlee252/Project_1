package com.revature.dto;

import java.sql.Blob;
import java.sql.Timestamp;

import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;

public class ReimbViewDTO {
	private int reimbId;
	private String reimbStatus;
	private String reimbType;
	private int reimbAmount;
	private String description;
	private Timestamp createdOn;
	private Blob receipt;
	
	
	
	public ReimbViewDTO(int reimbId, String reimbStatus, String reimbType, int reimbAmount, String description,
			Timestamp createdOn, Blob receipt) {
		super();
		this.reimbId = reimbId;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbAmount = reimbAmount;
		this.description = description;
		this.createdOn = createdOn;
		this.receipt = receipt;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public String getReimbType() {
		return reimbType;
	}
	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	public int getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + reimbAmount;
		result = prime * result + reimbId;
		result = prime * result + ((reimbStatus == null) ? 0 : reimbStatus.hashCode());
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbViewDTO other = (ReimbViewDTO) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (reimbAmount != other.reimbAmount)
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbViewDTO [reimbId=" + reimbId + ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType
				+ ", reimbAmount=" + reimbAmount + ", description=" + description + ", createdOn=" + createdOn
				+ ", receipt=" + receipt + "]";
	}
	
	
	
	
	
	
}
