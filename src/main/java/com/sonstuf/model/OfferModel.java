package com.sonstuf.model;

import com.sonstuf.model.bean.Offer;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Offer> getOffersByUserId ( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		List<Offer> res;

		String query = 	"SELECT * from offer\n" +
						"WHERE iduser = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		res = new ArrayList<Offer>();

		while ( rs.next() ) {

			Offer o = new Offer();
			o.setIdOffer( rs.getInt("idoffer"));
			o.setInCharge( rs.getBoolean("isincharge"));
			o.setIdRequest( rs.getInt("idrequest"));
			o.setIdUser( rs.getInt("iduser"));
			o.setStatus( rs.getInt("status"));
			o.setPostTime( rs.getTimestamp("posttime"));

			res.add(o);

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

	public static List<Offer> getAllOffers () throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Offer> res;

		String query = 	"SELECT * from offer;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);

		rs = ps.executeQuery();

		res = new ArrayList<Offer>();

		while ( rs.next() ) {

			Offer o = new Offer();

			o.setIdOffer( rs.getInt("idoffer"));
			o.setInCharge( rs.getBoolean("isincharge"));
			o.setIdRequest( rs.getInt("idrequest"));
			o.setIdUser( rs.getInt("iduser"));
			o.setStatus( rs.getInt("status"));
			o.setPostTime( rs.getTimestamp("posttime"));

			res.add(o);

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

}
