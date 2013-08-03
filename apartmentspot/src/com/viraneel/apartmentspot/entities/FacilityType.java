package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class FacilityType extends BaseEntity{
	
	@Persistent
	private String facilityType;
	
	public FacilityType(String fcType){
		setFacilityType(fcType);
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	
	
}