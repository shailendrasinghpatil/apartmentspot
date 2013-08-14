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
import com.viraneel.apartmentspot.entities.Group;
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
		} else if (userAction.equals("Get_Group_Details")) {
			getGroupDetails(req, resp);
		} else if (userAction.equals("Delete_Group_Details")) {
			deleteGroupDetails(req, resp);
		} else if (userAction.equals("Get_Resident_Details")) {
			getResidentDetails(req, resp);
		} else if (userAction.equals("Update_Resident_Details")) {
			updateResidentDetails(req, resp);
		} else if (userAction.equals("Delete_Resident_Details")) {
			deleteResidentDetails(req, resp);
		}

	}

	private void deleteResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void updateResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void getResidentDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void deleteGroupDetails(HttpServletRequest req,
			HttpServletResponse resp) {
		Group group = (Group) pm.getObjectById(Group.class, Long.parseLong(req.getParameter("groupID[id]")));
		group.setEndDate(Calendar.getInstance().getTime());
		pm.makePersistent(group);

	}

	private void getGroupDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Group> socgroups = (List<Group>) soc.getGroups();
			int startIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
			int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			String paramOrderBy = req.getParameter("jtSorting");

			int endIndex = startIndex + pageSize;
			if (endIndex >= socgroups.size()) {
				endIndex = socgroups.size();
			}
			System.out.println("StartIndex=" + startIndex + " endIndex="
					+ endIndex);
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Group");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(socgroups);
			q.setRange(startIndex, endIndex);
			q.setOrdering(paramOrderBy);
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
			if(socgroups == null){
				socgroups = new ArrayList<Group>();					
			}
			Group group = null;
			if (null == req.getParameter("groupID")) {
				group = new Group();
				group.setCreatedDate(Calendar.getInstance().getTime());
			}
			else{
				group = (Group) pm.getObjectById(Group.class, Long.parseLong(req.getParameter("groupID")));
			}
			populateGroupFromReq(group, req);
			socgroups.add(group);
			pm.makePersistent(group);
			pm.makePersistent(soc);
			jsonStr = "{\"Result\":\"OK\",\"Record\":"
					+ group.serializedJSON() + "}";
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			resp.getWriter().print(jsonStr);			
		}

	}

	private void populateGroupFromReq(Group group, HttpServletRequest req) {
		group.setGroupName(req.getParameter("groupName"));
		group.setGroupDescription(req.getParameter("groupDescription"));
		Key ownerID = null;
		if(null == req.getParameter("ownerID")){
		 ownerID = ((UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile")).getCurrentUser().getMemberID();
		}
		else{
		 ownerID = KeyFactory.createKey(Member.class.getSimpleName(),
				Long.parseLong(req.getParameter("ownerID")));
		}
		group.setOwnerID(ownerID);
		
		
		
	}
}
