package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class BillingHeadType extends BaseEntity{
	
	@Persistent
	private String billingHeadType;
	
	public BillingHeadType(String fcType){
		setBillingHeadType(fcType);
	}

	public String getBillingHeadType() {
		return billingHeadType;
	}

	public void setBillingHeadType(String billingHeadType) {
		this.billingHeadType = billingHeadType;
	}
	
	
}