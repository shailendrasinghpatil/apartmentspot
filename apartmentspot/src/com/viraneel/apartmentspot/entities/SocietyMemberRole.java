package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class SocietyMemberRole {
	
	@Persistent
	private Key societyID;
	
	@Persistent
	private Key memberID;
	
	@Persistent
	@Unowned
	private Status status;	
	
	@Persistent
	@Unowned
	private Role role;

	
	public Key getSocietyID() {
		return societyID;
	}

	public void setSocietyID(Key societyID) {
		this.societyID = societyID;
	}

	public Key getMemberID() {
		return memberID;
	}

	public void setMemberID(Key memberID) {
		this.memberID = memberID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}		

}
