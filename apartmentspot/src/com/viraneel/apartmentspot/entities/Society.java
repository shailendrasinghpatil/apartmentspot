package com.viraneel.apartmentspot.entities;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;
@PersistenceCapable
public class Society extends BaseEntity {
	
	
	
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key societyID;
	
	@Persistent
	private String name;

	@Persistent
	private String email;

	@Persistent
	private String phone;

	@Persistent
	private String area;
	
	@Persistent
	private String fax;
	
	@Persistent
	private String landmark;
	
	@Persistent
	private String builderName;	
	
	@Persistent
	private String builderAddress;
	
	@Persistent
	private String registrationNumber;
	
	@Persistent
	private String registrationDate;
	
	@Persistent
	private String surveyNumber;
	
	@Persistent
	private String city;
	
	@Persistent
	private String state;
	
	@Persistent
	private String country;	
	
	@Persistent
	private String road;	
	
	@Persistent
	private String zip;		
	
	@Persistent
	@Unowned
	private List<Building> buildings;
	
	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getBuilderName() {
		return builderName;
	}

	public void setBuilderName(String builderName) {
		this.builderName = builderName;
	}

	public String getBuilderAddress() {
		return builderAddress;
	}

	public void setBuilderAddress(String builderAddress) {
		this.builderAddress = builderAddress;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getSurveyNumber() {
		return surveyNumber;
	}

	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
	}

	public Key getSocietyID() {
		return societyID;
	}

	public void setSocietyID(Key socID) {
		this.societyID = socID;
	}	
	
	@Persistent
	@Unowned
	private List<Member> members;

	@Persistent
	@Unowned
	private List<House> houses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}	
	
	
}
