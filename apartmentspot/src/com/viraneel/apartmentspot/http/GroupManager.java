package com.viraneel.apartmentspot.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.viraneel.apartmentspot.entities.Group;
import com.viraneel.apartmentspot.entities.GroupMemberDetail;
import com.viraneel.apartmentspot.entities.Member;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.valuebeans.UserSessionProfile;

@SuppressWarnings("serial")
public class GroupManager extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String userAction = req.getParameter("userAction");
		if (userAction.equalsIgnoreCase("Update_Group_Details")) {
			processGroupDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Get_Group_Details")) {
			getGroupDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Delete_Group_Details")) {
			deleteGroupDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Get_Resident_Details")) {
			getResidentDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Get_All_Resident_Details")) {
			getAllResidentDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Update_Resident_Details")) {
			updateResidentDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Delete_Resident_Details")) {
			deleteResidentDetails(req, resp);
		}

	}

	private void deleteResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (null != req.getParameter("groupID")) {
			Key groupID = KeyFactory.createKey(Group.class.getSimpleName(),
					Long.parseLong(req.getParameter("groupID")));		
			Key memberID = KeyFactory.createKey(Member.class.getSimpleName(),Long.parseLong(req.getParameter("memberID[id]")));
			Query q = pm
					.newQuery("select from "
							+ GroupMemberDetail.class.getName()
							+ " where groupID == groupIDParam && memberID == memberIDParam");
			q.declareParameters(Key.class.getName() + " groupIDParam , "
					+ Key.class.getName() + " memberIDParam");
			List<GroupMemberDetail> gmDetails = (List<GroupMemberDetail>) q
					.execute(groupID, memberID);
			GroupMemberDetail gmDetail = gmDetails.get(0);
			pm.deletePersistent(gmDetail);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);			
		}

	}

	private void updateResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		if (null != req.getParameter("selectedRows")) {
			String recordsJSONString = req.getParameter("selectedRows");
			try {
				final JSONObject obj = new JSONObject(recordsJSONString);
				final JSONArray records = obj.getJSONArray("Records");
				int n = records.length();
				for(int i=0; i < n; i++){
					JSONObject groupMember = records.getJSONObject(i);
					JSONObject memberKey = groupMember.getJSONObject("memberID");
					JSONObject groupKey = groupMember.getJSONObject("groupID");
					long memID = memberKey.getLong("id");
					long grpID = groupKey.getLong("id");
					Key groupID = KeyFactory.createKey(Group.class.getSimpleName(),grpID);
					Key memberID = KeyFactory.createKey(Member.class.getSimpleName(),memID);

					Query q = pm.newQuery("select from "
							+ GroupMemberDetail.class.getName()
							+ " where groupID == groupIDParam && memberID == memberIDParam");
					q.declareParameters(Key.class.getName() + " groupIDParam , " + Key.class.getName() + " memberIDParam");
					List<GroupMemberDetail> gmDetails = (List<GroupMemberDetail>) q.execute(groupID, memberID);
					if(gmDetails.isEmpty()){					
						GroupMemberDetail gmDetail = new GroupMemberDetail();
						gmDetail.setGroupID(groupID);
						gmDetail.setMemberID(memberID);
						gmDetail.setSinceDate(Calendar.getInstance().getTime());
						pm.makePersistent(gmDetail);
					}
					
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			

		}

	}

	private void getAllResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (null != req.getParameter("groupID")) {
			Key groupID = KeyFactory.createKey(Group.class.getSimpleName(),
					Long.parseLong(req.getParameter("groupID")));
			Query q = pm.newQuery("select from "
					+ GroupMemberDetail.class.getName()
					+ " where groupID == groupIDParam");
			q.declareParameters(Key.class.getName() + " groupIDParam");

			List<GroupMemberDetail> result = (List<GroupMemberDetail>) q
					.execute(groupID);
			


			for (GroupMemberDetail gmDetail : result) {
				Member member = pm.getObjectById(Member.class,
						gmDetail.getMemberID());
				gmDetail.setFullName(member.getFirstName() + " "
						+ member.getMiddleName() + " " + member.getLastName());

			}



			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Member> socmembers = (List<Member>) soc.getMembers();

				String queryText = "select from com.viraneel.apartmentspot.entities.Member";
				Query q1 = pm.newQuery(queryText);
				q1.addExtension("datanucleus.query.evaluateInMemory", "true");
				q1.setCandidates(socmembers);
				setQueryRangeAndOrder(req, q1, socmembers.size());
				List<Member> members = (List<Member>) q1.execute();
				List<GroupMemberDetail> gmDetails = new ArrayList<GroupMemberDetail>();
				for (Member member : members) {
					GroupMemberDetail gmDetail = new GroupMemberDetail();
					gmDetail.setGroupID(groupID);
					gmDetail.setMemberID(member.getMemberID());
					gmDetail.setFullName(member.getFirstName() + " "
							+ member.getMiddleName() + " "
							+ member.getLastName());
					setStartEndDate(gmDetail, result);
					gmDetails.add(gmDetail);
				}
				String jsonStr = getJSONString(gmDetails);
				jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
						+ ", \"TotalRecordCount\":\"" + socmembers.size()
						+ "\"}";
				resp.getWriter().print(jsonStr);
			}

		}

	}

	private void setStartEndDate(GroupMemberDetail gmDetail,
			List<GroupMemberDetail> result) {

		if (null != result) {
			for (GroupMemberDetail groupMemberDetail : result) {
				if (gmDetail.getMemberID().getId() == groupMemberDetail
						.getMemberID().getId()) {
					gmDetail.setSinceDate(groupMemberDetail.getSinceDate());
					gmDetail.setToDate(groupMemberDetail.getToDate());
					break;
				}
			}
		}

	}

	private void getResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		if (null != req.getParameter("groupID")) {
			Key groupID = KeyFactory.createKey(Group.class.getSimpleName(),
					Long.parseLong(req.getParameter("groupID")));
			Query q = pm.newQuery("select from "
					+ GroupMemberDetail.class.getName()
					+ " where groupID == groupIDParam");
			q.declareParameters(Key.class.getName() + " groupIDParam");
			if (null != req.getParameter("jtSorting")) {
				String paramOrderBy = req.getParameter("jtSorting");
				q.setOrdering(paramOrderBy);
			}
			List<GroupMemberDetail> result = (List<GroupMemberDetail>) q
					.execute(groupID);
			int size = result.size();
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
				result = result.subList(startIndex, endIndex);
			}

			for (GroupMemberDetail gmDetail : result) {
				Member member = pm.getObjectById(Member.class,
						gmDetail.getMemberID());
				gmDetail.setFullName(member.getFirstName() + " " + member.getMiddleName() + " " + member.getLastName());
			}
			String jsonStr = getJSONString(result);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + size + "\"}";
			resp.getWriter().print(jsonStr);

		}

	}

	private void deleteGroupDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		Group group = (Group) pm.getObjectById(Group.class,
				Long.parseLong(req.getParameter("groupID[id]")));
		group.setEndDate(Calendar.getInstance().getTime());
		pm.makePersistent(group);
		String jsonStr = "{\"Result\":\"OK\"}";
		resp.getWriter().print(jsonStr);

	}

	private void getGroupDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Group> socgroups = (List<Group>) soc.getGroups();
			int size = socgroups.size();
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Group");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(socgroups);
			setQueryRangeAndOrder(req, q, size);
			List<Group> groups = (List<Group>) q.execute();

			jsonStr = getJSONString(groups);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + socgroups.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);

	}

	private void processGroupDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Group> socgroups = (List<Group>) soc.getGroups();
			if (socgroups == null) {
				socgroups = new ArrayList<Group>();
			}
			Group group = null;
			if (null == req.getParameter("groupID")) {
				group = new Group();
				group.setCreatedDate(Calendar.getInstance().getTime());
			} else {
				group = (Group) pm.getObjectById(Group.class,
						Long.parseLong(req.getParameter("groupID")));
			}
			populateGroupFromReq(group, req);
			socgroups.add(group);
			pm.makePersistent(group);
			pm.makePersistent(soc);
			jsonStr = "{\"Result\":\"OK\",\"Record\":" + group.serializedJSON()
					+ "}";
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile",
					userSessionProfile);
			resp.getWriter().print(jsonStr);
		}

	}

	private void populateGroupFromReq(Group group, HttpServletRequest req) {
		group.setGroupName(req.getParameter("groupName"));
		group.setGroupDescription(req.getParameter("groupDescription"));
		Key ownerID = null;
		if (null == req.getParameter("ownerID")) {
			ownerID = ((UserSessionProfile) req.getSession().getAttribute(
					"userSessionProfile")).getCurrentUser().getMemberID();
		} else {
			ownerID = KeyFactory.createKey(Member.class.getSimpleName(),
					Long.parseLong(req.getParameter("ownerID")));
		}
		group.setOwnerID(ownerID);

	}
}
