package com.sonstuf.model;

import com.sonstuf.model.bean.Category;
import com.sonstuf.model.bean.Request;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
