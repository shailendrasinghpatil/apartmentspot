package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class HouseType extends BaseEntity{
	
	@Persistent
	private String houseType;
	
	public HouseType(String hsType){
		setHouseType(hsType);
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	
	
}
