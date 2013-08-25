package com.viraneel.apartmentspot.entities;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class GroupMemberDetail extends BaseEntity {
	
	@Persistent
	private Key memberID;

	@Persistent
	private String role;
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private String fullName; 
	
	public Key getMemberID() {
		return memberID;
	}

	public void setMemberID(Key memberID) {
		this.memberID = memberID;
	}

	public Key getGroupID() {
		return groupID;
	}

	public void setGroupID(Key groupID) {
		this.groupID = groupID;
	}

	public Date getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Persistent
	private Key groupID;

	@Persistent
	private Date sinceDate;

	@Persistent
	private Date toDate;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
