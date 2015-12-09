package com.sonstuf.model;

import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.OfferRank;
import com.sonstuf.model.bean.RequestRank;
import com.sonstuf.utils.Retval;

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
	
	public static Retval insert ( Offer offer ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		int rs;

		String query = "INSERT INTO offer\n"
				+ "(`iduser`, `idrequest`, `posttime`)\n"
				+ "VALUES (?, ?, CURRENT_TIMESTAMP ());";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, offer.getIdUser() );
		ps.setInt( 2, offer.getIdRequest() );

		rs = ps.executeUpdate();

		Retval res;

		if( rs == 1 ) {

			res = new Retval(true);

		} else {

			res =  new Retval(false, "Could not insert offer");
		}

		ps.close();
		connection.close();

		return res;
	}

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

	public static OfferRank getRankById ( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		OfferRank res;

		String query = 	"SELECT * from offererrank\n" +
						"WHERE idoffer = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		if ( rs.next() ) {

			res = new OfferRank();
			res.setIdOffer(rs.getInt("idoffer"));
			res.setRank(rs.getInt("rank"));
			res.setComment(rs.getString("comment"));

		} else {

			res = null;

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

}
