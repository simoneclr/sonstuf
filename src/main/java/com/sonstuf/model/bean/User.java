package com.sonstuf.model.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe che rappresenta la tabella utente del db
 *
 * @author enrico.t
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idUser = -1;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private String passwordHash;
	private float rankO = -1;
	private float rankP = -1;
	private Date birthDate;
	private boolean admin;

	/**
	 * checks if user and this are the same User ignoring null fields
	 * @param user
	 * @return false if user is null. true if all the not null fields in both user and this are equals.
	 */
	public boolean equalsIgnoringNullFields(User user) {
		System.out.println("21user.getSurname()"+user.getSurname()+"-");
		if(user == null) return false;
		/*if(this.hashCode() != user.hashCode()) {
			System.out.println("26");
			return false;}*/
		if (this.getIdUser() != -1 && user.getIdUser() != -1)
			if (this.getIdUser() != user.getIdUser()) {
				System.out.println("27");
				return false;}
		if ((this.getSurname() != null && user.getSurname() != null) && this.getSurname() !=""){
			System.out.println("24");

			if (!this.getSurname().equals(user.getSurname())) {
				System.out.println("25");
				return false;
			}
		}
		if ((this.getName() != null && user.getName() != null) && this.getEmail() !=""){
			System.out.println("22");
			if (!this.getName().equals(user.getName())){
				System.out.println("23");
				return false;
			}
		}
		if ((this.getBirthDate() != null && user.getBirthDate() != null))
			if (!this.getBirthDate().equals(user.getBirthDate())) {
				System.out.println("31");
				return false;}
		if ((this.getEmail() != null && user.getEmail() != null) && this.getEmail() !="")
			if (!this.getEmail().equals(user.getEmail())){
				System.out.println("32");
				return false;
			}
		if ((this.getPhone() != null && user.getPhone() != null) && this.getEmail() !="")
			if (!this.getPhone().equals(user.getPhone())) {
				System.out.println("33");
				return false;
			}
		if(this.getRankO() != -1 && user.getRankO() != -1)
			if(this.getRankO() != user.getRankO()) {
				System.out.println("33");
				return false;
			}
		if(this.getRankP() != -1 && user.getRankP() != -1)
			if(this.getRankP() != user.getRankP()) {
				System.out.println("34");
				return false;
			}
		if(this.getPasswordHash() != null && user.getPasswordHash() != null)
			if(!this.getPasswordHash().equals(user.getPasswordHash())) {
				System.out.println("35");
				return false;
			}

		return true;
	}

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

	public float getRankP() {
		return rankP;
	}

	public void setRankP(float rankP) {
		this.rankP = rankP;
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