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
public class ForumDetail extends BaseEntity {
	
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key forumDetailID;

	public Key getForumDetailID() {
		return forumDetailID;
	}

	public void setForumDetailID(Key forumDetailID) {
		this.forumDetailID = forumDetailID;
	}

	@Persistent
	private Key forumID;

	@Persistent
	private Key replyerID;
	
	private String replyerName; 

	public String getReplyerName() {
		return replyerName;
	}

	public void setReplyerName(String replyerName) {
		this.replyerName = replyerName;
	}

	@Persistent
	private Key replyID;

	@Persistent
	private List<Key> membersLikedPost;

	@Persistent
	private List<Key> membersDislikedPost;
	
	@Persistent
	private Status status;
	
	@Persistent
	private Text commentText;
	
	public Text getCommentText() {
		return commentText;
	}

	public void setCommentText(Text commentText) {
		this.commentText = commentText;
	}

	@Persistent
	private Date postedDate;

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

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

	public Key getReplyID() {
		return replyID;
	}

	public void setReplyID(Key replyID) {
		this.replyID = replyID;
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

}
