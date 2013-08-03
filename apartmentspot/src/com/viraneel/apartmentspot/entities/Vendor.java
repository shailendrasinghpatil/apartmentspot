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
public class Vendor extends BaseEntity implements Comparable{

	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key vendorID;
    @Persistent
	private String vendorName;
    @Persistent
	@Unowned
	private VendorType vendorType;
    @Persistent
    private String vendorAddress;
    @Persistent
	private String vendorServiceDescription;
    @Persistent
	private String vendorContact;
    @Persistent
	private String vendorPAN;
    
    @Persistent
    private String vendorTAN;
    
	@Override
	public int compareTo(Object o) {
		Vendor b = (Vendor) o;
		int returnval = this.vendorID.compareTo(b.vendorID);
		return returnval;
	}

	

	public Key getVendorID() {
		return vendorID;
	}



	public void setVendorID(Key vendorID) {
		this.vendorID = vendorID;
	}



	public String getVendorName() {
		return vendorName;
	}



	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}



	public String getVendorAddress() {
		return vendorAddress;
	}



	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}



	public String getVendorServiceDescription() {
		return vendorServiceDescription;
	}



	public void setVendorServiceDescription(String vendorServiceDescription) {
		this.vendorServiceDescription = vendorServiceDescription;
	}



	public String getVendorContact() {
		return vendorContact;
	}



	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}



	public String getVendorPAN() {
		return vendorPAN;
	}



	public void setVendorPAN(String vendorPAN) {
		this.vendorPAN = vendorPAN;
	}



	public String getVendorTAN() {
		return vendorTAN;
	}



	public void setVendorTAN(String vendorTAN) {
		this.vendorTAN = vendorTAN;
	}



	public VendorType getVendorType() {
		return vendorType;
	}

	public void setVendorType(VendorType vendorType) {
		this.vendorType = vendorType;
	}
	
}
