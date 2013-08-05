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
public class Expense extends BaseEntity {

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key expenseID;

	@Persistent
	private String expenseNumber;
	
	@Persistent
	private String expenseAmount;
	
	@Persistent
	private String expenseFor; //recepient of expense done

	@Persistent
	private String expenseDate;

	@Persistent
	private String expenseDescription;
	
	@Persistent
	private String TDSdeducted;
	
	@Persistent
	private String panDeductee;
	
	@Persistent
	private String tanDeductee;
	
	

	public Key getExpenseID() {
		return expenseID;
	}



	public void setExpenseID(Key expenseID) {
		this.expenseID = expenseID;
	}



	public String getExpenseNumber() {
		return expenseNumber;
	}



	public void setExpenseNumber(String expenseNumber) {
		this.expenseNumber = expenseNumber;
	}



	public String getExpenseAmount() {
		return expenseAmount;
	}


	public void setExpenseAmount(String expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = df.format(expenseDate);
	}


	public String getExpenseDescription() {
		return expenseDescription;
	}



	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	
	
	public String getTDSdeducted() {
		return TDSdeducted;
	}



	public void setTDSdeducted(String tdsdeducted) {
		TDSdeducted = tdsdeducted;
	}



	public String getPanDeductee() {
		return panDeductee;
	}



	public void setPanDeductee(String panDeductee) {
		this.panDeductee = panDeductee;
	}



	public String getTanDeductee() {
		return tanDeductee;
	}



	public void setTanDeductee(String tanDeductee) {
		this.tanDeductee = tanDeductee;
	}

	public String getExpenseFor() {
		return expenseFor;
	}



	public void setExpenseFor(String expenseFor) {
		this.expenseFor = expenseFor;
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
