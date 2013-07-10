package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Permission {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key permissionID;

	@Persistent
	private PermissionLevel level;
	
	public PermissionLevel getLevel() {
		return level;
	}

	public void setLevel(PermissionLevel level) {
		this.level = level;
	}


	@Persistent
	private Section section;

	public Section getSection() {
		return section;
	}

	public void setSection(Section sect) {
		this.section = sect;
	}
}
