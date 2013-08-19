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
		
		Section committee = new Section (231, "Groups", "societymaster.jsp?active=2", "committee.jsp");
		Section vendors = new Section (241, "Vendors", "societymaster.jsp?active=3", "vendors.jsp");
		Section docrepository = new Section (251, "Document Repository", "societymaster.jsp?active=4", "documents.jsp");
		Section alerts = new Section (261, "Define Alerts", "societymaster.jsp?active=5","alerts.jsp");
		Section mailergroups = new Section (271, "Define Mailer Groups", "societymaster.jsp?active=6","mailergroups.jsp");
		//Section billingheads = new Section (61, "Define Billing Heads", "societymaster.jsp?active=5","billingheads.jsp");
		
		
		societySubSections.add(societyRecords);
		societySubSections.add(residentRecords);
		societySubSections.add(committee);
		societySubSections.add(vendors);
		societySubSections.add(docrepository);
		societySubSections.add(alerts);
		societySubSections.add(mailergroups);
		
		societyInfo.setSubSections(societySubSections);
		
		
		Section accounting = new Section(3, "Accounts", "accounting.jsp", "");
		
				List <Section> accountSubSections = new ArrayList<Section>();
		
					Section refunds = new Section (31, "Refunds", "accounting.jsp?active=0&subactive=0", "refunds.jsp");
					Section receipts = new Section (32, "Receipts", "accounting.jsp?active=0&subactive=1", "receipts.jsp");
				
					Section payments = new Section (33, "Payments", "accounting.jsp?active=0&subactive=2", "");
						List <Section> paymentsSubSections = new ArrayList<Section>();
							Section paymentVouchers = new Section (331, "Pettycash Payments and Vouchers", "accounting.jsp?active=0&subactive=0", "vouchers.jsp");
							Section purchaseOrders = new Section (332, "Purchase Orders", "accounting.jsp?active=0&subactive=1", "purchaseorders.jsp");
							Section expenses = new Section (333, "Expenses & Salaries", "accounting.jsp?active=0&subactive=2", "expenses.jsp");
							Section bankdeposits = new Section (334, "Bank Deposits", "accounting.jsp?active=0&subactive=3", "bankdeposit.jsp");
						
							paymentsSubSections.add(paymentVouchers);
							paymentsSubSections.add(purchaseOrders);
							paymentsSubSections.add(expenses);
							paymentsSubSections.add(bankdeposits);
						
							payments.setSubSections(paymentsSubSections);
						
					Section reports = new Section (34, "Reports", "accounting.jsp?active=0&subactive=3", "");
						List <Section> reportsSubSections = new ArrayList<Section>();
							Section cashflowReport = new Section (341, "Cash Flow Report", "accounting.jsp?active=0&subactive=0", "cashflowreport.jsp");
							Section tdsCollectionReport = new Section (342, "TDS Collection Report", "accounting.jsp?active=0&subactive=1", "tdscollection.jsp");
							
							reportsSubSections.add(cashflowReport);
							reportsSubSections.add(tdsCollectionReport);
								
							reports.setSubSections(reportsSubSections);
				
					Section defineBillingHeads = new Section (35, "Define BillingHeads", "accounting.jsp?active=0&subactive=4", "");					
					Section vendorAMCs = new Section (36, "Input AMC records", "accounting.jsp?active=0&subactive=5", "");
					
				accountSubSections.add(refunds);
				accountSubSections.add(receipts);
				accountSubSections.add(vendorAMCs);
				accountSubSections.add(payments);
				accountSubSections.add(reports);
				accountSubSections.add(defineBillingHeads);
		
		accounting.setSubSections(accountSubSections);
		
		sections.add(societyInfo);
		sections.add(accounting);
		
		
	}
}
