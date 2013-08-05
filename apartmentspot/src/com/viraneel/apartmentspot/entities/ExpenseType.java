package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ExpenseType extends BaseEntity{
	
	@Persistent
	private String expenseType;
	
	public ExpenseType(String expenseType){
		setExpenseType(expenseType);
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	
	
}