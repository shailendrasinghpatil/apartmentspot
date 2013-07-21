package com.viraneel.apartmentspot.http;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.viraneel.apartmentspot.entities.Asset;
import com.viraneel.apartmentspot.entities.Building;
import com.viraneel.apartmentspot.entities.House;
import com.viraneel.apartmentspot.entities.HouseType;
import com.viraneel.apartmentspot.entities.Member;
import com.viraneel.apartmentspot.entities.MemberHouse;
import com.viraneel.apartmentspot.entities.ResidentType;
import com.viraneel.apartmentspot.entities.Role;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.SocietyMemberRole;
import com.viraneel.apartmentspot.entities.Status;
import com.viraneel.apartmentspot.valuebeans.MemberHouseDetail;
import com.viraneel.apartmentspot.valuebeans.UserSessionProfile;

@SuppressWarnings("serial")
public class MasterData extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String userAction = req.getParameter("userAction");
		if (userAction.equalsIgnoreCase("Update_Asset_Details")) {
			processAssetDetails(req, resp);
		}else if (userAction.equals("Get_Asset_Details")) {
			getAssetDetails(req, resp);
		} else if (userAction.equals("Delete_Asset_Details")) {
			deleteAssetDetails(req, resp); 
		} else if (userAction.equalsIgnoreCase("Update_Society_Details")) {
			processSocietyDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Update_Building_Details")) {
			processBuildingsDetails(req, resp);
		} else if (userAction.equals("Get_Building_Details")) {
			getBuildingDetails(req, resp);
		} else if (userAction.equals("Delete_Building_Details")) {
			deleteBuildingDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Update_House_Details")) {
			processHouseDetails(req, resp);
		} else if (userAction.equals("Get_House_Details")) {
			getHouseDetails(req, resp);
		} else if (userAction.equals("Delete_House_Details")) {
			deleteHouseDetails(req, resp);
		} else if (userAction.equals("Get_House_Type_Options")) {
			getHouseTypes(req, resp);
		} else if (userAction.equals("Get_Building_Options")) {
			getBuildingOptions(req, resp);
		} else if (userAction.equals("Get_Resident_Type_Options")) {
			getResidentTypes(req, resp);
		} else if (userAction.equals("Get_Resident_Details")) {
			getResidentDetails(req, resp);
		} else if (userAction.equals("Update_Resident_Details")) {
			processResidentDetails(req, resp);
		} else if (userAction.equals("Delete_Resident_Details")) {
			deleteResidentDetails(req, resp);
		} else if (userAction.equals("Get_Society_Roles_Options")) {
			getSocietyRolesOption(req, resp);
		} else if (userAction.equals("Get_Status_Options")) {
			getStatusOption(req, resp);
		}
	}



	private void deleteAssetDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	private void getStatusOption(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		List<Status> statuses = getStatuses();

		String jsonStr = "";
		jsonStr = "{\"Result\":\"OK\",\"Options\":[";
		for (Status status : statuses) {
			jsonStr = jsonStr + "{\"DisplayText\":\"" + status.getStatusName()
					+ "\",\"Value\":\"" + status.getStatusID().getId() + "\"},";
		}

		jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";
		System.out.println(jsonStr);
		resp.getWriter().print(jsonStr);

	}
	
	private void processAssetDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (null == req.getParameter("assetID")) {
			Asset assets = new Asset();
			assets.setAssetName(req.getParameter("assetName"));
			assets.setAssetNO(req.getParameter("assetNO"));
			assets.setquantity(Integer.parseInt(req
					.getParameter("quantity")));
			assets.setTotalAssets(Integer.parseInt(req
					.getParameter("totalassets")));
			assets.set_Asset_Desc(req.getParameter("asset_description"));
			assets.set_Asset_Model(req.getParameter("assetModel"));
			
			if (null != req.getParameter("asset_purchase_date")) {
				Calendar asset_purchase_date = new GregorianCalendar();
				try {
					asset_purchase_date.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("asset_purchase_date")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				assets.set_Asset_Purchase_Date(asset_purchase_date.getTime());
			}
			
			if (null != req.getParameter("asset_expiry_date")) {
				Calendar asset_expiry_date = new GregorianCalendar();
				try {
					asset_expiry_date.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("asset_expiry_date")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				assets.set_Asset_Expiry_Date(asset_expiry_date.getTime());
			}
			
			pm.makePersistent(assets);
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Asset> asset = soc.getAsset();
				if (asset == null) {
					asset = new ArrayList<Asset>();
				}
				asset.add(assets);
				soc.setAsset(asset);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ assets.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Asset> assets = soc.getAsset();
				for (Asset asset : assets) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("assetID"));

					long assetID = Long.parseLong(req
							.getParameter("assetID"));
					if (asset.getAssetID().getId() == assetID) {
						asset.setAssetName(req
								.getParameter("assetName"));
						asset.setAssetNO(req.getParameter("assetNO"));
						
						if (null != req.getParameter("asset_purchase_date")) {
							Calendar asset_purchase_date = new GregorianCalendar();
							try {
								asset_purchase_date.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("asset_purchase_date")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							asset.set_Asset_Purchase_Date(asset_purchase_date.getTime());
						}
						
						if (null != req.getParameter("asset_expiry_date")) {
							Calendar asset_expiry_date = new GregorianCalendar();
							try {
								asset_expiry_date.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("asset_expiry_date")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							asset.set_Asset_Expiry_Date(asset_expiry_date.getTime());
						}
												
						asset.set_Asset_Model(req.getParameter("assetModel"));
						asset.set_Asset_Desc(req.getParameter("asset_description"));
						asset.setTotalAssets(Integer.parseInt(req
								.getParameter("totalassets")));
						asset.setquantity(Integer.parseInt(req
								.getParameter("quantity")));
						pm.makePersistent(asset);
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ asset.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	}

	private void deleteResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Member> members = (List<Member>) soc.getMembers();

			Gson gson = new Gson();
			System.out.println(req.getParameter("memberID[id]"));

			long memberID = Long.parseLong(req.getParameter("memberID[id]"));
			Key memberKey = KeyFactory.createKey(Member.class.getSimpleName(),
					memberID);
			Member member = pm.getObjectById(Member.class, memberKey);
			
			
			
			
			if(members != null){
				members.remove(member);
			}
			
			Query q = pm.newQuery(MemberHouse.class);
			q.setFilter("memberID == memberIDParam");
			q.declareParameters(Key.class.getName() + " memberIDParam");
			q.deletePersistentAll(memberKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(member);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
	}

	private void processResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		Member member = null;
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			if (null == req.getParameter("memberID")) {
				member = new Member();
				member.setDefaultSociety(soc);
				member.setSocieties(new ArrayList<Society>());
				member.getSocieties().add(soc);
			} else {
				long memberID = Long.parseLong(req.getParameter("memberID"));
				member = getMemberFromSocietyByMemberID(memberID, soc);
			}
			String address = req.getParameter("address");
			member.setAddress(address);

			member.setEmail(req.getParameter("email"));
			member.setFirstName(req.getParameter("firstName"));
			member.setMiddleName(req.getParameter("middleName"));
			member.setLastName(req.getParameter("lastName"));
			member.setPhone(req.getParameter("phone"));

			// member.setStatus(req.getParameter("status"));

			pm.makePersistent(member);

			SocietyMemberRole socMemRole = null;
			if (null == req.getParameter("memberID")) {
				socMemRole = new SocietyMemberRole();
			} else {
				socMemRole = getUserRoleForSociety(soc.getSocietyID(),
						member.getMemberID()).get(0);
			}
			socMemRole.setMemberID(member.getMemberID());
			socMemRole.setSocietyID(soc.getSocietyID());

			Status status = getStatusByID(Long.parseLong(req
					.getParameter("status")));
			socMemRole.setStatus(status);

			Role role = getRoleByID(Long.parseLong(req
					.getParameter("memberRole")));
			socMemRole.setRole(role);
			pm.makePersistent(socMemRole);

			if (null == req.getParameter("memberID")) {
				List<Member> members =  soc.getMembers();
				if (members == null) {
					members = new ArrayList<Member>();
				}
				members.add(member);
			//	soc.setMembers(members);
			}
			pm.makePersistent(soc);

			String jsonStr = null;
			MemberHouse memberHouse = null;
			if (req.getParameter("houseID") != null) {
				Key houseID = KeyFactory.createKey(House.class.getSimpleName(),
						Long.parseLong(req.getParameter("houseID")));
				memberHouse = persistMemberHouse(member.getMemberID(), houseID,
						req);
			}

			MemberHouseDetail memberHouseDetail = populateMemberHouseDetailBean(
					member, memberHouse, socMemRole);
			jsonStr = "{\"Result\":\"OK\",\"Record\":"
					+ memberHouseDetail.serializedJSON() + "}";
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);

		}

	}

	
	private MemberHouseDetail populateMemberHouseDetailBean(Member member,
			MemberHouse memberHouse, SocietyMemberRole memberRole) {
		MemberHouseDetail memberHouseDetail = new MemberHouseDetail();
		String firstName = "";
		if (null != member.getFirstName()) {
			firstName = member.getFirstName();
		}

		String middleName = "";

		if (null != member.getMiddleName()) {
			middleName = member.getMiddleName();
		}

		String lastName = "";

		if (null != member.getLastName()) {
			lastName = member.getLastName();
		}

		memberHouseDetail.setMemberID(member.getMemberID());
		memberHouseDetail.setFirstName(firstName);
		memberHouseDetail.setMiddleName(middleName);
		memberHouseDetail.setLastName(lastName);
		memberHouseDetail.setFullName(firstName + " " + middleName + " "
				+ lastName);
		memberHouseDetail.setEmail(member.getEmail());
		memberHouseDetail.setAddress(member.getAddress());
		memberHouseDetail.setPhone(member.getPhone());
		memberHouseDetail.setStatus(memberRole.getStatus());
		memberHouseDetail.setMemberRole(memberRole.getRole());

		if (memberHouse != null) {
			memberHouseDetail.setResidentType(memberHouse.getResidentType());
			memberHouseDetail.setSinceDate(memberHouse.getSinceDate());
			memberHouseDetail.setToDate(memberHouse.getToDate());
		}

		return memberHouseDetail;
	}

	private void getResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Member> socmembers = (List<Member>) soc.getMembers();

			List<MemberHouse> memberHouseList = new ArrayList<MemberHouse>();
			String queryText = "select from com.viraneel.apartmentspot.entities.Member";
			Query q = pm.newQuery(queryText);
			if (req.getParameter("houseID") != null) {
				long houseID = Long.parseLong(req.getParameter("houseID"));
				Key houseKey = KeyFactory.createKey(
						House.class.getSimpleName(), houseID);
				Query q1 = pm
						.newQuery("select from com.viraneel.apartmentspot.entities.MemberHouse where houseID == houseIDParam");
				q1.declareParameters(Key.class.getName() + " houseIDParam");
				memberHouseList = (List<MemberHouse>) q1.execute(houseKey);


				if (memberHouseList.isEmpty()) {
					jsonStr = "{\"Result\":\"OK\",\"Records\":[]"
							+ ", \"TotalRecordCount\":\"0" + "\"}";
					resp.getWriter().print(jsonStr);
					return;
				}

			}

			

			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(socmembers);

			if (null != req.getParameter("jtStartIndex")) {
				int startIndex = Integer.parseInt(req
						.getParameter("jtStartIndex"));
				int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));

				int endIndex = startIndex + pageSize;
				if (endIndex >= socmembers.size()) {
					endIndex = socmembers.size();
				}
				System.out.println("StartIndex=" + startIndex + " endIndex="
						+ endIndex);
				q.setRange(startIndex, endIndex);
			}

			if (null != req.getParameter("jtSorting")) {
				String paramOrderBy = req.getParameter("jtSorting");
				q.setOrdering(paramOrderBy);
			}
			List<Member> members = null;
			if (memberHouseList.size() > 0) {
				members = new ArrayList<Member>();
				for(MemberHouse memHouse : memberHouseList){
					Member member = pm.getObjectById(Member.class, memHouse.getMemberID());
					members.add(member);
				}
			} else {
				Object o = q.execute();
				System.out.println(o.getClass().getName());
				members = (List<Member>)o;
			}
			System.out
					.println("memberList Size from query = " + members.size());

			List<MemberHouseDetail> memberHouseDetails = new ArrayList<MemberHouseDetail>();

			for (Member member : members) {
				SocietyMemberRole memberRole = getMemberRoleinSociety(soc,
						member);
				MemberHouse memberHouse = getMemberHouseFromList(
						memberHouseList, member);
				MemberHouseDetail memberHouseDetail = populateMemberHouseDetailBean(
						member, memberHouse, memberRole);

				memberHouseDetails.add(memberHouseDetail);
			}
			jsonStr = getJSONString(memberHouseDetails);

			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + socmembers.size() + "\"}";
			System.out.println(jsonStr);

		}
		resp.getWriter().print(jsonStr);

	}

	private MemberHouse getMemberHouseFromList(
			List<MemberHouse> memberHouseList, Member member) {
		MemberHouse memberHouse = null;
		if (memberHouseList.size() > 0) {
			for (MemberHouse memHouse : memberHouseList) {

				if (memHouse.getMemberID().getId() == member.getMemberID()
						.getId()) {
					memberHouse = memHouse;
					break;
				}
			}

		}
		return memberHouse;
	}

	private List<MemberHouse> getMemberHousesFromDB(Key memberKey, Key houseKey) {
		MemberHouse memberHouse = null;
		Query q1 = pm
				.newQuery("select from com.viraneel.apartmentspot.entities.MemberHouse "
						+ "where memberID == memberIDParam && houseID == houseIDParam "
						+ "parameters "
						+ Key.class.getName()
						+ " memberIDParam, "
						+ Key.class.getName()
						+ " houseIDParam");

		List<MemberHouse> memberHouseList = (List<MemberHouse>) q1.execute(
				memberKey, houseKey);

		return memberHouseList;
	}

	public void getSocietyRolesOption(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		List<Role> roles = getRoles();

		String jsonStr = "";
		jsonStr = "{\"Result\":\"OK\",\"Options\":[";
		for (Role role : roles) {
			jsonStr = jsonStr + "{\"DisplayText\":\"" + role.getRoleName()
					+ "\",\"Value\":\"" + role.getRoleID().getId() + "\"},";
		}

		jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";
		System.out.println(jsonStr);
		resp.getWriter().print(jsonStr);
	}

	private SocietyMemberRole getMemberRoleinSociety(Society soc, Member member) {
		SocietyMemberRole memberRole = null;
		Key societyIDParam = soc.getSocietyID();
		Key memberIDParam = member.getMemberID();

		Query q2 = pm.newQuery("select from  "
				+ SocietyMemberRole.class.getName()
				+ " where societyID == societyIDParam "
				+ "&& memberID == memberIDParam " + "parameters "
				+ Key.class.getName() + " societyIDParam,"
				+ Key.class.getName() + " memberIDParam ");
		List<SocietyMemberRole> societyUserRoles = (List<SocietyMemberRole>) q2
				.execute(societyIDParam, memberIDParam);
		if (societyUserRoles != null && !societyUserRoles.isEmpty()) {
			memberRole = societyUserRoles.get(0);
		}
		return memberRole;
	}

	private void getResidentTypes(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		if (null != userSessionProfile) {
			List<ResidentType> ResidentTypes = getResidentTypes();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (ResidentType ResidentType : ResidentTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ ResidentType.getResidentType() + "\",\"Value\":\""
						+ ResidentType.getResidentType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}

	private void getHouseTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		if (null != userSessionProfile) {
			List<HouseType> houseTypes = getHouseTypes();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (HouseType houseType : houseTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ houseType.getHouseType() + "\",\"Value\":\""
						+ houseType.getHouseType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}

	private void deleteHouseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<House> houses = soc.getHouses();

			Gson gson = new Gson();
			System.out.println(req.getParameter("houseID[id]"));

			long houseID = Long.parseLong(req.getParameter("houseID[id]"));
			Key houseKey = KeyFactory.createKey(House.class.getSimpleName(),
					houseID);
			House house = pm.getObjectById(House.class, houseKey);
			
			
			
			
			if(houses != null){
				houses.remove(house);
			}
			
			Query q = pm.newQuery(MemberHouse.class);
			q.setFilter("houseID == houseIDParam");
			q.declareParameters(Key.class.getName() + " houseIDParam");
			q.deletePersistentAll(houseKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(house);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
	}

	private void getHouseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<House> sochouses = (List<House>) soc.getHouses();

			
			List<MemberHouse> memberHouseList = new ArrayList<MemberHouse>();
			if (req.getParameter("memberID") != null) {
				long memberID = Long.parseLong(req.getParameter("memberID"));
				Key memberKey = KeyFactory.createKey(
						Member.class.getSimpleName(), memberID);
				Query q1 = pm
						.newQuery("select from com.viraneel.apartmentspot.entities.MemberHouse where memberID == memberIDParam");
				q1.declareParameters(Key.class.getName() + " memberIDParam");
				memberHouseList = (List<MemberHouse>) q1.execute(memberKey);



				if (memberHouseList.isEmpty()) {
					jsonStr = "{\"Result\":\"OK\",\"Records\":[]"
							+ ", \"TotalRecordCount\":\"0" + "\"}";
					resp.getWriter().print(jsonStr);
					return;
				}

			}

			String queryText = "select from com.viraneel.apartmentspot.entities.House";



			System.out.println(queryText);
			Query q = pm.newQuery(queryText);
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(sochouses);

			if (null != req.getParameter("jtStartIndex")) {
				int startIndex = Integer.parseInt(req
						.getParameter("jtStartIndex"));
				int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));

				int endIndex = startIndex + pageSize;
				if (endIndex >= sochouses.size()) {
					endIndex = sochouses.size();
				}
				System.out.println("StartIndex=" + startIndex + " endIndex="
						+ endIndex);
				q.setRange(startIndex, endIndex);
			}

			if (req.getParameter("jtSorting") != null) {
				String paramOrderBy = req.getParameter("jtSorting");
				q.setOrdering(paramOrderBy);
			}

			List<House> houses = null;
			if (memberHouseList.size() > 0) {
				//houses = (List<House>) q.execute(houseKeyList);
				houses = new ArrayList<House>();
				for(MemberHouse memHouse: memberHouseList){
					House house = pm.getObjectById(House.class, memHouse.getHouseID());
					houses.add(house);
				}
				
				
				if (null != houses) {
					List<MemberHouseDetail> memberHouseDetailList = new ArrayList<MemberHouseDetail>();
					for (House house : houses) {
						for (MemberHouse memberhouse : memberHouseList) {
							if (house.getHouseID().getId() == memberhouse
									.getHouseID().getId()) {
								MemberHouseDetail memberHouseDetail = populateMemberHouseDetailBean(
										house, memberhouse);
								memberHouseDetailList.add(memberHouseDetail);
							}
						}
					}

					jsonStr = getJSONString(memberHouseDetailList);
					jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
							+ ", \"TotalRecordCount\":\"" + sochouses.size()
							+ "\"}";
				}
			} else {
				houses = (List<House>) q.execute();

				jsonStr = getJSONString(houses);
				jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
						+ ", \"TotalRecordCount\":\"" + sochouses.size()
						+ "\"}";
			}

		}
		resp.getWriter().print(jsonStr);

	}

	private MemberHouseDetail populateMemberHouseDetailBean(House house,
			MemberHouse memberhouse) {
		MemberHouseDetail memberHouseDetail = new MemberHouseDetail();
		memberHouseDetail.setHouseID(house.getHouseID());
		memberHouseDetail.setHouseName(house.getHouseName());
		memberHouseDetail.setHouseNo(house.getHouseNo());
		memberHouseDetail.setBuiltupAreaSQFT(house.getBuiltupAreaSQFT());
		memberHouseDetail.setCarpetAreaSQFT(house.getCarpetAreaSQFT());
		memberHouseDetail.setTotalAreaSQFT(house.getTotalAreaSQFT());
		memberHouseDetail.setIntercomNo(house.getIntercomNo());
		memberHouseDetail.setHouseType(house.getHouseType());
		memberHouseDetail.setOpenSpaceAreaSQFT(house.getOpenSpaceAreaSQFT());
		memberHouseDetail.setParkingSpots(house.getParkingSpots());
		memberHouseDetail.setPlotNo(house.getPlotNo());
		memberHouseDetail.setResidentType(memberhouse.getResidentType());
		memberHouseDetail.setSinceDate(memberhouse.getSinceDate());
		memberHouseDetail.setToDate(memberhouse.getToDate());
		return memberHouseDetail;
	}

	private void processHouseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		House house = null;
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			if (null == req.getParameter("houseID")) {
				house = new House();
			} else {
				long houseID = Long.parseLong(req.getParameter("houseID"));
				house = getHouseFromSocietyByHouseID(houseID, soc);
			}

			house.setHouseNo(req.getParameter("houseNo"));
			house.setPlotNo(req.getParameter("plotNo"));
			house.setHouseName(req.getParameter("houseName"));

			if (null != req.getParameter("builtupAreaSQFT")) {
				house.setBuiltupAreaSQFT(Double.parseDouble(req
						.getParameter("builtupAreaSQFT")));
			}

			if (null != req.getParameter("carpetAreaSQFT")) {
				house.setCarpetAreaSQFT(Double.parseDouble(req
						.getParameter("carpetAreaSQFT")));
			}

			if (null != req.getParameter("totalAreaSQFT")) {
				house.setTotalAreaSQFT(Double.parseDouble(req
						.getParameter("totalAreaSQFT")));
			}

			if (null != req.getParameter("openSpaceAreaSQFT")) {
				house.setOpenSpaceAreaSQFT(Double.parseDouble(req
						.getParameter("openSpaceAreaSQFT")));
			}

			if (null != req.getParameter("building") && !req.getParameter("building").isEmpty()) {
				house.setBuilding(pm.getObjectById(Building.class,
						Long.parseLong(req.getParameter("building"))));

			}

			if (null != req.getParameter("houseType")) {

				for (HouseType houseType : getHouseTypes()) {
					if (houseType.getHouseType().equalsIgnoreCase(
							req.getParameter("houseType"))) {
						house.setHouseType(houseType);
						break;
					}
				}
			}
			house.setIntercomNo(req.getParameter("intercomNo"));
			if (null != req.getParameter("parkingSpots")) {
				house.setParkingSpots(Arrays.asList(req.getParameter(
						"parkingSpots").split(",")));
			}

			pm.makePersistent(house);
			if (null == req.getParameter("houseID")) {
				List<House> houses = (List<House>) soc.getHouses();
				if (houses == null) {
					houses = new ArrayList<House>();
				}
				houses.add(house);
				soc.setHouses(houses);
			}
			pm.makePersistent(soc);

			String jsonStr = null;
			if (req.getParameter("memberID") != null) {
				Key memberID = KeyFactory.createKey(
						Member.class.getSimpleName(),
						Long.parseLong(req.getParameter("memberID")));
				MemberHouse memberHouse = persistMemberHouse(memberID,
						house.getHouseID(), req);
				MemberHouseDetail memberHouseDetail = populateMemberHouseDetailBean(
						house, memberHouse);
				jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ memberHouseDetail.serializedJSON() + "}";
			} else {
				jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ house.serializedJSON() + "}";
			}

			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);

		}

	}

	private Member getMemberFromSocietyByMemberID(long memberID, Society soc) {
		List<Member> members = (List<Member>) soc.getMembers();

		Key memberKey = KeyFactory.createKey(Member.class.getSimpleName(),
				memberID);
		Query q = pm.newQuery("select from " + Member.class.getName() + " where memberID == memberIDParam");
		q.addExtension("datanucleus.query.evaluateInMemory", "true");
		q.setCandidates(members);
		q.declareParameters(Key.class.getName() + " memberIDParam");

		List<Member> result = (List<Member>) q.execute(memberKey);
		Member member = result.get(0);
		return member;
	}

	private House getHouseFromSocietyByHouseID(long houseID, Society soc) {
		List<House> houses = soc.getHouses();

		Key houseKey = KeyFactory.createKey(House.class.getSimpleName(),
				houseID);
		Query q = pm.newQuery("select from " + House.class.getName() + " where houseID == houseIDParam");
		q.addExtension("datanucleus.query.evaluateInMemory", "true");
		q.setCandidates(houses);
		q.declareParameters(Key.class.getName() + " houseIDParam");

		List<House> result = (List<House>) q.execute(houseKey);
		House house = result.get(0);
		return house;
	}

	private MemberHouse persistMemberHouse(Key memberID, Key houseID,
			HttpServletRequest req) {

		List<MemberHouse> memberHouses = getMemberHousesFromDB(memberID,
				houseID);
		MemberHouse memberHouse = null;
		if (memberHouses == null || memberHouses.isEmpty()) {
			memberHouse = new MemberHouse();
			memberHouse.setMemberID(memberID);
			memberHouse.setHouseID(houseID);
		} else {
			memberHouse = memberHouses.get(0);
		}

		if (null != req.getParameter("sinceDate")) {
			Calendar sinceDate = new GregorianCalendar();
			try {
				sinceDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
						.getParameter("sinceDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			memberHouse.setSinceDate(sinceDate.getTime());
		}

		if (null != req.getParameter("toDate")) {
			Calendar toDate = new GregorianCalendar();
			try {
				toDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
						.getParameter("toDate")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			memberHouse.setToDate(toDate.getTime());
		}

		if (null != req.getParameter("residentType")) {
			String residentTypeVal = req.getParameter("residentType");
			for (ResidentType residentType : getResidentTypes()) {

				if (residentType.getResidentType().equalsIgnoreCase(
						residentTypeVal)) {
					memberHouse.setResidentType(residentType);
					break;
				}
			}

		}

		pm.makePersistent(memberHouse);
		return memberHouse;
	}

	private void deleteBuildingDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		// Building socBuilding= null;
		Enumeration params = req.getParameterNames();

		while (params.hasMoreElements()) {
			String fieldName = (String) params.nextElement();
			System.out.println(fieldName);
		}

		System.out.println(req.getParameterMap());

		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Building> buildings = soc.getBuildings();
			for (Building building : buildings) {

				long buildingID = Long.parseLong(req
						.getParameter("buildingID[id]"));
				System.out.println(buildingID + " "
						+ building.getBuildingID().getId());
				if (building.getBuildingID().getId() == buildingID) {
					Building buildingMaster = pm.getObjectById(Building.class,
							building.getBuildingID());
					pm.deletePersistent(building);
					pm.deletePersistent(buildingMaster);
					pm.makePersistent(soc);
					Society refreshedSoc = pm.getObjectById(Society.class,
							soc.getSocietyID());
					userSessionProfile.setCurrentSociety(refreshedSoc);
					req.getSession().setAttribute("userSessionProfile", userSessionProfile);
					String jsonStr = "{\"Result\":\"OK\"}";
					resp.getWriter().print(jsonStr);
					break;
				}
			}

		}

	}

	 private void getAssetDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Asset> socAssets = soc.getAsset();
			int startIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
			int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			String paramOrderBy = req.getParameter("jtSorting");

			int endIndex = startIndex + pageSize;
			if (endIndex >= socAssets.size()) {
				endIndex = socAssets.size();
			}
			System.out.println("StartIndex=" + startIndex + " endIndex="
					+ endIndex);
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Asset");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(socAssets);
			q.setRange(startIndex, endIndex);
			q.setOrdering(paramOrderBy);
			List<Asset> assets = (List<Asset>) q.execute();

			jsonStr = getJSONString(assets);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + socAssets.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);

	} 
	
	private void processBuildingsDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (null == req.getParameter("buildingID")) {
			Building building = new Building();
			building.setBuildingName(req.getParameter("buildingName"));
			building.setBuildingNO(req.getParameter("buildingNO"));
			building.setTotalFloors(Integer.parseInt(req
					.getParameter("totalFloors")));
			building.setTotalHouses(Integer.parseInt(req
					.getParameter("totalHouses")));
			pm.makePersistent(building);

			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Building> buildings = soc.getBuildings();
				if (buildings == null) {
					buildings = new ArrayList<Building>();
				}
				buildings.add(building);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ building.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Building> buildings = soc.getBuildings();
				for (Building building : buildings) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("buildingID"));

					long buildingID = Long.parseLong(req
							.getParameter("buildingID"));
					if (building.getBuildingID().getId() == buildingID) {
						building.setBuildingName(req
								.getParameter("buildingName"));
						building.setBuildingNO(req.getParameter("buildingNO"));
						building.setTotalFloors(Integer.parseInt(req
								.getParameter("totalFloors")));
						building.setTotalHouses(Integer.parseInt(req
								.getParameter("totalHouses")));
						pm.makePersistent(building);
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ building.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	}

	private void getBuildingOptions(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Building> socbuildings = soc.getBuildings();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[{\"DisplayText\":\"\",\"Value\":\"\"},";
			for (Building building : socbuildings) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ building.getBuildingNO() + " "
						+ building.getBuildingName() + "\",\"Value\":\""
						+ building.getBuildingID().getId() + "\"},";
			}

		}
		jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";
		System.out.println(jsonStr);
		resp.getWriter().print(jsonStr);

	}
	
	private void getBuildingDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {

		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Building> socbuildings = soc.getBuildings();
			int startIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
			int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			String paramOrderBy = req.getParameter("jtSorting");

			int endIndex = startIndex + pageSize;
			if (endIndex >= socbuildings.size()) {
				endIndex = socbuildings.size();
			}
			System.out.println("StartIndex=" + startIndex + " endIndex="
					+ endIndex);
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Building");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(socbuildings);
			q.setRange(startIndex, endIndex);
			q.setOrdering(paramOrderBy);
			List<Building> buildings = (List<Building>) q.execute();

			jsonStr = getJSONString(buildings);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + socbuildings.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);

	}

	private void processSocietyDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (req.getParameter("societyID").equalsIgnoreCase("")) {
			// code to add society
			Society soc = new Society();
			soc.setName(req.getParameter("societyName"));
			soc.setEmail(req.getParameter("email"));
			soc.setPhone(req.getParameter("phone"));
			soc.setArea(req.getParameter("area"));
			soc.setLandmark(req.getParameter("landmark"));
			soc.setCity(req.getParameter("city"));
			soc.setState(req.getParameter("state"));
			soc.setCountry(req.getParameter("country"));
			soc.setEmail(req.getParameter("email"));
			soc.setPhone(req.getParameter("phone"));
			soc.setFax(req.getParameter("fax"));
			soc.setRoad(req.getParameter("road"));
			soc.setZip(req.getParameter("zip"));
			soc.setRegistrationDate(req.getParameter("registrationDate"));
			soc.setRegistrationNumber(req.getParameter("registrationNumber"));
			soc.setBuilderName(req.getParameter("builderName"));
			soc.setBuilderAddress(req.getParameter("builderAddress"));
			pm.makePersistent(soc);

			UserService userService = UserServiceFactory.getUserService();
			User user = userService.getCurrentUser();
			
			Member siteUser = new Member();
			siteUser.setFirstName(user.getNickname());
			siteUser.setEmail(user.getEmail());



			List<Member> memberList = new ArrayList<Member>();
			memberList.add(siteUser);
			List<Society> societyList = new ArrayList<Society>();
			societyList.add(soc);
			if (null != siteUser.getSocieties()) {
				siteUser.getSocieties().add(soc);
			} else {
				siteUser.setSocieties(societyList);
			}
			siteUser.setDefaultSociety(soc);
			pm.makePersistent(siteUser);
			soc.setMembers(memberList);
			pm.makePersistent(soc);

			SocietyMemberRole socMemRole = new SocietyMemberRole();
			socMemRole.setMemberID(siteUser.getMemberID());
			socMemRole.setSocietyID(soc.getSocietyID());
			socMemRole.setRole(getRole("societyAdmin"));
			pm.makePersistent(socMemRole);

			UserSessionProfile userSessionProfile = new UserSessionProfile();
			userSessionProfile.setCurrentSociety(soc);
			userSessionProfile.setCurrentUser(siteUser);
			req.getSession().setAttribute("userSessionProfile",
					userSessionProfile);
			resp.getWriter().print("INSERT SUCCESS");

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				soc.setName(req.getParameter("societyName"));
				soc.setEmail(req.getParameter("email"));
				soc.setPhone(req.getParameter("phone"));
				soc.setArea(req.getParameter("area"));
				soc.setLandmark(req.getParameter("landmark"));
				soc.setCity(req.getParameter("city"));
				soc.setState(req.getParameter("state"));
				soc.setCountry(req.getParameter("country"));
				soc.setEmail(req.getParameter("email"));
				soc.setPhone(req.getParameter("phone"));
				soc.setFax(req.getParameter("fax"));
				soc.setRoad(req.getParameter("road"));
				soc.setZip(req.getParameter("zip"));
				soc.setRegistrationDate(req.getParameter("registrationDate"));
				soc.setRegistrationNumber(req
						.getParameter("registrationNumber"));
				soc.setBuilderName(req.getParameter("builderName"));
				soc.setBuilderAddress(req.getParameter("builderAddress"));
				soc.setSurveyNumber(req.getParameter("surveyNumber"));
				pm.makePersistent(soc);
				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				resp.getWriter().print("UPDATE SUCCESS");
			}
		}
	}

}
