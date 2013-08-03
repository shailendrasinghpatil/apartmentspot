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

import com.viraneel.apartmentspot.entities.BillingHeads;
import com.viraneel.apartmentspot.entities.BillingHeadType;
import com.viraneel.apartmentspot.entities.Receipt;
import com.viraneel.apartmentspot.entities.Refund;
import com.viraneel.apartmentspot.entities.Vendor;
import com.viraneel.apartmentspot.entities.VendorType;

import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.Status;
import com.viraneel.apartmentspot.entities.WebSite;
import com.viraneel.apartmentspot.framework.persistence.PersistenceMgrFactory;
import com.viraneel.apartmentspot.valuebeans.UserSessionProfile;



@SuppressWarnings("serial")
public class Accounting extends BaseServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String userAction = req.getParameter("userAction");
		if (userAction.equalsIgnoreCase("Update_Refund_Details")) {
			processRefundDetails(req, resp);
		} else if (userAction.equals("Get_Refund_Details")) {
			getRefundDetails(req, resp);
		} else if (userAction.equals("Delete_Refund_Details")) {
			deleteRefundDetails(req, resp);
		} else if (userAction.equalsIgnoreCase("Update_Receipt_Details")) {
			processReceiptDetails(req, resp);
		} else if (userAction.equals("Get_Receipt_Details")) {
			getReceiptDetails(req, resp);
		} else if (userAction.equals("Delete_Receipt_Details")) {
			deleteReceiptDetails(req, resp); 
		} else if (userAction.equals("Get_BillingHead_Options")) {
			getBillingHeadTypes(req, resp); 
		} 
	}



	private void getBillingHeadTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		
		if (null != userSessionProfile) {
			List<BillingHeadType> billingTypes  = getBillingHeadType();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (BillingHeadType billingHeadtype : billingTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ billingHeadtype.getBillingHeadType() + "\",\"Value\":\""
						+ billingHeadtype.getBillingHeadType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}
	
	
	private void getRefundDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Refund> refunds = soc.getRefund();
			int startIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
			int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			String paramOrderBy = req.getParameter("jtSorting");

			int endIndex = startIndex + pageSize;
			if (endIndex >= refunds.size()) {
				endIndex = refunds.size();
			}
			System.out.println("StartIndex=" + startIndex + " endIndex="
					+ endIndex);
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Refund");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(refunds);
			q.setRange(startIndex, endIndex);
			q.setOrdering(paramOrderBy);
			List<Refund> refund = (List<Refund>) q.execute();

			jsonStr = getJSONString(refund);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + refunds.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);
	
	}

	private void processRefundDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
	
		if (null == req.getParameter("refundID")) {
			Refund refund = new Refund();
			refund.setRefundNumber(req.getParameter("refundNumber"));
			refund.setRefundReason(req.getParameter("refundReason"));
			refund.setRefundPaymentDetails(req.getParameter("refundPaymentDetails"));
			refund.setRefundTo(req.getParameter("refundTo"));
			
			
			if (null != req.getParameter("refundDate")) {
				Calendar refundDate = new GregorianCalendar();
				try {
					refundDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("refundDate")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				refund.setRefundDate(refundDate.getTime());
			}
			
			if (null != req.getParameter("refundType")) {

				for (BillingHeadType refundType : getBillingHeadType()) {
					if (refundType.getBillingHeadType().equalsIgnoreCase(
							req.getParameter("billingHeadType"))) {
						refund.setBillingHeadType(refundType);
						break;
					}
				}
			}
			
						
			refund.setRefundAmount(req.getParameter("refundAmount"));
			
			pm.makePersistent(refund);
			
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Refund> refunds = soc.getRefund();
				if (refunds == null) {
					refunds = new ArrayList<Refund>();
				}
				refunds.add(refund);
				soc.setRefund(refunds);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ refund.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Refund> refunds = soc.getRefund();
				for (Refund refund : refunds) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("refundID"));

					long refundID = Long.parseLong(req
							.getParameter("refundID"));
					if (refund.getRefundID().getId() == refundID) {
						
						refund.setRefundNumber(req.getParameter("refundNumber"));
						refund.setRefundReason(req.getParameter("refundReason"));
						refund.setRefundPaymentDetails(req.getParameter("refundPaymentDetails"));
						refund.setRefundTo(req.getParameter("refundTo"));
						
						
						if (null != req.getParameter("refundDate")) {
							Calendar refundDate = new GregorianCalendar();
							try {
								refundDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("refundDate")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							refund.setRefundDate(refundDate.getTime());
						}
						
						if (null != req.getParameter("refundType")) {

							for (BillingHeadType refundType : getBillingHeadType()) {
								if (refundType.getBillingHeadType().equalsIgnoreCase(
										req.getParameter("billingHeadType"))) {
									refund.setBillingHeadType(refundType);
									break;
								}
							}

						}
						
						refund.setRefundAmount(req.getParameter("refundAmount"));
											
						pm.makePersistent(refund);
						
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ refund.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	
	}

	
	private void deleteRefundDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Refund> socFacilities = soc.getRefund();

			Gson gson = new Gson();
			System.out.println(req.getParameter("assetID[id]"));

			long refundID = Long.parseLong(req.getParameter("refundID[id]"));
			Key refundKey = KeyFactory.createKey(Refund.class.getSimpleName(),
					refundID);
			Refund refund = pm.getObjectById(Refund.class, refundKey);
			
			if(socFacilities != null){
				socFacilities.remove(refund);
			}
			
			Query q = pm.newQuery(Refund.class);
			q.setFilter("refundID == refundIDParam");
			q.declareParameters(Key.class.getName() + " refundIDParam");
			q.deletePersistentAll(refundKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(refund);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
		
	}

	private void getRefundTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		
		if (null != userSessionProfile) {
			List<BillingHeadType> billingHeadTypes  = getBillingHeadType();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (BillingHeadType refundtype : billingHeadTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ refundtype.getBillingHeadType() + "\",\"Value\":\""
						+ refundtype.getBillingHeadType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}

	
	
	private void getReceiptDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Receipt> receipts = soc.getReceipt();
			int startIndex = Integer.parseInt(req.getParameter("jtStartIndex"));
			int pageSize = Integer.parseInt(req.getParameter("jtPageSize"));
			String paramOrderBy = req.getParameter("jtSorting");

			int endIndex = startIndex + pageSize;
			if (endIndex >= receipts.size()) {
				endIndex = receipts.size();
			}
			System.out.println("StartIndex=" + startIndex + " endIndex="
					+ endIndex);
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Receipt");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(receipts);
			q.setRange(startIndex, endIndex);
			q.setOrdering(paramOrderBy);
			List<Receipt> receipt = (List<Receipt>) q.execute();

			jsonStr = getJSONString(receipt);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + receipts.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);
	
	}

	private void processReceiptDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
	
		if (null == req.getParameter("receiptID")) {
			Receipt receipt = new Receipt();
			receipt.setReceiptNumber(req.getParameter("receiptNumber"));
			
			receipt.setReceiptDescription(req.getParameter("receiptDescription"));
			receipt.setReceiptTo(req.getParameter("receiptTo"));
			
			
			if (null != req.getParameter("receiptDate")) {
				Calendar receiptDate = new GregorianCalendar();
				try {
					receiptDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("receiptDate")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				receipt.setReceiptDate(receiptDate.getTime());
			}
			
			if (null != req.getParameter("receiptType")) {

				for (BillingHeadType receiptType : getBillingHeadType()) {
					if (receiptType.getBillingHeadType().equalsIgnoreCase(
							req.getParameter("billingHeadType"))) {
						receipt.setBillingHeadType(receiptType);
						break;
					}
				}
			}
			
						
			receipt.setReceiptAmount(req.getParameter("receiptAmount"));
			
			pm.makePersistent(receipt);
			
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Receipt> receipts = soc.getReceipt();
				if (receipts == null) {
					receipts = new ArrayList<Receipt>();
				}
				receipts.add(receipt);
				soc.setReceipt(receipts);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ receipt.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Receipt> receipts = soc.getReceipt();
				for (Receipt receipt : receipts) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("receiptID"));

					long receiptID = Long.parseLong(req
							.getParameter("receiptID"));
					if (receipt.getReceiptID().getId() == receiptID) {
						
						receipt.setReceiptNumber(req.getParameter("receiptNumber"));
						
						receipt.setReceiptDescription(req.getParameter("receiptDescription"));
						receipt.setReceiptTo(req.getParameter("receiptTo"));
						
						
						if (null != req.getParameter("receiptDate")) {
							Calendar receiptDate = new GregorianCalendar();
							try {
								receiptDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("receiptDate")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							receipt.setReceiptDate(receiptDate.getTime());
						}
						
						if (null != req.getParameter("receiptType")) {

							for (BillingHeadType receiptType : getBillingHeadType()) {
								if (receiptType.getBillingHeadType().equalsIgnoreCase(
										req.getParameter("billingHeadType"))) {
									receipt.setBillingHeadType(receiptType);
									break;
								}
							}

						}
						
						receipt.setReceiptAmount(req.getParameter("receiptAmount"));
											
						pm.makePersistent(receipt);
						
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ receipt.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	
	}

	
	private void deleteReceiptDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Receipt> receipts = soc.getReceipt();

			Gson gson = new Gson();
			System.out.println(req.getParameter("assetID[id]"));

			long receiptID = Long.parseLong(req.getParameter("receiptID[id]"));
			Key receiptKey = KeyFactory.createKey(Receipt.class.getSimpleName(),
					receiptID);
			Receipt receipt = pm.getObjectById(Receipt.class, receiptKey);
			
			if(receipts != null){
				receipts.remove(receipt);
			}
			
			Query q = pm.newQuery(Receipt.class);
			q.setFilter("receiptID == receiptIDParam");
			q.declareParameters(Key.class.getName() + " receiptIDParam");
			q.deletePersistentAll(receiptKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(receipt);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
		
	}

	private void getReceiptTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		
		if (null != userSessionProfile) {
			List<BillingHeadType> billingHeadTypes  = getBillingHeadType();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (BillingHeadType receipttype : billingHeadTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ receipttype.getBillingHeadType() + "\",\"Value\":\""
						+ receipttype.getBillingHeadType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}

}
