package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
@PersistenceCapable
public class BillingHeads extends BaseEntity {
	
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key billingHeadID;
	
	@Persistent
	private String billingHeads;


	public Key getBillingHeadID() {
		return billingHeadID;
	}

	public void setBillingHeadID(Key billingHeadID) {
		this.billingHeadID = billingHeadID;
	}

	public String getBillingHead() {
		return billingHeads;
	}

	
}
