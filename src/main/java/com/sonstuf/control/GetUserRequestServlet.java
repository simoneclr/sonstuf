package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.Logger;
import com.sonstuf.utils.serializers.RequestSerializer;
import com.sonstuf.utils.serializers.UserSerializer;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class CategoriesServlet
 */
public class GetUserRequestServlet extends HttpServlet {
	private static class MiniPacket implements JsonPacket {

		private User user;
		private Request request;

		MiniPacket(User user, Request request) {
			this.request = request;
			this.user = user;
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

		@Override
		public String toJSON() throws JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
			SimpleModule module = new SimpleModule();

			module.addSerializer(Request.class, new RequestSerializer<>("title", "description", "place", "time", "photo"));
			module.addSerializer(User.class, new UserSerializer<>("name", "rankO"));
			mapper.registerModule(module);

			return mapper.writeValueAsString(this);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserRequestServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idRequest;
		try {
			idRequest = Integer.parseInt(request.getParameter("idRequest"));
		} catch (ClassCastException | NumberFormatException | NullPointerException e) {
			response.getWriter().write("bad request attributes");
			e.printStackTrace();
			return;
		}

		PrintWriter writer;


		writer = response.getWriter();

		try {
			Request request2 = RequestModel.getRequestById(idRequest);

			User user = UserModel.getUserById(request2.getIdUser());

			MiniPacket packet = new MiniPacket(user, request2);
			String json = packet.toJSON();
			Logger.debug("json:" + json);
			writer.write(json);
		} catch (SQLException | NamingException e) {
			writer.write(e.toString());
			e.printStackTrace();
			return;
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
}

