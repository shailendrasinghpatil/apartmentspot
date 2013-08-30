package com.viraneel.apartmentspot.http;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.Gson;
import com.viraneel.apartmentspot.entities.BillingHeadType;
import com.viraneel.apartmentspot.entities.Expense;
import com.viraneel.apartmentspot.entities.ExpenseType;
import com.viraneel.apartmentspot.entities.Receipt;
import com.viraneel.apartmentspot.entities.Refund;
import com.viraneel.apartmentspot.entities.Society;
import com.viraneel.apartmentspot.entities.Voucher;
import com.viraneel.apartmentspot.entities.PurchaseOrder;
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
		} else if (userAction.equals("Get_Receipt_Details")) {
			getReceiptDetails(req, resp);
		} else if (userAction.equals("Delete_Receipt_Details")) {
			deleteReceiptDetails(req, resp); 
		} else if (userAction.equals("Get_Expense_Options")) {
			getExpenseTypes(req, resp); 
		} else if (userAction.equalsIgnoreCase("Update_Voucher_Details")) {
			processVoucherDetails(req, resp);
		} else if (userAction.equals("Get_Voucher_Details")) {
			getVoucherDetails(req, resp);
		} else if (userAction.equals("Delete_Voucher_Details")) {
			deleteVoucherDetails(req, resp); 
		} else if (userAction.equalsIgnoreCase("Update_PurchaseOrder_Details")) {
			processPurchaseOrderDetails(req, resp);
		} else if (userAction.equals("Get_PurchaseOrder_Details")) {
			getPurchaseOrderDetails(req, resp);
		} else if (userAction.equals("Delete_PurchaseOrder_Details")) {
			deletePurchaseOrderDetails(req, resp); 
		} else if (userAction.equalsIgnoreCase("Update_Expense_Details")) {
			processExpenseDetails(req, resp);
		} else if (userAction.equals("Get_Expense_Details")) {
			getExpenseDetails(req, resp);
		} else if (userAction.equals("Delete_Expense_Details")) {
			deleteExpenseDetails(req, resp); 
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
	
	private void getExpenseTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("called");
		
		if (null != userSessionProfile) {
			List<ExpenseType> expenseTypes  = getExpenseType();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (ExpenseType Expensetype : expenseTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ Expensetype.getExpenseType() + "\",\"Value\":\""
						+ Expensetype.getExpenseType() + "\"},";
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
			int size = refunds.size();
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Refund");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(refunds);
			setQueryRangeAndOrder(req, q, size);
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
			refund.setRefundAmount(req.getParameter("refundAmount"));
			
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
						refund.setRefundAmount(req.getParameter("refundAmount"));
						
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
		
		System.out.println("delete refunds called");
		
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
			int size = receipts.size();
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Receipt");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(receipts);
			setQueryRangeAndOrder(req, q, size);
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
			receipt.setReceiptAmount(req.getParameter("receiptAmount"));
			
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
						receipt.setReceiptAmount(req.getParameter("receiptAmount"));
						
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
	
	private void getVoucherDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Voucher> vouchers = soc.getVoucher();
			int size = vouchers.size();

			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Voucher");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(vouchers);
			setQueryRangeAndOrder(req, q, size);
			List<Voucher> voucher = (List<Voucher>) q.execute();

			jsonStr = getJSONString(voucher);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + vouchers.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);
	
	}

	private void processVoucherDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
	
		if (null == req.getParameter("voucherID")) {
			Voucher voucher = new Voucher();
			
			voucher.setVoucherNumber(req.getParameter("voucherNumber"));
			voucher.setVoucherDescription(req.getParameter("voucherDescription"));
			voucher.setVoucherFor(req.getParameter("voucherFor"));
			voucher.setVoucherAmount(req.getParameter("voucherAmount"));
			
			if (null != req.getParameter("voucherDate")) {
				Calendar voucherDate = new GregorianCalendar();
				try {
					voucherDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("voucherDate")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				voucher.setVoucherDate(voucherDate.getTime());
			}
			
			if (null != req.getParameter("expenseType")) {

				for (ExpenseType expenseType : getExpenseType()) {
					if (expenseType.getExpenseType().equalsIgnoreCase(
							req.getParameter("ExpenseType"))) {
						voucher.setExpenseType(expenseType);
						break;
					}
				}
			}
			
			pm.makePersistent(voucher);
			
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Voucher> vouchers = soc.getVoucher();
				if (vouchers == null) {
					vouchers = new ArrayList<Voucher>();
				}
				vouchers.add(voucher);
				soc.setVoucher(vouchers);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ voucher.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Voucher> vouchers = soc.getVoucher();
				for (Voucher voucher : vouchers) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("voucherID"));

					long voucherID = Long.parseLong(req
							.getParameter("voucherID"));
					if (voucher.getVoucherID().getId() == voucherID) {
						
						voucher.setVoucherNumber(req.getParameter("voucherNumber"));
						
						voucher.setVoucherDescription(req.getParameter("voucherDescription"));
						voucher.setVoucherFor(req.getParameter("voucherFor"));
						
						
						if (null != req.getParameter("voucherDate")) {
							Calendar voucherDate = new GregorianCalendar();
							try {
								voucherDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("voucherDate")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							voucher.setVoucherDate(voucherDate.getTime());
						}
						
						if (null != req.getParameter("expenseType")) {

							for (ExpenseType expenseType : getExpenseType()) {
								if (expenseType.getExpenseType().equalsIgnoreCase(
										req.getParameter("expenseType"))) {
									voucher.setExpenseType(expenseType);
									break;
								}
							}

						}
						
						voucher.setVoucherAmount(req.getParameter("voucherAmount"));
											
						pm.makePersistent(voucher);
						
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ voucher.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	
	}

	
	private void deleteVoucherDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Voucher> vouchers = soc.getVoucher();

			Gson gson = new Gson();
			System.out.println(req.getParameter("assetID[id]"));

			long voucherID = Long.parseLong(req.getParameter("voucherID[id]"));
			Key voucherKey = KeyFactory.createKey(Voucher.class.getSimpleName(),
					voucherID);
			Voucher voucher = pm.getObjectById(Voucher.class, voucherKey);
			
			if(vouchers != null){
				vouchers.remove(voucher);
			}
			
			Query q = pm.newQuery(Voucher.class);
			q.setFilter("voucherID == voucherIDParam");
			q.declareParameters(Key.class.getName() + " voucherIDParam");
			q.deletePersistentAll(voucherKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(voucher);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
		
	}

	private void getVoucherTypes(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		System.out.println("get vouchers called");
		
		if (null != userSessionProfile) {
			List<BillingHeadType> billingHeadTypes  = getBillingHeadType();
			jsonStr = "{\"Result\":\"OK\",\"Options\":[";
			for (BillingHeadType vouchertype : billingHeadTypes) {
				jsonStr = jsonStr + "{\"DisplayText\":\""
						+ vouchertype.getBillingHeadType() + "\",\"Value\":\""
						+ vouchertype.getBillingHeadType() + "\"},";
			}

			jsonStr = jsonStr.substring(0, jsonStr.length() - 1) + "]}";

			System.out.println(jsonStr);
			resp.getWriter().print(jsonStr);
		}
	}

	private void getExpenseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Expense> expenses = soc.getExpense();
			int size = expenses.size();
			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.Expense");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(expenses);
			setQueryRangeAndOrder(req, q, size);
			List<Expense> expense = (List<Expense>) q.execute();

			jsonStr = getJSONString(expense);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + expenses.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);
	
	}

	private void processExpenseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
	
		if (null == req.getParameter("expenseID")) {
			Expense expense = new Expense();
			
			expense.setExpenseNumber(req.getParameter("expenseNumber"));
			expense.setExpenseDescription(req.getParameter("expenseDescription"));
			expense.setExpenseFor(req.getParameter("expenseFor"));
			expense.setExpenseAmount(req.getParameter("expenseAmount"));
			expense.setTDSdeducted(req.getParameter("TDSdeducted"));
			expense.setPanDeductee(req.getParameter("panDeductee"));
			expense.setTanDeductee(req.getParameter("tanDeductee"));
			
			if (null != req.getParameter("expenseDate")) {
				Calendar expenseDate = new GregorianCalendar();
				try {
					expenseDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("expenseDate")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				expense.setExpenseDate(expenseDate.getTime());
			}
			
			if (null != req.getParameter("expenseType")) {

				for (ExpenseType expenseType : getExpenseType()) {
					if (expenseType.getExpenseType().equalsIgnoreCase(
							req.getParameter("ExpenseType"))) {
						expense.setExpenseType(expenseType);
						break;
					}
				}
			}
			
						
			pm.makePersistent(expense);
			
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Expense> expenses = soc.getExpense();
				if (expenses == null) {
					expenses = new ArrayList<Expense>();
				}
				expenses.add(expense);
				soc.setExpense(expenses);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ expense.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<Expense> expenses = soc.getExpense();
				for (Expense expense : expenses) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("expenseID"));

					long expenseID = Long.parseLong(req
							.getParameter("expenseID"));
					if (expense.getExpenseID().getId() == expenseID) {
						
						expense.setExpenseNumber(req.getParameter("expenseNumber"));
						
						expense.setExpenseDescription(req.getParameter("expenseDescription"));
						expense.setExpenseFor(req.getParameter("expenseFor"));
						expense.setTDSdeducted(req.getParameter("TDSdeducted"));
						expense.setPanDeductee(req.getParameter("panDeductee"));
						expense.setTanDeductee(req.getParameter("tanDeductee"));
						expense.setExpenseAmount(req.getParameter("expenseAmount"));
						
						if (null != req.getParameter("expenseDate")) {
							Calendar expenseDate = new GregorianCalendar();
							try {
								expenseDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("expenseDate")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							expense.setExpenseDate(expenseDate.getTime());
						}
						
						if (null != req.getParameter("expenseType")) {

							for (ExpenseType expenseType : getExpenseType()) {
								if (expenseType.getExpenseType().equalsIgnoreCase(
										req.getParameter("expenseType"))) {
									expense.setExpenseType(expenseType);
									break;
								}
							}

						}
						
						pm.makePersistent(expense);
						
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ expense.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	
	}

	
	private void deleteExpenseDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<Expense> expenses = soc.getExpense();

			Gson gson = new Gson();
			System.out.println(req.getParameter("assetID[id]"));

			long expenseID = Long.parseLong(req.getParameter("expenseID[id]"));
			Key expenseKey = KeyFactory.createKey(Expense.class.getSimpleName(),
					expenseID);
			Expense expense = pm.getObjectById(Expense.class, expenseKey);
			
			if(expenses != null){
				expenses.remove(expense);
			}
			
			Query q = pm.newQuery(Expense.class);
			q.setFilter("expenseID == expenseIDParam");
			q.declareParameters(Key.class.getName() + " expenseIDParam");
			q.deletePersistentAll(expenseKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(expense);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
		
	}
	
	private void getPurchaseOrderDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException{
		// TODO Auto-generated method stub
		
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		String jsonStr = "";
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<PurchaseOrder> purchaseOrders = soc.getPurchaseOrder();
			int size = purchaseOrders.size();

			Query q = pm
					.newQuery("select from com.viraneel.apartmentspot.entities.PurchaseOrder");
			q.addExtension("datanucleus.query.evaluateInMemory", "true");
			q.setCandidates(purchaseOrders);
			setQueryRangeAndOrder(req, q, size);
			List<PurchaseOrder> purchaseOrder = (List<PurchaseOrder>) q.execute();

			jsonStr = getJSONString(purchaseOrder);
			jsonStr = "{\"Result\":\"OK\",\"Records\":" + jsonStr
					+ ", \"TotalRecordCount\":\"" + purchaseOrders.size() + "\"}";
		}
		resp.getWriter().print(jsonStr);
	
	}

	private void processPurchaseOrderDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
	
		if (null == req.getParameter("purchaseOrderID")) {
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			
			purchaseOrder.setPurchaseOrderNumber(req.getParameter("purchaseOrderNumber"));
			purchaseOrder.setPurchaseOrderDescription(req.getParameter("purchaseOrderDescription"));
			purchaseOrder.setPurchaseOrderFor(req.getParameter("purchaseOrderFor"));
			purchaseOrder.setPurchaseOrderAmount(req.getParameter("purchaseOrderAmount"));
			
			if (null != req.getParameter("purchaseOrderDate")) {
				Calendar purchaseOrderDate = new GregorianCalendar();
				try {
					purchaseOrderDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
							.getParameter("purchaseOrderDate")));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				purchaseOrder.setPurchaseOrderDate(purchaseOrderDate.getTime());
			}
			
			if (null != req.getParameter("expenseType")) {

				for (ExpenseType expenseType : getExpenseType()) {
					if (expenseType.getExpenseType().equalsIgnoreCase(
							req.getParameter("ExpenseType"))) {
						purchaseOrder.setExpenseType(expenseType);
						break;
					}
				}
			}
			
			pm.makePersistent(purchaseOrder);
			
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<PurchaseOrder> purchaseOrders = soc.getPurchaseOrder();
				if (purchaseOrders == null) {
					purchaseOrders = new ArrayList<PurchaseOrder>();
				}
				purchaseOrders.add(purchaseOrder);
				soc.setPurchaseOrder(purchaseOrders);
				pm.makePersistent(soc);

				Society refreshedSoc = pm.getObjectById(Society.class,
						soc.getSocietyID());
				userSessionProfile.setCurrentSociety(refreshedSoc);
				req.getSession().setAttribute("userSessionProfile", userSessionProfile);
				String jsonStr = "{\"Result\":\"OK\",\"Record\":"
						+ purchaseOrder.serializedJSON() + "}";
				resp.getWriter().print(jsonStr);
			}

		} else {
			UserSessionProfile userSessionProfile = (UserSessionProfile) req
					.getSession().getAttribute("userSessionProfile");
			if (null != userSessionProfile) {
				Society soc = userSessionProfile.getCurrentSociety();
				List<PurchaseOrder> purchaseOrders = soc.getPurchaseOrder();
				for (PurchaseOrder purchaseOrder : purchaseOrders) {

					Gson gson = new Gson();
					System.out.println(req.getParameter("purchaseOrderID"));

					long purchaseOrderID = Long.parseLong(req
							.getParameter("purchaseOrderID"));
					if (purchaseOrder.getPurchaseOrderID().getId() == purchaseOrderID) {
						
						purchaseOrder.setPurchaseOrderNumber(req.getParameter("purchaseOrderNumber"));
						
						purchaseOrder.setPurchaseOrderDescription(req.getParameter("purchaseOrderDescription"));
						purchaseOrder.setPurchaseOrderFor(req.getParameter("purchaseOrderFor"));
						purchaseOrder.setPurchaseOrderAmount(req.getParameter("purchaseOrderAmount"));
						
						if (null != req.getParameter("purchaseOrderDate")) {
							Calendar purchaseOrderDate = new GregorianCalendar();
							try {
								purchaseOrderDate.setTime(new SimpleDateFormat("yyyy-dd-MM").parse(req
										.getParameter("purchaseOrderDate")));
							} catch (ParseException e) {
								e.printStackTrace();
							}
							purchaseOrder.setPurchaseOrderDate(purchaseOrderDate.getTime());
						}
						
						if (null != req.getParameter("expenseType")) {

							for (ExpenseType expenseType : getExpenseType()) {
								if (expenseType.getExpenseType().equalsIgnoreCase(
										req.getParameter("expenseType"))) {
									purchaseOrder.setExpenseType(expenseType);
									break;
								}
							}

						}
	
						pm.makePersistent(purchaseOrder);
						
						Society refreshedSoc = pm.getObjectById(Society.class,
								soc.getSocietyID());
						userSessionProfile.setCurrentSociety(refreshedSoc);
						req.getSession().setAttribute("userSessionProfile", userSessionProfile);
						String jsonStr = "{\"Result\":\"OK\",\"Record\":"
								+ purchaseOrder.serializedJSON() + "}";
						resp.getWriter().print(jsonStr);
						break;
					}
				}
			}

		}
	
	}

	
	private void deletePurchaseOrderDetails(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		UserSessionProfile userSessionProfile = (UserSessionProfile) req
				.getSession().getAttribute("userSessionProfile");
		if (null != userSessionProfile) {
			Society soc = userSessionProfile.getCurrentSociety();
			List<PurchaseOrder> purchaseOrders = soc.getPurchaseOrder();

			Gson gson = new Gson();
			System.out.println(req.getParameter("assetID[id]"));

			long purchaseOrderID = Long.parseLong(req.getParameter("purchaseOrderID[id]"));
			Key purchaseOrderKey = KeyFactory.createKey(PurchaseOrder.class.getSimpleName(),
					purchaseOrderID);
			PurchaseOrder purchaseOrder = pm.getObjectById(PurchaseOrder.class, purchaseOrderKey);
			
			if(purchaseOrders != null){
				purchaseOrders.remove(purchaseOrder);
			}
			
			Query q = pm.newQuery(PurchaseOrder.class);
			q.setFilter("purchaseOrderID == purchaseOrderIDParam");
			q.declareParameters(Key.class.getName() + " purchaseOrderIDParam");
			q.deletePersistentAll(purchaseOrderKey);
			
			pm.makePersistent(soc);
			pm.deletePersistent(purchaseOrder);
			
			System.out.println("Delete Successful");
			Society refreshedSoc = pm.getObjectById(Society.class,
					soc.getSocietyID());
			userSessionProfile.setCurrentSociety(refreshedSoc);
			req.getSession().setAttribute("userSessionProfile", userSessionProfile);
			String jsonStr = "{\"Result\":\"OK\"}";
			resp.getWriter().print(jsonStr);
		}
		
	}

}
