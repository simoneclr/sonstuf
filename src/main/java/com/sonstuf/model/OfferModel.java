package com.sonstuf.model;

import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hypertesto on 18/11/15.
 */
public class OfferModel {

	public static Offer getOfferById(int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		Offer res;


		String query = 	"SELECT * from offer\n" +
				"WHERE idoffer = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		if ( rs.next() ) {

			res = new Offer();
			res.setIdOffer( rs.getInt("idoffer"));
			res.setInCharge( rs.getBoolean("isincharge"));
			res.setIdRequest( rs.getInt("idrequest"));
			res.setIdUser( rs.getInt("iduser"));
			res.setStatus( rs.getInt("status"));
			res.setPostTime( rs.getTimestamp("posttime"));

		} else {

			res = null;

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

	public static Offer getOfferByUser ( User u ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		Offer res;


		String query = 	"SELECT * from offer\n" +
						"WHERE idoffer = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, u.getIdUser() );

		rs = ps.executeQuery();

		if ( rs.next() ) {

			res = new Offer();
			res.setIdOffer( rs.getInt("idoffer"));
			res.setInCharge( rs.getBoolean("isincharge"));
			res.setIdRequest( rs.getInt("idrequest"));
			res.setIdUser( rs.getInt("iduser"));
			res.setStatus( rs.getInt("status"));
			res.setPostTime( rs.getTimestamp("posttime"));

		} else {

			res = null;

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

}
