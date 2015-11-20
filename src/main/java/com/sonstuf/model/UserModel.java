/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonstuf.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.PasswordHash;
import com.sonstuf.utils.Retval;

/**
 *
 * @author hypertesto
 */
public class UserModel {

	/**
	 * Inserts a user into the db if not already in.
	 * @return Retval true if ok, else false + error description.
	 * @throws SQLException
	 * @throws NamingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static Retval insert(User user) throws SQLException, NamingException, NoSuchAlgorithmException, InvalidKeySpecException {


		Connection connection;
		PreparedStatement ps;
		ResultSet rs;

		String check = "SELECT COUNT(*) AS count FROM user WHERE email = ?";

		String query = "INSERT INTO user\n"
				+ "(`name`, `surname`, `phone`, `email`, `passwordhash`, `ranko`, `rankp`, `birthdate`, `admin`)\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(check);
		ps.setString (1, user.getEmail ());
		rs = ps.executeQuery();

		if ( rs.next() ) {
			if( rs.getInt("count") > 0 ){
				rs.close();
				ps.close();
				connection.close();
				return new Retval(false, "ERROR: user already exists!");
			}
		} else {
			rs.close();
			ps.close();
			connection.close();
			return new Retval(false, "ERROR: something went wrong!");
		}

		ps = connection.prepareStatement(query);

		ps.setString(1, user.getName ());
		ps.setString(2, user.getSurname ());
		ps.setString(3, user.getPhone ());
		ps.setString(4, user.getEmail ());
		ps.setString(5, user.getPasswordHash ());
		ps.setFloat (6, user.getRankO ());
		ps.setFloat (7, user.getRankP ());
		ps.setDate (8, user.getBirthDate ());
		ps.setBoolean (9, user.isAdmin ());

		int res = ps.executeUpdate();
		if (res == 0){ //no rows affected, error
			ps.close();
			connection.close();
			return new Retval (false, "Error creating user");
		}
		ps.close();
		connection.close();
		return new Retval(true, "User created correctly");

	}


	/**
	 * todo
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public static User getUserByMail ( String email) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		User res;


		String query = 	"SELECT * from user\n" +
						"WHERE email = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setString ( 1, email );

		rs = ps.executeQuery();

		if (rs.next()) {

			res = new User();

			res.setIdUser(rs.getInt("iduser"));
			res.setName(rs.getString("name"));
			res.setSurname(rs.getString("surname"));
			res.setPhone(rs.getString("phone"));
			res.setPasswordHash(rs.getString("passwordhash"));
			res.setRankO(rs.getFloat("ranko"));
			res.setRankP(rs.getFloat("rankp"));
			res.setBirthDate(rs.getDate("birthdate"));
			res.setAdmin(rs.getBoolean("admin"));


		} else {

			res = null;
		}

		rs.close();
		ps.close();
		connection.close();

		return res;
	}

	/**
	 * todo
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public static User getUserByPhone ( String phone) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		User res;


		String query = 	"SELECT * from user\n" +
						"WHERE phone = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setString ( 1, phone );

		rs = ps.executeQuery();

		if (rs.next()) {

			res = new User();

			res.setIdUser(rs.getInt("iduser"));
			res.setName(rs.getString("name"));
			res.setSurname(rs.getString("surname"));
			res.setPhone(rs.getString("phone"));
			res.setPasswordHash(rs.getString("passwordhash"));
			res.setRankO(rs.getFloat("ranko"));
			res.setRankP(rs.getFloat("rankp"));
			res.setBirthDate(rs.getDate("birthdate"));
			res.setAdmin(rs.getBoolean("admin"));


		} else {

			res = null;
		}

		rs.close();
		ps.close();
		connection.close();

		return res;
	}

	public static User getUserById ( int id ) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		User res;

		String query = 	"SELECT * from user\n" +
						"WHERE iduser = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt ( 1, id );

		rs = ps.executeQuery();

		if (rs.next()) {

			res = new User();

			res.setIdUser(rs.getInt("iduser"));
			res.setName(rs.getString("name"));
			res.setSurname(rs.getString("surname"));
			res.setPhone(rs.getString("phone"));
			res.setPasswordHash(rs.getString("passwordhash"));
			res.setRankO(rs.getFloat("ranko"));
			res.setRankP(rs.getFloat("rankp"));
			res.setBirthDate(rs.getDate("birthdate"));
			res.setAdmin(rs.getBoolean("admin"));


		} else {

			res = null;
		}

		rs.close();
		ps.close();
		connection.close();

		return res;

	}

	/**
	 * todo
	 * @param password
	 * @param user
	 * @return, NamingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static boolean checkPassword(String password, User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return PasswordHash.validatePassword(password, user.getPasswordHash());
	}

}
