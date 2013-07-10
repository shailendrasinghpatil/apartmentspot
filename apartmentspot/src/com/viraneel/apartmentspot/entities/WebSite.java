package com.viraneel.apartmentspot.entities;

import java.util.ArrayList;
import java.util.List;

public class WebSite {
	private static List <Section> sections = new ArrayList<Section>();
	public static List<Section> getSections() {
		return sections;
	}
	public static void setSections(List<Section> sections) {
		WebSite.sections = sections;
	}
	static{
		sections.add(new Section(1,"Dashboard", "home.jsp",""));
		
		Section societyInfo = new Section(2, "Society Information", "masterdata.jsp", "");
		List <Section> societySubSections = new ArrayList<Section>();
		Section societyRecords = new Section (21, "Society Records", "masterdata.jsp?active=0&subactive=0", "");
		
		List <Section> societyRecordsSubSections = new ArrayList<Section>();
		Section societyDetails = new Section (211, "Society Details", "masterdata.jsp?active=0&subactive=0", "SocietyDetailsForm.jsp");
		Section buildingDetails = new Section (212, "Building Details", "masterdata.jsp?active=0&subactive=1", "building.jsp");
		Section aptDetails = new Section (213, "Apartment Details", "masterdata.jsp?active=0&subactive=2", "houses.jsp");		
		Section facilityDetails = new Section (214, "Facility Details", "masterdata.jsp?active=0&subactive=3", "facilities.jsp");
		Section assetDetails = new Section (215, "Asset Details", "masterdata.jsp?active=0&subactive=4", "assets.jsp");
		Section rules = new Section (216, "Rules and Regulations", "masterdata.jsp?active=0&subactive=5","rules.jsp");
		societyRecordsSubSections.add(societyDetails);
		societyRecordsSubSections.add(buildingDetails);
		societyRecordsSubSections.add(aptDetails);
		societyRecordsSubSections.add(facilityDetails);
		societyRecordsSubSections.add(assetDetails);
		societyRecordsSubSections.add(rules);
		societyRecords.setSubSections(societyRecordsSubSections);
		
		
		Section residentRecords = new Section (31, "Resident Records", "masterdata.jsp?active=1&subactive=0","");
		List<Section> residentSubSections = new ArrayList<Section>();		
		Section residents = new Section (311, "Residents", "masterdata.jsp?active=1&subactive=0","residents.jsp");
		Section ownershipChanges = new Section (312, "Ownership Changes", "masterdata.jsp?active=1&subactive=1","ownership.jsp");
		residentSubSections.add(residents);
		residentSubSections.add(ownershipChanges);
		residentRecords.setSubSections(residentSubSections);
		
		Section committee = new Section (31, "Committee", "masterdata.jsp?active=2", "committee.jsp");
		Section vendors = new Section (41, "Vendors", "masterdata.jsp?active=3", "vendors.jsp");
		Section docrepository = new Section (51, "Docuement Repository", "masterdata.jsp?active=", "documents.jsp");
		Section alerts = new Section (61, "Alerts", "masterdata.jsp?active=5","alerts.jsp");
		
		
		societySubSections.add(societyRecords);
		societySubSections.add(residentRecords);
		societySubSections.add(committee);
		societySubSections.add(vendors);
		societySubSections.add(docrepository);
		societySubSections.add(alerts);
		
		societyInfo.setSubSections(societySubSections);
		sections.add(societyInfo);
	}
}
