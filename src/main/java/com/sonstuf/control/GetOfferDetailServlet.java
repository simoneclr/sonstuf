package com.sonstuf.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
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


		int idOffer = -1;
		try {
			idOffer = (int) request.getAttribute("idOffer");
		} catch (ClassCastException e) {
			response.getWriter().write("bad request attributes");
			return;
		}

		User user=null;
		ObjectMapper mapper;
		SimpleModule module;



		try {

			mapper = new ObjectMapper ();

			module = new SimpleModule ();
			module.addSerializer (User.class,
					new UserSerializer<User>());
			mapper.registerModule (module);

			response.getWriter ()
					.write (mapper.writeValueAsString ((user)));

		} catch (IOException e) {

			e.printStackTrace ();
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

