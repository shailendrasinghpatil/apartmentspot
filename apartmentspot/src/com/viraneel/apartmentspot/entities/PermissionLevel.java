package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class PermissionLevel extends BaseEntity{
	public final static int SUPER_USER = 6;

	public final static int DELETE = 5;
	public final static int ADD = 4;
	public final static int EDIT = 3;
	public final static int VIEW = 2;
	public final static int PARTIAL = 1;
	public final static int NONE = 0;
	
	@Persistent
	private int level;

	public int getLevel() {
		return level;
	}

	public PermissionLevel(int level){
		this.level = level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

}
