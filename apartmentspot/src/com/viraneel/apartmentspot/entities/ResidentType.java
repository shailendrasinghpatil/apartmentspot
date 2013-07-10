package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ResidentType extends BaseEntity{
	
	@Persistent
	private String residentType;
	
	@Persistent 
	String residentTypeShort;
	
	public String getResidentTypeShort() {
		return residentTypeShort;
	}

	public void setResidentTypeShort(String residentTypeShort) {
		this.residentTypeShort = residentTypeShort;
	}

	public ResidentType(String rsType, String rsTypeShort){
		setResidentType(rsType);
		setResidentTypeShort(rsTypeShort);
	}

	public String getResidentType() {
		return residentType;
	}

	public void setResidentType(String residentType) {
		this.residentType = residentType;
	}
	
	
}