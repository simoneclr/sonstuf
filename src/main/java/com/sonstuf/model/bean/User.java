package com.sonstuf.model.bean;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe che rappresenta la tabella utente del db
 *
 * @author enrico.t
 */

@JsonFilter ("userFilter")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idUser;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String passwordHash;
	private float rankO;
	private float rankR;
	private Date birthDate;
	private boolean admin;
	/**
	 * checks if user and this are the same User ignoring null fields
	 * @param user
	 * @return false if user is null. true if all the not null fields in both user and this are equals.
	 */

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@JsonProperty ("telephone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public float getRankO() {
		return rankO;
	}

	public void setRankO(float rankO) {
		this.rankO = rankO;
	}

	public float getRankR() {
		return rankR;
	}

	public void setRankR(float rankP) {
		this.rankR = rankP;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}