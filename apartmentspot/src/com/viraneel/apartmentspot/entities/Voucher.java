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
public class Voucher extends BaseEntity {

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key voucherID;

	@Persistent
	private String voucherNumber;
	
	@Persistent
	private String voucherAmount;

	@Persistent
	private String voucherFor;
	
	
	@Persistent
	private String voucherDate;

	@Persistent
	private String voucherDescription;
	
		

	public Key getVoucherID() {
		return voucherID;
	}



	public void setVoucherID(Key voucherID) {
		this.voucherID = voucherID;
	}



	public String getVoucherNumber() {
		return voucherNumber;
	}



	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}



	public String getVoucherAmount() {
		return voucherAmount;
	}


	public void setVoucherAmount(String voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = df.format(voucherDate);
	}


	public String getVoucherDescription() {
		return voucherDescription;
	}



	public void setVoucherDescription(String voucherDescription) {
		this.voucherDescription = voucherDescription;
	}

	

	public String getVoucherFor() {
		return voucherFor;
	}



	public void setVoucherFor(String voucherFor) {
		this.voucherFor = voucherFor;
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


	
}
