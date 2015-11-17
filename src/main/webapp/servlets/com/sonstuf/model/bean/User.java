package com.sonstuf.model.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe che rappresenta la tabella utente del db
 * @author enrico.t
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int idUser;
    private String name;
    private String Surname;
    private String phone;
    private String email;
    private String passwordHash;
    private String rankO;
    private String rankP;
    private Date birthDate;
    private boolean admin;


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
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
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

    public String getRankO() {
        return rankO;
    }

    public void setRankO(String rankO) {
        this.rankO = rankO;
    }

    public String getRankP() {
        return rankP;
    }

    public void setRankP(String rankP) {
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
}