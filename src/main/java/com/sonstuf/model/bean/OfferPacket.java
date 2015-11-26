package com.sonstuf.model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * @author hypertesto
 */
public class OfferPacket {

	private int idOffer;
	private boolean isInCharge;
	private UserPacket user;
	private RequestPacket request;

	//TODO: query con join
	public static OfferPacket getOfferPacketFromOffer (Offer offer) throws SQLException, NamingException {

		OfferPacket res;

		UserPacket userPacket;
		User user;

		RequestPacket requestPacket;
		Request request;

		SimpleDateFormat sdf;

		//TODO: impostare la variabile globale
		sdf = new SimpleDateFormat("dd-MM-yyyy");

		userPacket = new UserPacket();
		user = UserModel.getUserById(offer.getIdUser());

		userPacket.setName(user.getName());
		userPacket.setRankR(user.getRankP());
		userPacket.setRankO(user.getRankO());
		requestPacket = new RequestPacket();
		request = RequestModel.getRequestById(offer.getIdRequest());

		requestPacket.setCategory(CategoryModel.getCategoryById(request.getIdCategory()).getName());
		requestPacket.setDescription(request.getDescription());
		requestPacket.setPlace(request.getPlace());
		requestPacket.setPostTimestamp(sdf.format(request.getPostTime()));
		requestPacket.setTime(request.getDateTime());
		requestPacket.setTitle (request.getTitle ());

		res = new OfferPacket();

		res.setIdOffer(offer.getIdOffer());
		res.setInCharge(offer.isInCharge());
		res.setRequest(requestPacket);
		res.setUser(userPacket);

		return  res;
	}

	public String toJSON () throws JsonProcessingException {

		ObjectMapper mapper;
		SimpleFilterProvider filters;

		mapper = new ObjectMapper();

		filters = new SimpleFilterProvider();

		filters.addFilter("requestFilter",
				SimpleBeanPropertyFilter.serializeAllExcept("description"));
		filters.addFilter("userFilter",
				SimpleBeanPropertyFilter.serializeAllExcept("rankO"));

		return mapper.setFilterProvider(filters).writeValueAsString(this);
	}

	public int getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}

	@JsonProperty("isInCharge")
	public boolean isInCharge() {
		return isInCharge;
	}

	public void setInCharge(boolean inCharge) {
		isInCharge = inCharge;
	}

	public UserPacket getUser() {
		return user;
	}

	public void setUser(UserPacket user) {
		this.user = user;
	}

	public RequestPacket getRequest() {
		return request;
	}

	public void setRequest(RequestPacket request) {
		this.request = request;
	}
}
