package com.viraneel.apartmentspot.http;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.viraneel.apartmentspot.valuebeans.UserSessionProfile;

@SuppressWarnings("serial")
public class ApartmentSpotHome extends BaseServlet {

	public void init() {

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		if (user != null) {
			UserSessionProfile userProfile = getUserProfile(user.getEmail());
			if (null == userProfile) {
				resp.sendRedirect("register.jsp");
			} else {
				req.getSession()
						.setAttribute("userSessionProfile", userProfile);
				resp.setContentType("text/plain");
				resp.sendRedirect("home.jsp");
			}
		} else {
			resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
		}
	}
}
