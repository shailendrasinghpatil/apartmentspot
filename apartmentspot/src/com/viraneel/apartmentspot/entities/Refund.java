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
public class Refund extends BaseEntity implements Comparable {

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key refundID;

	@Persistent
	private String refundNumber;

	@Persistent
	private String refundAmount;

	@Persistent
	private String refundReason;

	@Persistent
	private String refundPaymentDetails;

	@Persistent
	private String refundDate;

	@Persistent
	private String refundTo;
	
	
	
	public Key getRefundID() {
		return refundID;
	}



	public void setRefundID(Key refundID) {
		this.refundID = refundID;
	}



	public String getRefundNumber() {
		return refundNumber;
	}



	public void setRefundNumber(String refundNumber) {
		this.refundNumber = refundNumber;
	}



	public String getRefundAmount() {
		return refundAmount;
	}



	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}



	public String getRefundReason() {
		return refundReason;
	}



	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}



	public String getRefundPaymentDetails() {
		return refundPaymentDetails;
	}



	public void setRefundPaymentDetails(String refundPaymentDetails) {
		this.refundPaymentDetails = refundPaymentDetails;
	}



	public String getRefundDate() {
		return refundDate;
	}



	public void setRefundDate(Date refundDate) {
		this.refundDate = df.format(refundDate);
	}

	

	public String getRefundTo() {
		return refundTo;
	}



	public void setRefundTo(String refundTo) {
		this.refundTo = refundTo;
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
		Refund b = (Refund) o;
		int returnval = this.refundID.compareTo(b.refundID);
		return returnval;
	}
}
