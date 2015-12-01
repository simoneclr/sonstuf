package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sonstuf.model.OfferModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.RequestRank;
import com.sonstuf.model.bean.User;
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
	private static final class MiniPacket extends JsonSerializer<MiniPacket> {
		private User user;
		private Request request;
		private RequestRank requestRank;

		public static MiniPacket ToMiniPacket(User user, Request request, RequestRank requestRank) {
			MiniPacket res;
			res = new MiniPacket();
			res.setUser(user);
			res.setRequest(request);
			res.setRequestRank(requestRank);
			return res;
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

		public RequestRank getRequestRank() {
			return requestRank;
		}

		public void setRequestRank(RequestRank requestRank) {
			this.requestRank = requestRank;
		}

		@Override
		public void serialize(MiniPacket o, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
			jsonGenerator.writeStartObject();

			//serialize User
			{
				ObjectMapper mapper = new ObjectMapper();
				SimpleModule module = new SimpleModule();
				module.addSerializer(User.class, new UserSerializer<>("idUser", "name", "rankO"));
				mapper.registerModule(module);
				jsonGenerator.writeStringField("requestingUser", mapper.writeValueAsString(this.user));
			}

			//serialize Request
			{
				ObjectMapper mapper = new ObjectMapper();
				SimpleModule module = new SimpleModule();
				module.addSerializer(Request.class, new RequestSerializer<>());
				mapper.registerModule(module);
				jsonGenerator.writeStringField("request", mapper.writeValueAsString(this.request));
			}

			//serialize RequestRank if present
			if (this.requestRank != null) {
				ObjectMapper mapper = new ObjectMapper();
				SimpleModule module = new SimpleModule();
				module.addSerializer(RequestRank.class, new RequestRankSerializer<>("rank", "comment"));
				mapper.registerModule(module);
				jsonGenerator.writeStringField("valuation", mapper.writeValueAsString(this.requestRank));
			}

			//serialize state
			{
				jsonGenerator.writeNumberField("state", this.request.getStatus());
			}

			jsonGenerator.writeEndObject();
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
			idOffer = (int) requestHttp.getAttribute("idOffer");
		} catch (ClassCastException e) {
			response.getWriter().write("bad request attributes");
			return;
		}

		//get the Offer from the OfferId.
		Offer offer;
		try {
			offer = OfferModel.getOfferById(idOffer);
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the offer from the database");
			return;
		}

		//get the request associated with the offer.
		Request request;
		try {
			request = RequestModel.getRequestById(offer.getIdRequest());
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the request from the database");
			return;
		}

		//get the rank given to the request.
		RequestRank requestRank = null;
		if (request.getStatus() == 2) {
			try {
				requestRank = RequestModel.getRankById(request.getIdRequest());
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.getWriter().write("can not retrieve the requestRank from the database");
				return;
			}
		}
		//get the User that made the request.
		User requestingUser = null;
		try {
			UserModel.getUserById(request.getIdUser());
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
			response.getWriter().write("can not retrieve the requestingUser from the database");
			return;
		}

		MiniPacket outputObject = MiniPacket.ToMiniPacket(requestingUser, request, requestRank);

		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addSerializer(MiniPacket.class, new MiniPacket());
		mapper.registerModule(module);

		String json = mapper.writeValueAsString(outputObject);
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

