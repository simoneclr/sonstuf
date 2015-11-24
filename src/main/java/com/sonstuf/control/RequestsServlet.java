package com.sonstuf.control;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

		String op;
		PrintWriter writer;

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

				default:

					response.getWriter().write("Unsupported operation");
			}
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
		ObjectMapper mapper;
		boolean done;
		MiniPacket temp;

		mapper = new ObjectMapper();
		SimpleFilterProvider filters;

		filters = new SimpleFilterProvider();
		filters.addFilter("filter",
				SimpleBeanPropertyFilter.serializeAllExcept("description"));

		done = false;
		writer.write('[');

		try {

			requests = RequestModel.getAllRequests();

			for (Request request : requests) {

				if (!done) {
					done = true;
				} else {
					writer.write(',');
				}

				temp = requestToMiniPacket(request);

				if (temp != null) {

					writer.write(mapper.setFilterProvider(filters)
							.writeValueAsString(temp));
				}
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
		ObjectMapper mapper;
		SimpleFilterProvider filters;

		requestId = request.getParameter("idRequest");

		if (requestId == null || requestId.length() == 0) {

			writer.write("Invalid operation: the requestId parameter should be specified");
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

			mapper = new ObjectMapper();
			filters = new SimpleFilterProvider();

			filters.addFilter("filter",
					SimpleBeanPropertyFilter.serializeAll());

			if (r != null) {
				writer.write(mapper.setFilterProvider(filters)
						.writeValueAsString(requestToMiniPacket(r)));
			} else {
				writer.write("Invalid request: item not found");
			}

		} catch (SQLException | NamingException | JsonProcessingException e) {

			writer.write("Backend error");
			e.printStackTrace();
			return;
		}
	}

	private MiniUser userToMiniUser(User user) {

		MiniUser res;

		res = new MiniUser();

		res.name = user.getName();
		res.rankR = user.getRankP();

		return res;
	}

	public MiniPacket requestToMiniPacket(Request request) {

		MiniPacket res;

		try {

			res = new MiniPacket();

			res.idRequest = request.getIdRequest();
			res.user = userToMiniUser(
					UserModel.getUserById(request.getIdUser()));
			res.request = new MiniRequest();
			res.request.category = CategoryModel
					.getCategoryById(request.getIdCategory()).getName();
			res.request.place = request.getPlace();
			res.request.time = request.getDateTime();
			res.request.postTimestamp = request.getPostTime().toString();
			res.request.description = request.getDescription();

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
			res = null;
		}

		return res;
	}

	private class MiniPacket {

		private int idRequest;
		private MiniUser user;
		private MiniRequest request;

		/**
		 * @return the idRequest
		 */
		public int getIdRequest() {
			return idRequest;
		}

		/**
		 * @param idRequest the idRequest to set
		 */
		public void setIdRequest(int idRequest) {
			this.idRequest = idRequest;
		}

		/**
		 * @return the user
		 */
		public MiniUser getUser() {
			return user;
		}

		/**
		 * @param user the user to set
		 */
		public void setUser(MiniUser user) {
			this.user = user;
		}

		/**
		 * @return the request
		 */
		public MiniRequest getRequest() {
			return request;
		}

		/**
		 * @param request the request to set
		 */
		public void setRequest(MiniRequest request) {
			this.request = request;
		}
	}

	private class MiniUser {

		private String name = "ciao";
		private double rankR = 5.4;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the rankR
		 */
		public double getRankR() {
			return rankR;
		}

		/**
		 * @param rankR the rankR to set
		 */
		public void setRankR(double rankR) {
			this.rankR = rankR;
		}
	}

	@JsonFilter("filter")
	private class MiniRequest {

		private String category;
		private String place;
		private String time;
		private String postTimestamp;
		private String description;

		/**
		 * @return the category
		 */
		public String getCategory() {
			return category;
		}

		/**
		 * @param category the category to set
		 */
		public void setCategory(String category) {
			this.category = category;
		}

		/**
		 * @return the place
		 */
		public String getPlace() {
			return place;
		}

		/**
		 * @param place the place to set
		 */
		public void setPlace(String place) {
			this.place = place;
		}

		/**
		 * @return the time
		 */
		public String getTime() {
			return time;
		}

		/**
		 * @param time the time to set
		 */
		public void setTime(String time) {
			this.time = time;
		}

		/**
		 * @return the postTimestamp
		 */
		public String getPostTimestamp() {
			return postTimestamp;
		}

		/**
		 * @param postTimestamp the postTimestamp to set
		 */
		public void setPostTimestamp(String postTimestamp) {
			this.postTimestamp = postTimestamp;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
