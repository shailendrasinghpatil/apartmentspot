package com.viraneel.apartmentspot.valuebeans;

import java.io.Serializable;
import java.util.List;

import com.viraneel.apartmentspot.entities.Member;
import com.viraneel.apartmentspot.entities.Section;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.WebSite;

public class UserSessionProfile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6220649876906715073L;
	Member currentUser;
	Society currentSociety;
	List<Section> accessibleSections;
	
	public List<Section> getAccessibleSections() {		
		return accessibleSections;
	}
	public void setAccessibleSections(List<Section> accessibleSections) {
		this.accessibleSections = accessibleSections;
	}
	
	public Member getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(Member currentUser) {
		this.currentUser = currentUser;
	}
	public Society getCurrentSociety() {
		return currentSociety;
	}
	public void setCurrentSociety(Society currentSociety) {
		this.currentSociety = currentSociety;
	}

}
