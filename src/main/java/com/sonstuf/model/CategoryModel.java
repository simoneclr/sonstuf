package com.sonstuf.model;

import com.sonstuf.model.bean.Category;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hypertesto on 18/11/15.
 */
public class CategoryModel {

	public static Category getCategoryById( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		Category res;


		String query = 	"SELECT * from category\n" +
						"WHERE idcategory = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt( 1, id );

		rs = ps.executeQuery();

		if ( rs.next() ) {

			res = new Category();
			res.setIdCategory( rs.getInt("idcategory") );
			res.setName( rs.getString("name") );
			res.setDescription( rs.getString("description") );

		} else {

			res = null;

		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

}
