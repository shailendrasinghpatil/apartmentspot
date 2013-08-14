package com.viraneel.apartmentspot.entities;

import java.util.Date;

import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;

public class GroupMemberDetail extends BaseEntity {
	
	@Persistent
	private Key memberID;
	
	@Persistent
	private Key groupID;

	@Persistent
	private Date sinceDate;

	@Persistent
	private Date toDate;
}
