package com.viraneel.apartmentspot.entities;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Forum extends BaseEntity {

	@Persistent
	private Key forumID;

	@Persistent
	private Key ownerID;

	@Persistent
	private String subject;

	@Persistent
	private String forumText;

	@Persistent
	private ForumType forumType;

	@Persistent
	private Date startDate;

	@Persistent
	private List<Group> addressedTo;
	
	@Persistent
	private Status status;
	
	public Key getForumID() {
		return forumID;
	}

	public void setForumID(Key forumID) {
		this.forumID = forumID;
	}

	public Key getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Key ownerID) {
		this.ownerID = ownerID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getForumText() {
		return forumText;
	}

	public void setForumText(String forumText) {
		this.forumText = forumText;
	}

	public ForumType getForumType() {
		return forumType;
	}

	public void setForumType(ForumType forumType) {
		this.forumType = forumType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<Group> getAddressedTo() {
		return addressedTo;
	}

	public void setAddressedTo(List<Group> addressedTo) {
		this.addressedTo = addressedTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	

}
