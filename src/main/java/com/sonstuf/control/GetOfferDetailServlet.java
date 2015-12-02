package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sonstuf.model.OfferModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.RequestRank;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.serializers.RequestRankSerializer;
import com.sonstuf.utils.serializers.RequestSerializer;
import com.sonstuf.utils.serializers.UserSerializer;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class CategoriesServlet
 */
public class GetOfferDetailServlet extends HttpServlet {
	private static final class MiniPacket implements JsonPacket {
		private User user;
		private Request request;
		private RequestRank requestRank;
		private int state;

		public MiniPacket(User user, Request request, RequestRank requestRank) {
			this.user = user;
			this.request = request;
			this.requestRank = requestRank;
			this.state = request.getStatus();
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
			this.state = request.getStatus();
		}

		public RequestRank getRequestRank() {
			return requestRank;
		}

		public void setRequestRank(RequestRank requestRank) {
			this.requestRank = requestRank;
		}


		@Override
		public String toJSON() throws JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
			SimpleModule module = new SimpleModule();

			module.addSerializer(Request.class, new RequestSerializer<>());
			module.addSerializer(User.class, new UserSerializer<>("idUser", "name", "rankO"));
			module.addSerializer(RequestRank.class, new RequestRankSerializer<>("rank", "comment"));
			mapper.registerModule(module);

			return mapper.writeValueAsString(this);
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
	protected void doGet(HttpServletRequest requestHttp, HttpServletResponse response) throws ServletException, IOException {
		//get the offer with the given id.
		int idOffer;
		try {
			idOffer = Integer.parseInt(requestHttp.getParameter("idOffer"));
		} catch (ClassCastException | NumberFormatException |NullPointerException e) {
			response.getWriter().write("bad request attributes: " + e);
			e.printStackTrace();
			return;
		}

		//get the Offer from the OfferId.
		Offer offer;
		try {
			offer = OfferModel.getOfferById(idOffer);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the offer from the database: " + e);
			return;
		}

		//get the request associated with the offer.
		Request request;
		try {
			request = RequestModel.getRequestById(offer.getIdRequest());
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the request from the database: " + e);
			return;
		}

		//get the rank given to the request.
		RequestRank requestRank = null;
		if (request.getStatus() == 2) {
			try {
				requestRank = RequestModel.getRankById(request.getIdRequest());
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.getWriter().write("can not retrieve the requestRank from the database: " + e);
				return;
			}
		}
		//get the User that made the request.
		User requestingUser;
		try {
			requestingUser = UserModel.getUserById(request.getIdUser());
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the requestingUser from the database: " + e);
			return;
		}

		String json = new MiniPacket(requestingUser, request, requestRank).toJSON();
		System.out.println("json: " + json);
		response.getWriter().write(json);
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

