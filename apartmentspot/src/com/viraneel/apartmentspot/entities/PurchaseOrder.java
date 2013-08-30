package com.viraneel.apartmentspot.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class PurchaseOrder extends BaseEntity {

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key purchaseOrderID;

	@Persistent
	private String purchaseOrderNumber;
	
	@Persistent
	private String purchaseOrderAmount;

	@Persistent
	private String purchaseOrderDate;

	@Persistent
	private String purchaseOrderDescription;
	
	@Persistent
	private String purchaseOrderVendor;
	
	@Persistent
	private String purchaseOrderFor;
	

	public Key getPurchaseOrderID() {
		return purchaseOrderID;
	}



	public void setPurchaseOrderID(Key purchaseOrderID) {
		this.purchaseOrderID = purchaseOrderID;
	}



	public String getPurchaseOrderFor() {
		return purchaseOrderFor;
	}



	public void setPurchaseOrderFor(String purchaseOrderFor) {
		this.purchaseOrderFor = purchaseOrderFor;
	}



	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}



	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}



	public String getPurchaseOrderAmount() {
		return purchaseOrderAmount;
	}



	public void setPurchaseOrderAmount(String purchaseOrderAmount) {
		this.purchaseOrderAmount = purchaseOrderAmount;
	}

	public String getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(Date purchaseOrderDate) {
		this.purchaseOrderDate = df.format(purchaseOrderDate);
	}


	public String getPurchaseOrderDescription() {
		return purchaseOrderDescription;
	}



	public void setPurchaseOrderDescription(String purchaseOrderDescription) {
		this.purchaseOrderDescription = purchaseOrderDescription;
	}


	@Persistent
	@Unowned
	private ExpenseType expenseType;


	public ExpenseType getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}



	public String getPurchaseOrderVendor() {
		return purchaseOrderVendor;
	}



	public void setPurchaseOrderVendor(String purchaseOrderVendor) {
		this.purchaseOrderVendor = purchaseOrderVendor;
	}
	
	
}
