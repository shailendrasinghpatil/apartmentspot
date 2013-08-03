package com.viraneel.apartmentspot.entities;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ForumDetail extends BaseEntity {

	@Persistent
	private Key forumID;

	@Persistent
	private Key replyerID;

	@Persistent
	private Date replyID;

	@Persistent
	private List<Member> membersLikedPost;

	@Persistent
	private List<Member> membersDislikedPost;
	
	@Persistent
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Key getForumID() {
		return forumID;
	}

	public void setForumID(Key forumID) {
		this.forumID = forumID;
	}

	public Key getReplyerID() {
		return replyerID;
	}

	public void setReplyerID(Key replyerID) {
		this.replyerID = replyerID;
	}

	public Date getReplyID() {
		return replyID;
	}

	public void setReplyID(Date replyID) {
		this.replyID = replyID;
	}

	public List<Member> getMembersLikedPost() {
		return membersLikedPost;
	}

	public void setMembersLikedPost(List<Member> membersLikedPost) {
		this.membersLikedPost = membersLikedPost;
	}

	public List<Member> getMembersDislikedPost() {
		return membersDislikedPost;
	}

	public void setMembersDislikedPost(List<Member> membersDislikedPost) {
		this.membersDislikedPost = membersDislikedPost;
	}

}
