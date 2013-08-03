package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class VendorType extends BaseEntity{
	
	@Persistent
	private String vendorType;
	
	public VendorType(String fcType){
		setVendorType(fcType);
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	
}