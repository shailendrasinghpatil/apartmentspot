package com.viraneel.apartmentspot.valuebeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.viraneel.apartmentspot.entities.Building;
import com.viraneel.apartmentspot.entities.HouseType;
import com.viraneel.apartmentspot.entities.ResidentType;
import com.viraneel.apartmentspot.entities.Role;
import com.viraneel.apartmentspot.entities.Status;

public class MemberHouseDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4036627225013561769L;
	private static DateFormat df = new SimpleDateFormat("yyyy-dd-MM");
	
	private Key memberID;

	private String fullName;

	private String firstName;

	private String middleName;

	private String lastName;

	private String email;

	private Status status;

	private String phone;

	private String address;

	private ResidentType residentType;

	private String sinceDate;

	private String toDate;

	private Key houseID;

	private String houseNo;

	private String plotNo;

	private String intercomNo;

	private double totalAreaSQFT;

	private double carpetAreaSQFT;

	private double builtupAreaSQFT;

	private double openSpaceAreaSQFT;

	private Building building;

	private HouseType houseType;

	private List<String> parkingSpots;

	private String houseName;
	
	private Role memberRole;

	public Role getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(Role memberRole) {
		this.memberRole = memberRole;
	}

	public ResidentType getResidentType() {
		return residentType;
	}

	public void setResidentType(ResidentType residentType) {
		this.residentType = residentType;
	}

	public String getSinceDate() {
		return sinceDate;
	}

	public void setSinceDate(Date sinceDate) {
		
		this.sinceDate = df.format(sinceDate);
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = df.format(toDate);
	}

	public Key getHouseID() {
		return houseID;
	}

	public void setHouseID(Key houseID) {
		this.houseID = houseID;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getIntercomNo() {
		return intercomNo;
	}

	public void setIntercomNo(String intercomNo) {
		this.intercomNo = intercomNo;
	}

	public double getTotalAreaSQFT() {
		return totalAreaSQFT;
	}

	public void setTotalAreaSQFT(double totalAreaSQFT) {
		this.totalAreaSQFT = totalAreaSQFT;
	}

	public double getCarpetAreaSQFT() {
		return carpetAreaSQFT;
	}

	public void setCarpetAreaSQFT(double carpetAreaSQFT) {
		this.carpetAreaSQFT = carpetAreaSQFT;
	}

	public double getBuiltupAreaSQFT() {
		return builtupAreaSQFT;
	}

	public void setBuiltupAreaSQFT(double builtupAreaSQFT) {
		this.builtupAreaSQFT = builtupAreaSQFT;
	}

	public double getOpenSpaceAreaSQFT() {
		return openSpaceAreaSQFT;
	}

	public void setOpenSpaceAreaSQFT(double openSpaceAreaSQFT) {
		this.openSpaceAreaSQFT = openSpaceAreaSQFT;
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

	public List<String> getParkingSpots() {
		return parkingSpots;
	}

	public void setParkingSpots(List<String> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Key getMemberID() {
		return memberID;
	}

	public void setMemberID(Key memberID) {
		this.memberID = memberID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String serializedJSON() {
		Gson gson = new Gson();
		String jsonSerializedString = gson.toJson(this);
		return jsonSerializedString;
	}

}
