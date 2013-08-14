package com.viraneel.apartmentspot.entities;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Group extends BaseEntity{
	
	public Key getGroupID() {
		return groupID;
	}

	public void setGroupID(Key groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public Key getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Key ownerID) {
		this.ownerID = ownerID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key groupID;	

	@Persistent
	private String groupName;
	
	@Persistent
	private String groupDescription;
	
	@Persistent
	private Key ownerID;
	
	@Persistent
	private Date createdDate;
	
	@Persistent
	private Date endDate;
	
	
	
}
