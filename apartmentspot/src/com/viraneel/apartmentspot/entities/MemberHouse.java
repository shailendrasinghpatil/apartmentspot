package com.viraneel.apartmentspot.entities;

import java.util.Calendar;
import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class MemberHouse extends BaseEntity {

	@Persistent
	@Unowned
	private ResidentType residentType;

	@Persistent
	private Key memberID;
	@Persistent
	private Key houseID;

	@Persistent
	private Date sinceDate;

	@Persistent
	private Date toDate;

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public ResidentType getResidentType() {
		return residentType;
	}

	public void setResidentType(ResidentType residentType) {
		this.residentType = residentType;
	}

	public Key getMemberID() {
		return memberID;
	}

	public void setMemberID(Key memberID) {
		this.memberID = memberID;
	}

	public Key getHouseID() {
		return houseID;
	}

	public void setHouseID(Key houseID) {
		this.houseID = houseID;
	}

	public Date getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(Date sinceDate) {
		this.sinceDate = sinceDate;
	}



}
