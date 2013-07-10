package com.viraneel.apartmentspot.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Building extends BaseEntity implements Comparable{

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key buildingID;
    @Persistent
	private String buildingNO;
    @Persistent
	private String buildingName;
    @Persistent
	private int totalFloors;
    public Key getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(Key buildingID) {
		this.buildingID = buildingID;
	}
	public String getBuildingNO() {
		return buildingNO;
	}
	public void setBuildingNO(String buildingNO) {
		this.buildingNO = buildingNO;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public int getTotalFloors() {
		return totalFloors;
	}
	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}
	public int getTotalHouses() {
		return totalHouses;
	}
	public void setTotalHouses(int totalHouses) {
		this.totalHouses = totalHouses;
	}
	@Persistent
	private int totalHouses;
	@Override
	public int compareTo(Object o) {
		Building b = (Building) o;
		int returnval = this.buildingID.compareTo(b.buildingID);
		return returnval;
	}
	
	
	
}
