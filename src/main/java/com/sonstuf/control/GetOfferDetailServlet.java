package com.sonstuf.control;

import com.fasterxml.jackson.databind.ObjectMapper;
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

/**
 * Servlet implementation class CategoriesServlet
 */
public class GetOfferDetailServlet extends HttpServlet {
	private static class MiniPacket {

		private int idRequest;
		private User user;
		private Request request;

		public static MiniPacket ToMiniPacket(User user, Request request) {

			MiniPacket res;

			res = new MiniPacket();

			res.setIdRequest(request.getIdRequest());
			res.setUser(user);
			res.setRequest(request);

			return res;
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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOfferDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idRequest = -1;
		try {
			idRequest = (int) request.getAttribute("idRequest");
		} catch (ClassCastException e) {
			response.getWriter().write("bad request attributes");
			return;
		}

		PrintWriter writer;

		ObjectMapper mapper = new ObjectMapper();

		writer = response.getWriter();

		try {
			Request request2 = RequestModel.getRequestById(idRequest);
			User user = UserModel.getUserById(request2.getIdUser());
			writer.write(mapper.writeValueAsString(MiniPacket.ToMiniPacket(user, request2)));
		} catch (SQLException | NamingException e) {
			writer.write(e.toString());
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

