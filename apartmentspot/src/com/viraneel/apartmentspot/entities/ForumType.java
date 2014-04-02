package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ForumType extends BaseEntity {
	@Persistent
	private String forumType;

	public ForumType(String type) {
		this.forumType=type;
	}

	public String getForumType() {
		return forumType;
	}

	public void setForumType(String forumType) {
		this.forumType = forumType;
	}
}
