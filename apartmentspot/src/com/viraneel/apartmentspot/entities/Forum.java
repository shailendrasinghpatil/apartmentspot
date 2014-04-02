package com.viraneel.apartmentspot.entities;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class Forum extends BaseEntity {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key forumID;
	
	@Persistent
	@Unowned
	private Key societyID;

	public Key getSocietyID() {
		return societyID;
	}

	public void setSocietyID(Key societyID) {
		this.societyID = societyID;
	}

	@Persistent
	private Key ownerID;
	
	private String ownerName;
	
	@Persistent
	private long noOfPosts;
	
	@Persistent
	private Date updateDate;
	
	@Persistent
	private String subject;

	@Persistent
	private Text forumText;

	@Persistent
	@Unowned
	private ForumType forumType;

	@Persistent
	private Date startDate;

	@Persistent
	private List<Group> addressedTo;
	
	@Persistent
	private List<Key> membersLikedPost;

	@Persistent
	private List<Key> membersDislikedPost;
	
	@Persistent
	private Status status;
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public long getNoOfPosts() {
		return noOfPosts;
	}

	public void setNoOfPosts(long noOfPosts) {
		this.noOfPosts = noOfPosts;
	}
	


	
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

	public Text getForumText() {
		return forumText;
	}

	public void setForumText(Text forumText) {
		this.forumText = forumText;
	}

	public List<Key> getMembersLikedPost() {
		return membersLikedPost;
	}

	public void setMembersLikedPost(List<Key> membersLikedPost) {
		this.membersLikedPost = membersLikedPost;
	}

	public List<Key> getMembersDislikedPost() {
		return membersDislikedPost;
	}

	public void setMembersDislikedPost(List<Key> membersDislikedPost) {
		this.membersDislikedPost = membersDislikedPost;
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
