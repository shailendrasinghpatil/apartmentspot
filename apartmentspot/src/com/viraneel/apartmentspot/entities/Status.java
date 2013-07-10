package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Status extends BaseEntity {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key statusID;
    
    public Key getStatusID() {
		return statusID;
	}

	public void setStatusID(Key statusID) {
		this.statusID = statusID;
	}

	@Persistent
    private String statusName;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
    
}
