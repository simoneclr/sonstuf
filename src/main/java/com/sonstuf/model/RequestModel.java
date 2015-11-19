package com.sonstuf.model;

import com.sonstuf.model.bean.Category;
import com.sonstuf.model.bean.Request;

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
public class RequestModel {

	public static Request getRequestById ( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		Request res;


		String query = 	"SELECT * from request\n" +
				"WHERE idrequest = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		if ( rs.next() ) {

			res = new Request();
			res.setIdRequest( rs.getInt("idrequest") );
			res.setTitle( rs.getString("title"));
			res.setDescription( rs.getString("description"));
			res.setPlace( rs.getString("place"));
			res.setDateTime( rs.getString("datetime"));
			res.setPhoto( rs.getString("photo"));
			res.setIdUser( rs.getInt("iduser"));
			res.setIdCategory( rs.getInt("idcategory"));
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
	
	public static List<Request> getRequestsByUserId ( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Request> res;


		String query = 	"SELECT * from request\n" +
						"WHERE iduser = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		res = new ArrayList<Request>();

		while ( rs.next() ) {
			
			Request r = new Request();
			r = new Request();
			r.setIdRequest( rs.getInt("idrequest") );
			r.setTitle( rs.getString("title"));
			r.setDescription( rs.getString("description"));
			r.setPlace( rs.getString("place"));
			r.setDateTime( rs.getString("datetime"));
			r.setPhoto( rs.getString("photo"));
			r.setIdUser( rs.getInt("iduser"));
			r.setIdCategory( rs.getInt("idcategory"));
			r.setStatus( rs.getInt("status"));
			r.setPostTime( rs.getTimestamp("posttime"));

			res.add(r);

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

	public static List<Request> getAllRequests () throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		ArrayList<Request> res;

		String query = 	"SELECT * from request;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);

		rs = ps.executeQuery();

		res = new ArrayList<Request>();

		while ( rs.next() ) {

			Request r = new Request();
			r = new Request();
			r.setIdRequest( rs.getInt("idrequest") );
			r.setTitle( rs.getString("title"));
			r.setDescription( rs.getString("description"));
			r.setPlace( rs.getString("place"));
			r.setDateTime( rs.getString("datetime"));
			r.setPhoto( rs.getString("photo"));
			r.setIdUser( rs.getInt("iduser"));
			r.setIdCategory( rs.getInt("idcategory"));
			r.setStatus( rs.getInt("status"));
			r.setPostTime( rs.getTimestamp("posttime"));

			res.add(r);

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

}
