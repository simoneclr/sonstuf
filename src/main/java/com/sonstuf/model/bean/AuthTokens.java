package com.sonstuf.model.bean;

/**
 * Created by hypertesto on 18/11/15.
 */
public class AuthTokens {

	private int authTokenId;
	private String hash;
	private int idUser;

	public int getAuthTokenId() {
		return authTokenId;
	}

	public void setAuthTokenId(int authTokenId) {
		this.authTokenId = authTokenId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
