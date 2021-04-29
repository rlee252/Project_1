package com.revature.dto;

import java.sql.Blob;
import java.sql.Timestamp;

import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;

public class ReimbViewDTO {
	private int reimbId;
	private ReimbursementStatus reimbStatus;
	private ReimbursementType reimbType;
	private int reimbAmount;
	private String description;
	private Timestamp createdOn;
	private Blob receipt;
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(ReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public ReimbursementType getReimbType() {
		return reimbType;
	}
	public void setReimbType(ReimbursementType reimbType) {
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
	
	
	
}
