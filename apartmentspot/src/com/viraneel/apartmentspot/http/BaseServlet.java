package com.viraneel.apartmentspot.http;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;
import com.viraneel.apartmentspot.entities.HouseType;
import com.viraneel.apartmentspot.entities.Member;
import com.viraneel.apartmentspot.entities.PermissionLevel;
import com.viraneel.apartmentspot.entities.ResidentType;
import com.viraneel.apartmentspot.entities.Role;
import com.viraneel.apartmentspot.entities.Section;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.SocietyMemberRole;
import com.viraneel.apartmentspot.entities.Status;
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

}