package com.viraneel.apartmentspot.entities;

import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Message extends BaseEntity {

	@Persistent
	private Key messageID;

	@Persistent
	private String messageText;

	@Persistent
	private String subject;

	@Persistent
	private Key threadID;

	@Persistent
	private Key fromMemberID;

	@Persistent
	private Key toMemberID;

	@Persistent
	private Date messageDate;

	public Key getMessageID() {
		return messageID;
	}

	public void setMessageID(Key messageID) {
		this.messageID = messageID;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Key getThreadID() {
		return threadID;
	}

	public void setThreadID(Key threadID) {
		this.threadID = threadID;
	}

	public Key getFromMemberID() {
		return fromMemberID;
	}

	public void setFromMemberID(Key fromMemberID) {
		this.fromMemberID = fromMemberID;
	}

	public Key getToMemberID() {
		return toMemberID;
	}

	public void setToMemberID(Key toMemberID) {
		this.toMemberID = toMemberID;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

}
