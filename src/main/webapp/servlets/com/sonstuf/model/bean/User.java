package com.sonstuf.model.bean;

import java.io.Serializable;

/**
 * Classe che rappresenta la tabella utente del db
 * @author alberto
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int idUtente;
    private String email;
    private String password;
    private double credito;
    private String ruolo;
    private boolean active;
    private String attivazione;

    //private Connection connection;
/*
    public User() throws NamingException, SQLException {

        connection = Connector.getConnection();
    }
*/
    /**
     * @return the idUtente
     */
    public int getIdUtente() {
        return idUtente;
    }

    /**
     * @param idUtente the idUtente to set
     */
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the credito
     */
    public double getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the attivazione
     */
    public String getAttivazione() {
        return attivazione;
    }

    /**
     * @param attivazione the attivazione to set
     */
    public void setAttivazione(String attivazione) {
        this.attivazione = attivazione;
    }

    /**
     * @return the ruolo
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * @param ruolo the ruolo to set
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}