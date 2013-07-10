package com.viraneel.apartmentspot.entities;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable
public class House extends BaseEntity {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key houseID;

	@Persistent
	private String houseNo;

	@Persistent
	private String plotNo;

	@Persistent
	private String intercomNo;

	@Persistent
	private double totalAreaSQFT;

	@Persistent
	private double carpetAreaSQFT;

	@Persistent
	private double builtupAreaSQFT;

	@Persistent
	private double openSpaceAreaSQFT;

	@Persistent
	@Unowned
	private Building building;

	@Persistent
	@Unowned
	private HouseType houseType;

	@Persistent
	private List<String> parkingSpots;
	
	@Persistent
	private String houseName;

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getIntercomNo() {
		return intercomNo;
	}

	public void setIntercomNo(String intercomNo) {
		this.intercomNo = intercomNo;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public double getTotalAreaSQFT() {
		return totalAreaSQFT;
	}

	public double getCarpetAreaSQFT() {
		return carpetAreaSQFT;
	}

	public double getBuiltupAreaSQFT() {
		return builtupAreaSQFT;
	}

	public double getOpenSpaceAreaSQFT() {
		return openSpaceAreaSQFT;
	}

	public List<String> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(List<String> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public HouseType getHouseType() {
		return houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public Key getHouseID() {
		return houseID;
	}

	public void setHouseID(Key houseID) {
		this.houseID = houseID;
	}

	public void setTotalAreaSQFT(double totalAreaSQFT) {
		this.totalAreaSQFT = totalAreaSQFT;
	}

	public void setCarpetAreaSQFT(double carpetAreaSQFT) {
		this.carpetAreaSQFT = carpetAreaSQFT;
	}

	public void setBuiltupAreaSQFT(double builtupAreaSQFT) {
		this.builtupAreaSQFT = builtupAreaSQFT;
	}

	public void setOpenSpaceAreaSQFT(double openSpaceAreaSQFT) {
		this.openSpaceAreaSQFT = openSpaceAreaSQFT;
	}

}
