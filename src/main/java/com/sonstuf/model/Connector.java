package com.sonstuf.model;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Piccola classe con metodo statico di inizializzazione della
 * connessione al database tramite id ati del context.
 * 
 * @author hypertesto
 */
public class Connector {

	/**
	 * Ritorna la connessione al pool nel modo appropriato.
	 * @return Una connessione valida al db
	 * @throws NamingException
	 * @throws SQLException
	 */
	public static Connection getConnection () throws NamingException, SQLException {
		
		InitialContext initialContext;
		Context context;
		DataSource ds;
		
		initialContext = new InitialContext ();
		context = (Context) initialContext.lookup ("java:comp/env");
		
		ds = (DataSource) context.lookup ("connpool");
		return ds.getConnection ();
	}

}
