package com.sonstuf.model.bean;

import java.sql.Timestamp;

/**
 * Created by hypertesto on 18/11/15.
 */
public class Offer {

	private int idOffer;
	private boolean isInCharge;
	private int idRequest;
	private int idUser;
	private int status;
	private Timestamp postTime;

	public int getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}

	public boolean isInCharge() {
		return isInCharge;
	}

	public void setInCharge(boolean inCharge) {
		isInCharge = inCharge;
	}

	public int getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
}
