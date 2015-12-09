package com.sonstuf.control;

import com.sonstuf.model.OfferModel;
import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.Logger;
import com.sonstuf.utils.Retval;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AcceptRequestServlet extends HttpServlet {
	private static final String OK_RESPONSE = "success";
	private static final String ERROR_RESPONSE = "fail";
	private static final String USER_NOT_LOGGED_RESPONSE = "not_logged";


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idRequest;
		try {
			idRequest = Integer.parseInt(request.getParameter("idRequest"));
		} catch (ClassCastException | NumberFormatException | NullPointerException e) {
			response.getWriter().write(ERROR_RESPONSE);
			e.printStackTrace();
			return;
		}
		User offeringUser;
		try {
			offeringUser = (User) request.getSession().getAttribute("user");
		} catch (ClassCastException | NullPointerException e) {
			response.getWriter().write(USER_NOT_LOGGED_RESPONSE);
			e.printStackTrace();
			return;
		}

		Offer newOffer = new Offer();
		newOffer.setIdRequest(idRequest);
		newOffer.setIdUser(offeringUser.getIdUser());
		Retval retVal;
		try {
			retVal = OfferModel.insert(newOffer);
		} catch (SQLException | NamingException e) {
			response.getWriter().write(ERROR_RESPONSE);
			e.printStackTrace();
			return;
		}
		if (!retVal.getSuccess()) {
			response.getWriter().write(ERROR_RESPONSE);
			Logger.log("insertion of a offert in the database returned false");
			return;
		}
		response.getWriter().write(OK_RESPONSE);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
