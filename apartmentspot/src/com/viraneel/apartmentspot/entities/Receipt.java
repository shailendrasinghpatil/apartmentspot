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
public class Receipt extends BaseEntity implements Comparable {

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key receiptID;

	@Persistent
	private String receiptNumber;

	@Persistent
	private String receiptTo;

	@Persistent
	private String receiptAmount;

	@Persistent
	private String receiptDate;

	@Persistent
	private String receiptDescription;

		
	public Key getReceiptID() {
		return receiptID;
	}



	public void setReceiptID(Key receiptID) {
		this.receiptID = receiptID;
	}



	public String getReceiptNumber() {
		return receiptNumber;
	}



	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}



	public String getReceiptTo() {
		return receiptTo;
	}



	public void setReceiptTo(String receiptTo) {
		this.receiptTo = receiptTo;
	}



	public String getReceiptAmount() {
		return receiptAmount;
	}



	public void setReceiptAmount(String receiptAmount) {
		this.receiptAmount = receiptAmount;
	}



	public String getReceiptDate() {
		return receiptDate;
	}



	
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = df.format(receiptDate);
	}

	public String getReceiptDescription() {
		return receiptDescription;
	}



	public void setReceiptDescription(String receiptDescription) {
		this.receiptDescription = receiptDescription;
	}



	@Persistent
	@Unowned
	private BillingHeadType billingHeadType;


	public BillingHeadType getBillingHeadType() {
		return billingHeadType;
	}



	public void setBillingHeadType(BillingHeadType billingHeadType) {
		this.billingHeadType = billingHeadType;
	}
	
	@Override
	public int compareTo(Object o) {
		Receipt b = (Receipt) o;
		int returnval = this.receiptID.compareTo(b.receiptID);
		return returnval;
	}
	
}
