package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.OfferModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.Retval;
import com.sonstuf.utils.serializers.RequestSerializer;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class RequestsServlet
 */
public class RequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String op;
		PrintWriter writer;
		ObjectMapper mapper;

		writer = response.getWriter();
		op = request.getParameter("op");

		if (op != null) {

			switch (op) {

				case "listAll":

					listAllRequests(writer);
					break;

				case "view":

					viewRequest(request, writer);
					break;

				case "insert":

					mapper = new ObjectMapper();
					writer.write(mapper
							.writeValueAsString(insertRequest(request)));
					break;

				case "register":

					mapper = new ObjectMapper();
					writer.write(mapper
							.writeValueAsString(registerForRequest(request)));

					break;

				default:

					response.getWriter().write("Unsupported operation");
			}
		} else {

			response.getWriter().write("Missing op parameter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private void listAllRequests(PrintWriter writer) {

		List<Request> requests;
		boolean comma;

		comma = false;
		writer.write('[');

		try {

			requests = RequestModel.getAllRequests();

			for (Request request : requests) {

				if (!comma) {
					comma = true;
				} else {
					writer.write(',');
				}

				writer.write(new PacketNoDescription(request).toJSON());
			}

		} catch (SQLException | NamingException | JsonProcessingException e) {

			e.printStackTrace();
		}

		writer.write(']');
	}

	private void viewRequest(HttpServletRequest request, PrintWriter writer) {

		String requestId;
		int parsedId;
		Request r;

		requestId = request.getParameter("idRequest");

		if (requestId == null || requestId.length() == 0) {

			writer.write("Invalid operation: the idRequest parameter should be specified");
			return;
		}

		try {

			parsedId = Integer.parseInt(requestId);

		} catch (NumberFormatException e) {

			writer.write("Invalid parameter: the requestId parameter should be a valid integer");
			return;
		}

		try {

			r = RequestModel.getRequestById(parsedId);

			if (r != null) {
				writer.write(new Packet(r).toJSON());
			} else {
				writer.write("Invalid request: item not found");
			}

		} catch (SQLException | NamingException | JsonProcessingException e) {

			writer.write("Backend error");
			e.printStackTrace();
			return;
		}
	}

	private User getUserFromSession(HttpSession session) {

		if (session != null) {

			return (User) session.getAttribute("user");
		}

		return null;
	}

	private Retval insertRequest(HttpServletRequest request) {

		String title, description, place, category, time, assignedUser;
		int categoryId;
		Request newRequest;
		User user;

		user = getUserFromSession(request.getSession());

		if (user == null)
			return new Retval(false, "Login nedded");

		title = request.getParameter("title");
		description = request.getParameter("description");
		place = request.getParameter("place");
		category = request.getParameter("categoryId");
		time = request.getParameter("time");

		if (title == null)
			return new Retval(false, "Missing \"title\" parameter");

		if (title.equals(""))
			return new Retval(false, "Missing \"title\" parameter");

		if (description == null)
			return new Retval(false, "Missing \"description\" parameter");

		if (description.equals(""))
			return new Retval(false, "Missing \"description\" parameter");

		if (place == null)
			return new Retval(false, "Missing \"place\" parameter");

		if (place.equals(""))
			return new Retval(false, "Missing \"place\" parameter");

		if (category == null)
			return new Retval(false, "Missing \"categoryId\" parameter");

		if (time == null)
			return new Retval(false, "Missing \"time\" parameter");

		if (time.equals(""))
			return new Retval(false, "Missing \"time\" parameter");

		try {

			categoryId = Integer.parseInt(category);

		} catch (NumberFormatException e) {

			return new Retval(false, "Invalid categoryId integer");
		}

		try {
			if (CategoryModel.getCategoryById(categoryId) == null)
				return new Retval(false, "Invalid categoryId: category not found");
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return new Retval(false, "Backend error: " + e.getMessage());
		}

		newRequest = new Request();

		newRequest.setDescription(description);
		newRequest.setTitle(title);
		newRequest.setPlace(place);
		newRequest.setIdCategory(categoryId);
		newRequest.setDateTime(time);

		if (user.isAdmin()) {

			int assigneUserId;

			assignedUser = request.getParameter("user");

			if (assignedUser == null || assignedUser.equals("")
					|| assignedUser.equals("null")) {
				/*
				 * Admin inserted a request without specifing a user, so we
				 * insert it with his account
				 */

				newRequest.setIdUser(user.getIdUser());

			} else {

				try {
					assigneUserId = Integer.parseInt(assignedUser);
				} catch (NumberFormatException e) {

					return new Retval(false, "Invalid user field");
				}

				newRequest.setIdUser(assigneUserId);
			}

		} else {
			newRequest.setIdUser(user.getIdUser());
		}

		try {
			RequestModel.insert(newRequest);
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return new Retval(false, "Backend error: " + e.getMessage());
		}

		return new Retval(true);
	}

	private Retval registerForRequest(HttpServletRequest servletRequest) {

		String request;
		int idRequest;
		Offer newOffer;
		User user;

		user = getUserFromSession(servletRequest.getSession());

		if (user == null)
			return new Retval(false, "Login required");

		request = servletRequest.getParameter("requestId");

		if (request == null)
			return new Retval(false, "Missing parameter \"requestId\"");

		try {

			idRequest = Integer.parseInt(request);

		} catch (NumberFormatException e) {

			return new Retval(false, "Invalid parameter \"requestId\"");
		}

		try {

			if (RequestModel.getRequestById(idRequest) == null) {

				return new Retval(false, "Ivalid parameter \"requestId\": request not found");
			}

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return new Retval(false, "Backend error: " + e.getMessage());
		}

		newOffer = new Offer();

		newOffer.setIdRequest(idRequest);
		newOffer.setIdUser(user.getIdUser());
		newOffer.setInCharge(false);
		//newOffer.setStatus (0); //Unuseful, by default is 0

		try {
			OfferModel.insert(newOffer);
		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			return new Retval(false, "Backend error: " + e.getMessage());
		}

		return new Retval(true);
	}

	private class Packet implements JsonPacket {

		private int idRequest;
		private User user;
		private Request request;

		public Packet(Request request)
				throws SQLException, NamingException {

			this.idRequest = request.getIdRequest();
			this.user = UserModel.getUserById(request.getIdUser());
			this.request = request;
		}

		@Override
		public String toJSON() throws JsonProcessingException {

			ObjectMapper mapper;
			SimpleFilterProvider filters;
			SimpleModule module;

			mapper = new ObjectMapper();
			filters = new SimpleFilterProvider();

			module = new SimpleModule();
			module.addSerializer(Request.class,
					new RequestSerializer<>("title", "description", "place", "time", "postTimeStamp", "category"));
			mapper.registerModule(module);

			filters.addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept(
							"name",
							"rankR"
					));

			return mapper.setFilterProvider(filters).writeValueAsString(this);
		}

		public int getIdRequest() {
			return idRequest;
		}

		public void setIdRequest(int idRequest) {
			this.idRequest = idRequest;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Request getRequest() {
			return request;
		}

		public void setRequest(Request request) {
			this.request = request;
		}
	}

	private class PacketNoDescription extends Packet {

		public PacketNoDescription(Request request)
				throws SQLException, NamingException {
			super(request);
		}

		@Override
		public String toJSON() throws JsonProcessingException {

			ObjectMapper mapper;
			SimpleFilterProvider filters;
			SimpleModule module;

			mapper = new ObjectMapper();
			filters = new SimpleFilterProvider();

			module = new SimpleModule();
			module.addSerializer(Request.class,
					new RequestSerializer<>("title", "place", "time", "postTimeStamp", "category"));
			mapper.registerModule(module);

			filters.addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept(
							"name",
							"rankR"
					));

			return mapper.setFilterProvider(filters).writeValueAsString(this);
		}
	}
}
