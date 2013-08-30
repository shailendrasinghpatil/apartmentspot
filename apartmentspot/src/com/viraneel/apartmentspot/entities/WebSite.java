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
		
		Section societyInfo = new Section(2, "Society Data", "societymaster.jsp", "");
		
		List <Section> societySubSections = new ArrayList<Section>();
		
		Section societyRecords = new Section (21, "Society Records", "societymaster.jsp?active=0&subactive=0", "");
		
		List <Section> societyRecordsSubSections = new ArrayList<Section>();
		
		Section societyDetails = new Section (211, "Society Details", "societymaster.jsp?active=0&subactive=0", "SocietyDetailsForm.jsp");
		Section buildingDetails = new Section (212, "Building Details", "societymaster.jsp?active=0&subactive=1", "building.jsp");
		Section aptDetails = new Section (213, "Apartment Details", "societymaster.jsp?active=0&subactive=2", "houses.jsp");		
		Section facilityDetails = new Section (214, "Facility Details", "societymaster.jsp?active=0&subactive=3", "facilities.jsp");
		Section assetDetails = new Section (215, "Asset Details", "societymaster.jsp?active=0&subactive=4", "assets.jsp");
		Section rules = new Section (216, "Rules and Regulations", "societymaster.jsp?active=0&subactive=5","rules.jsp");
		
		societyRecordsSubSections.add(societyDetails);
		societyRecordsSubSections.add(buildingDetails);
		societyRecordsSubSections.add(aptDetails);
		societyRecordsSubSections.add(facilityDetails);
		societyRecordsSubSections.add(assetDetails);
		societyRecordsSubSections.add(rules);
		
		societyRecords.setSubSections(societyRecordsSubSections);
		
		
		Section residentRecords = new Section (22, "Resident Records", "societymaster.jsp?active=1&subactive=0","");
		
		List<Section> residentSubSections = new ArrayList<Section>();		
		
		Section residents = new Section (221, "Residents", "societymaster.jsp?active=1&subactive=0","residents.jsp");
		Section ownershipChanges = new Section (222, "Ownership Changes", "societymaster.jsp?active=1&subactive=1","ownership.jsp");
		
		residentSubSections.add(residents);
		residentSubSections.add(ownershipChanges);
		
		residentRecords.setSubSections(residentSubSections);
		
		Section committee = new Section (23, "Groups", "societymaster.jsp?active=2", "committee.jsp");
		Section vendors = new Section (24, "Vendors", "societymaster.jsp?active=3", "vendors.jsp");
		Section docrepository = new Section (25, "Document Repository", "societymaster.jsp?active=4", "documents.jsp");
		Section alerts = new Section (26, "Define Alerts", "societymaster.jsp?active=5","alerts.jsp");
		Section mailergroups = new Section (27, "Define Mailer Groups", "societymaster.jsp?active=6","mailergroups.jsp");
		//Section billingheads = new Section (61, "Define Billing Heads", "societymaster.jsp?active=5","billingheads.jsp");
		
		
		
		societySubSections.add(committee);
		societySubSections.add(vendors);
		societySubSections.add(docrepository);
		societySubSections.add(alerts);
		societySubSections.add(mailergroups);
		
		societyInfo.setSubSections(societySubSections);
		
		societySubSections.add(societyRecords);
		societySubSections.add(residentRecords);
		
		Section accounting = new Section(3, "Accounts", "accounting.jsp", "");
		
				List <Section> accountSubSections = new ArrayList<Section>();
		
					Section payments = new Section (31, "Payments", "accounting.jsp?active=0&subactive=0", "");
					List <Section> paymentsSubSections = new ArrayList<Section>();
					Section paymentVouchers = new Section (311, "Pettycash Payments and Vouchers", "accounting.jsp?active=0", "vouchers.jsp");
					Section purchaseOrders = new Section (312, "Purchase Orders", "accounting.jsp?active=1", "purchaseorders.jsp");
					Section expenses = new Section (313, "Expenses & Salaries", "accounting.jsp?active=2", "expenses.jsp");
					Section bankdeposits = new Section (314, "Bank Deposits", "accounting.jsp?active=3", "bankdeposit.jsp");
				
					paymentsSubSections.add(paymentVouchers);
					paymentsSubSections.add(purchaseOrders);
					paymentsSubSections.add(expenses);
					paymentsSubSections.add(bankdeposits);
				
					payments.setSubSections(paymentsSubSections);
					
					Section refunds = new Section (32, "Refunds", "accounting.jsp?active=1", "refunds.jsp");
					Section receipts = new Section (33, "Receipts", "accounting.jsp?active=2", "receipts.jsp");
					Section vendorAMCs = new Section (34, "Input AMC records", "accounting.jsp?active=3","amcrecords.jsp");
					
						
					Section reports = new Section (35, "Reports", "accounting.jsp?active=4&subactive=0", "");
						List <Section> reportsSubSections = new ArrayList<Section>();
							Section cashflowReport = new Section (351, "Cash Flow Report", "accounting.jsp?active=4&subactive=0", "cashflowreport.jsp");
							Section tdsCollectionReport = new Section (352, "TDS Collection Report", "accounting.jsp?active=4&subactive=1", "tdscollection.jsp");
							
							reportsSubSections.add(cashflowReport);
							reportsSubSections.add(tdsCollectionReport);
								
							reports.setSubSections(reportsSubSections);
				
					//Section defineBillingHeads = new Section (35, "Define BillingHeads", "accounting.jsp?active=0&subactive=4", "");					
					
				accountSubSections.add(payments);	
				accountSubSections.add(refunds);
				accountSubSections.add(receipts);
				accountSubSections.add(vendorAMCs);
				accountSubSections.add(reports);
				//accountSubSections.add(defineBillingHeads);
		
		accounting.setSubSections(accountSubSections);
		
		sections.add(societyInfo);
		sections.add(accounting);
		
	}
}
