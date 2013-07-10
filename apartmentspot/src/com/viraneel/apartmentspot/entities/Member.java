package com.viraneel.apartmentspot.entities;


import java.util.Calendar;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Member extends BaseEntity {
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key memberID;
    
	@Persistent
	private String fullName;    
    
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}





	@Persistent
	private String firstName;
	
	@Persistent
	private String middleName;

	@Persistent
	private String lastName;	
	
	@Persistent
	private String email;
	

	@Persistent
	private String phone;	
	
	@Persistent
	private String address;		
	
	@Persistent
	@Unowned
	private Society defaultSociety;
	
	public Society getDefaultSociety() {
		return defaultSociety;
	}

	public void setDefaultSociety(Society defaultSociety) {
		this.defaultSociety = defaultSociety;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Society> getSocieties() {
		return societies;
	}

	public Key getMemberID() {
		return memberID;
	}

	public void setMemberID(Key memID) {
		this.memberID = memID;
	}

	public void setSocieties(List<Society> societies) {
		this.societies = societies;
	}
	



	
	@Persistent
	@Unowned
	private List<Society> societies;
}
