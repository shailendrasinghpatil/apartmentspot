package com.viraneel.apartmentspot.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;



@PersistenceCapable
public class Facility extends BaseEntity implements Comparable{

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key facilityID;
    @Persistent
	private String facilityName;
    @Persistent
	@Unowned
	private FacilityType facilityType;
    @Persistent
    private String Location;
    @Persistent
	private String Description;
    
      
	@Override
	public int compareTo(Object o) {
		Facility b = (Facility) o;
		int returnval = this.facilityID.compareTo(b.facilityID);
		return returnval;
	}

	public Key getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(Key facilityID) {
		this.facilityID = facilityID;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public FacilityType getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(FacilityType facilityType) {
		this.facilityType = facilityType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		this.Location = location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}
			
}
