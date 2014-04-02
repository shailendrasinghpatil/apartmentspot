package com.viraneel.apartmentspot.http;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.viraneel.apartmentspot.entities.BillingHeadType;
import com.viraneel.apartmentspot.entities.ExpenseType;
import com.viraneel.apartmentspot.entities.FacilityType;
import com.viraneel.apartmentspot.entities.ForumType;
import com.viraneel.apartmentspot.entities.HouseType;
import com.viraneel.apartmentspot.entities.Member;
import com.viraneel.apartmentspot.entities.PermissionLevel;
import com.viraneel.apartmentspot.entities.ResidentType;
import com.viraneel.apartmentspot.entities.Role;
import com.viraneel.apartmentspot.entities.Section;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.SocietyMemberRole;
import com.viraneel.apartmentspot.entities.Status;
import com.viraneel.apartmentspot.entities.VendorType;
import com.viraneel.apartmentspot.entities.WebSite;
import com.viraneel.apartmentspot.framework.persistence.PersistenceMgrFactory;
import com.viraneel.apartmentspot.valuebeans.UserSessionProfile;


public abstract class BaseServlet extends HttpServlet {

	protected PersistenceManager pm = PersistenceMgrFactory.get();
	private List<HouseType> houseTypes;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
	private List<ResidentType> residentTypes;
	private List<Role> roles;
	private List<Status> statuses;
	private List<FacilityType> facilityTypes;
	private List<VendorType> vendorTypes;
	private List<BillingHeadType> billingHeadTypes;
	private List<ExpenseType> expenseTypes;
	private List<ForumType> forumTypes;

	public BaseServlet() {
		super();
	}
	
	public Member getMemberByEmaiID(String email){
		Query q1 = pm
				.newQuery("select from com.viraneel.apartmentspot.entities.Member where email == emailIDParam");
		q1.declareParameters("String emailIDParam");		
		List<Member> members = (List<Member>)q1.execute(email);
		Member member = null;
		if(null != members && !members.isEmpty())
		{
			member = members.get(0);
		}
		
		return member;
	}

	public List<ResidentType> getResidentTypes() {

		if (residentTypes == null) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.ResidentType");
			try {
				residentTypes = (List<ResidentType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (residentTypes == null || residentTypes.isEmpty()) {
				ResidentType owner = new ResidentType("OWNER", "O");
				ResidentType coowner = new ResidentType("CO-OWNER", "CO");
				ResidentType occupant = new ResidentType("OCCUPANT", "R");
				ResidentType tenant = new ResidentType("TENANT", "T");
				ResidentType leaseholder = new ResidentType(
						"COMMERCIAL-LEASE-HOLDER", "CL");

				pm.makePersistent(owner);
				pm.makePersistent(coowner);
				pm.makePersistent(occupant);
				pm.makePersistent(tenant);
				pm.makePersistent(leaseholder);

				residentTypes = (List<ResidentType>) q1.execute();

			}
		}
		return residentTypes;

	}

	public List<HouseType> getHouseTypes() {

		if (null == houseTypes) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.HouseType");
			try {
				houseTypes = (List<HouseType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (houseTypes == null || houseTypes.isEmpty()) {
				HouseType duplex = new HouseType("DUPLEX");
				HouseType flat = new HouseType("FLAT");
				HouseType independent = new HouseType("INDEPENDENT");
				HouseType rowhouse = new HouseType("ROWHOUSE");
				HouseType twinbunglow = new HouseType("TWINBUNGLOW");
				HouseType commercial = new HouseType("COMMERCIAL");

				pm.makePersistent(duplex);
				pm.makePersistent(flat);
				pm.makePersistent(independent);
				pm.makePersistent(rowhouse);
				pm.makePersistent(twinbunglow);
				pm.makePersistent(commercial);

				houseTypes = (List<HouseType>) q1.execute();
			}
		}
		return houseTypes;

	}

	protected List<Role> getRoles() {
		if (null == roles) {
			Query q = pm.newQuery("select from " + Role.class.getName());
			roles = (List<Role>) q.execute();

			if (null == roles || roles.isEmpty()) {
				Role memberRole = new Role();
				memberRole.setRoleName("societyMember");
				pm.makePersistent(memberRole);

				Role adminRole = new Role();
				adminRole.setRoleName("societyAdmin");
				pm.makePersistent(adminRole);

				roles = (List<Role>) q.execute();

			}
		}
		return roles;
	}

	protected Role getRole(String roleName) {

		Query q = pm.newQuery("select from " + Role.class.getName()
				+ " where roleName == roleNameParam");
		q.declareParameters("String roleNameParam");
		List<Role> rolesList = (List<Role>) q.execute(roleName);
		Role role = null;
		if (null != rolesList && !rolesList.isEmpty()) {
			role = rolesList.get(0);
		}

		return role;
	}
	
	protected Role getRoleByID(long roleID) {

		Role role = null;
		List<Role> roles = getRoles();
		for(Role rl : roles){
			if(rl.getRoleID().getId() == roleID){
				role = rl;
				break;
			}
		}

		return role;
	}
	
	protected List<Status> getStatuses(){
		if (null == statuses) {
			Query q = pm.newQuery("select from " + Status.class.getName());
			statuses = (List<Status>) q.execute();

			if (null == statuses || statuses.isEmpty()) {
				Status activeStatus = new Status();
				activeStatus.setStatusName("ACTIVE");
				pm.makePersistent(activeStatus);

				Status suspendedStatus = new Status();
				suspendedStatus.setStatusName("SUSPENDED");
				pm.makePersistent(suspendedStatus);
				
				Status inactiveStatus = new Status();
				inactiveStatus.setStatusName("INACTIVE");
				pm.makePersistent(inactiveStatus);	
				

				statuses = (List<Status>) q.execute();

			}
		}		
		return statuses;
	}

	protected Status getStatusByID(long statusID) {
		Status stat = null;
		List<Status> statusList = getStatuses();
		for(Status status : statusList){
			if(status.getStatusID().getId() == statusID){
				stat = status;
			}
		}
		return stat;
	}	
	
	protected String getJSONString(List entityList) {
		String jsonStr;
		if (null != entityList && !entityList.isEmpty()) {
			Gson gson = new Gson();
			jsonStr = gson.toJson(entityList);
		} else {
			jsonStr = "[]";
		}
		return jsonStr;
	}

	protected List<SocietyMemberRole> getUserRoleForSociety(Key societyIDParam, Key memberIDParam) {
	
	
		Query q = pm.newQuery("select from  "
				+ SocietyMemberRole.class.getName()
				+ " where societyID == societyIDParam "
				+ "&& memberID == memberIDParam " + "parameters "
				+ Key.class.getName() + " societyIDParam,"
				+ Key.class.getName() + " memberIDParam ");
		List<SocietyMemberRole> societyUserRoles = (List<SocietyMemberRole>) q
				.execute(societyIDParam, memberIDParam);
		return societyUserRoles;
	}

	public UserSessionProfile getUserProfile(String userEmail) {
		Member siteUser = null;
		UserSessionProfile userSessionProfile = null;
		try {
			siteUser = getMemberByEmaiID(userEmail);
			if (null != siteUser) {
				Society soc = siteUser.getDefaultSociety();
	
				List<Section> accessibleSections = WebSite.getSections();
				Key societyIDParam = soc.getSocietyID();
				Key memberIDParam = siteUser.getMemberID();
				List<SocietyMemberRole> societyUserRoles = getUserRoleForSociety(
						societyIDParam, memberIDParam);
				if (societyUserRoles != null && !societyUserRoles.isEmpty()) {
					SocietyMemberRole socUserRole = (SocietyMemberRole) societyUserRoles
							.get(0);
					Role userRole = socUserRole.getRole();
					for (Section section : WebSite.getSections()) {
						PermissionLevel level = section
								.getPermissionLevelForSection(userRole);
						if (level != null
								&& (level.getLevel() != PermissionLevel.NONE)) {
							accessibleSections.add(section);
	
						}
					}
				}
	
				userSessionProfile = new UserSessionProfile();
				userSessionProfile.setCurrentSociety(soc);
				userSessionProfile.setCurrentUser(siteUser);
				userSessionProfile.setAccessibleSections(accessibleSections);
			}
		} catch (Exception e) {
			// TODO log exception
			e.printStackTrace();
		}
	
		return userSessionProfile;
	}
	
	
	public List<FacilityType> getFacilityType() {

		if (facilityTypes == null) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.FacilityType");
			try {
				facilityTypes = (List<FacilityType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (facilityTypes == null || facilityTypes.isEmpty()) {
				FacilityType recreation = new FacilityType("Recreation");
				FacilityType clubhouse = new FacilityType("Club House");
				FacilityType badminton = new FacilityType("Badminton");
				FacilityType tennis = new FacilityType("Tennis");
				FacilityType gym = new FacilityType("Gymnasium");
				FacilityType swimmingpool = new FacilityType("Swimming pool");
				FacilityType partyhall = new FacilityType("Party Hall");

				pm.makePersistent(recreation);
				pm.makePersistent(clubhouse);
				pm.makePersistent(badminton);
				pm.makePersistent(tennis);
				pm.makePersistent(gym);
				pm.makePersistent(swimmingpool);
				pm.makePersistent(partyhall);
				

				facilityTypes = (List<FacilityType>) q1.execute();

			}
		}
		return facilityTypes;

	}
	
	public List<VendorType> getVendorType() {

		if (vendorTypes == null) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.VendorType");
			try {
				vendorTypes = (List<VendorType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (vendorTypes == null || vendorTypes.isEmpty()) {
				VendorType plumber = new VendorType("Plumber");
				VendorType electrician = new VendorType("Electrician");
				VendorType cleaner = new VendorType("Cleaner");
				VendorType painter = new VendorType("Painter");
				VendorType security = new VendorType("Security");
				VendorType intercom = new VendorType("Intercom Services");
				VendorType liftrepair = new VendorType("Lift Repair");
				VendorType broadband = new VendorType("Broadband Services");
				VendorType fabrication = new VendorType("Fabricator");
				VendorType gardener = new VendorType("Gardening Services");
				VendorType pestcontrol = new VendorType("Pest Control Services");
				VendorType watersupplier = new VendorType("Water Supplier");
				VendorType miscellaneous = new VendorType("Miscellaneous Services");
				VendorType other = new VendorType("Other Services");
				

				pm.makePersistent(plumber);
				pm.makePersistent(electrician);
				pm.makePersistent(cleaner);
				pm.makePersistent(painter);
				pm.makePersistent(security);
				pm.makePersistent(intercom);
				pm.makePersistent(liftrepair);
				pm.makePersistent(broadband);
				pm.makePersistent(fabrication);
				pm.makePersistent(gardener);
				pm.makePersistent(pestcontrol);
				pm.makePersistent(watersupplier);
				pm.makePersistent(miscellaneous);
				pm.makePersistent(other);
			
				vendorTypes = (List<VendorType>) q1.execute();

			}
		}
		return vendorTypes;

	}
	
	public List<BillingHeadType> getBillingHeadType() {

		if (billingHeadTypes == null) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.BillingHeadType");
			try {
				billingHeadTypes = (List<BillingHeadType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (billingHeadTypes == null || billingHeadTypes.isEmpty()) {
				BillingHeadType maintenance = new BillingHeadType("Maintenance");
				BillingHeadType sinkingfund = new BillingHeadType("Sinking Fund");
				BillingHeadType developmentfund = new BillingHeadType("Development Fund");
				BillingHeadType clubmembership = new BillingHeadType("Club Membership");
				BillingHeadType facilityusage = new BillingHeadType("Facility Usage");
				BillingHeadType latepayment = new BillingHeadType("Late Payment");
				BillingHeadType penalty = new BillingHeadType("Penalty");
				BillingHeadType library = new BillingHeadType("Library Usage");
				BillingHeadType waterusage = new BillingHeadType("Water Usage");
				BillingHeadType partyhall = new BillingHeadType("PartyHall charges");
				BillingHeadType rental = new BillingHeadType("Rental Charges");
				BillingHeadType transferfee = new BillingHeadType("Transfer Fee");
				BillingHeadType documentation = new BillingHeadType("Documentation Charges");
				BillingHeadType chequebounce = new BillingHeadType("Cheque Bounce Charges");
				BillingHeadType parking = new BillingHeadType("Parking Charges");
				BillingHeadType other = new BillingHeadType("Other Charges");
				

				pm.makePersistent(maintenance);
				pm.makePersistent(sinkingfund);
				pm.makePersistent(developmentfund);
				pm.makePersistent(clubmembership);
				pm.makePersistent(facilityusage);
				pm.makePersistent(latepayment);
				pm.makePersistent(penalty);
				pm.makePersistent(library);
				pm.makePersistent(waterusage);
				pm.makePersistent(partyhall);
				pm.makePersistent(rental);
				pm.makePersistent(transferfee);
				pm.makePersistent(documentation);
				pm.makePersistent(chequebounce);
				pm.makePersistent(parking);
				pm.makePersistent(other);
			
				billingHeadTypes = (List<BillingHeadType>) q1.execute();

			}
		}
		return billingHeadTypes;

	}
	
	public List<ExpenseType> getExpenseType() {

		if (expenseTypes == null) {
			Query q1 = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.ExpenseType");
			try {
				expenseTypes = (List<ExpenseType>) q1.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (expenseTypes == null || expenseTypes.isEmpty()) {
				ExpenseType staffsalary = new ExpenseType("Staff Salary");
				ExpenseType electricity = new ExpenseType("Electricity Usage Expense");
				ExpenseType waterusage = new ExpenseType("Water Usage Expense");
				ExpenseType gasusage = new ExpenseType("Gas Usage Expense");
				ExpenseType plumber = new ExpenseType("Plumber Services Expenses");
				ExpenseType electrician = new ExpenseType("Electrician Service Expenses");
				ExpenseType cleaner = new ExpenseType("Cleaner Service Expenses");
				ExpenseType painter = new ExpenseType("Painter Service Expenses");
				ExpenseType security = new ExpenseType("Security Service Expenses");
				ExpenseType intercom = new ExpenseType("Intercom Service Expenses");
				ExpenseType liftrepair = new ExpenseType("Lift Repair Services");
				ExpenseType broadband = new ExpenseType("Broadband Service Expense");
				ExpenseType fabrication = new ExpenseType("Fabricator Services");
				ExpenseType gardener = new ExpenseType("Gardening Services");
				ExpenseType pestcontrol = new ExpenseType("Pest Control Services");
				ExpenseType watersupplier = new ExpenseType("Water Supplier Services");
				ExpenseType assetprocurement = new ExpenseType("Asset Procurement");
				ExpenseType miscellaneous = new ExpenseType("Miscellaneous Services");
				ExpenseType stationery = new ExpenseType("Stationery Expense");
				ExpenseType travel = new ExpenseType("Travel Expense");
				ExpenseType generalmaintenance = new ExpenseType("General Maintenance Expenses");
				ExpenseType other = new ExpenseType("Other Expenses");
				

				pm.makePersistent(staffsalary);
				pm.makePersistent(electricity);
				pm.makePersistent(waterusage);
				pm.makePersistent(travel);
				pm.makePersistent(gasusage);
				pm.makePersistent(generalmaintenance);
				pm.makePersistent(stationery);
				pm.makePersistent(plumber);
				pm.makePersistent(electrician);
				pm.makePersistent(cleaner);
				pm.makePersistent(painter);
				pm.makePersistent(security);
				pm.makePersistent(intercom);
				pm.makePersistent(liftrepair);
				pm.makePersistent(broadband);
				pm.makePersistent(fabrication);
				pm.makePersistent(gardener);
				pm.makePersistent(pestcontrol);
				pm.makePersistent(watersupplier);
				pm.makePersistent(assetprocurement);
				pm.makePersistent(miscellaneous);
				pm.makePersistent(other);
			
				expenseTypes = (List<ExpenseType>) q1.execute();

			}
		}
		return expenseTypes;

	}

	protected void setQueryRangeAndOrder(HttpServletRequest req, Query q,
			int size) {
				if (null != req.getParameter("jtStartIndex")) {
					
					int startIndex = Integer.parseInt(req
							.getParameter("jtStartIndex"));
					int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			
					int endIndex = startIndex + pageSize;
					if (endIndex >= size) {
						endIndex = size;
					}
					System.out.println("StartIndex=" + startIndex + " endIndex="
							+ endIndex);
					q.setRange(startIndex, endIndex);
				}
			
				if (null != req.getParameter("jtSorting")) {
					String paramOrderBy = req.getParameter("jtSorting");
					q.setOrdering(paramOrderBy);
				}
			}

	protected ForumType getForumType(String forumTypeName) {
		if (null == forumTypes) {
			getForumTypes();
		}
		
		ForumType forumReturnType = null;
		for(ForumType forumType: forumTypes){
			if(forumTypeName.equalsIgnoreCase(forumType.getForumType())){
				forumReturnType = forumType;
				break;
			}
		}
		
		return forumReturnType;
	}

	protected List<ForumType> getForumTypes() {
		Query q1 = pm
				.newQuery("select from com.viraneel.apartmentspot.entities.ForumType");
		try {
			forumTypes = (List<ForumType>) q1.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (forumTypes == null || forumTypes.isEmpty()) {
			ForumType discussion = new ForumType("DISCUSSION");
			ForumType complaint = new ForumType("COMPLAINT");
			ForumType message = new ForumType("MESSAGE");
			ForumType notice = new ForumType("NOTICE");
			ForumType classified = new ForumType("CLASSIFIED");
			ForumType poll = new ForumType("POLL");

			pm.makePersistent(discussion);
			pm.makePersistent(complaint);
			pm.makePersistent(message);
			pm.makePersistent(notice);
			pm.makePersistent(classified);
			pm.makePersistent(poll);

			forumTypes = (List<ForumType>) q1.execute();
		}
		return forumTypes;
	}

	protected void sendJSONResponse(HttpServletResponse resp, String jsonStr) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");		
		resp.getWriter().print(jsonStr);
	}
}