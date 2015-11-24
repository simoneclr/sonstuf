/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sonstuf.model;

import com.sonstuf.model.bean.User;
import com.sonstuf.utils.PasswordHash;
import com.sonstuf.utils.Retval;

import javax.naming.NamingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hypertesto
 */
public class UserModel {

	private static List<User> executeQuery(PreparedStatement prepStatement) throws SQLException {
		
		ResultSet rs = prepStatement.executeQuery();
		List<User> res = new ArrayList<>();

		try {

			while (rs.next()) {

				User user = new User();

				user.setIdUser(rs.getInt("iduser"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setPhone(rs.getString("phone"));
				user.setPasswordHash(rs.getString("passwordhash"));
				user.setRankO(rs.getFloat("ranko"));
				user.setRankP(rs.getFloat("rankp"));
				user.setBirthDate(rs.getDate("birthdate"));
				user.setAdmin(rs.getBoolean("admin"));

				res.add(user);
			}

		} finally {

			rs.close();
			prepStatement.close();

		}

		return res;
	}

	/**
	 * Inserts a user into the db if not already in.
	 *
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
		ps.setString(1, user.getEmail());
		rs = ps.executeQuery();

		if (rs.next()) {
			if (rs.getInt("count") > 0) {
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

		ps.setString(1, user.getName());
		ps.setString(2, user.getSurname());
		ps.setString(3, user.getPhone());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPasswordHash());
		ps.setFloat(6, user.getRankO());
		ps.setFloat(7, user.getRankP());
		ps.setDate(8, user.getBirthDate());
		ps.setBoolean(9, user.isAdmin());

		int res = ps.executeUpdate();
		if (res == 0) { //no rows affected, error
			ps.close();
			connection.close();
			return new Retval(false, "Error creating user");
		}
		ps.close();
		connection.close();
		return new Retval(true, "User created correctly");

	}


	/**
	 * todo
	 *
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public static User getUserByMail(String email) throws SQLException, NamingException {
		Connection connection;

		String query = "SELECT * from user\n" +
				"WHERE email = ? ;";

		connection = Connector.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);

		List<User> userList = executeQuery(preparedStatement);
		connection.close();
		if (userList.size() > 0)
			return userList.get(0);
		else //if it's empty
			return null;
	}

	/**
	 * todo
	 *
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public static User getUserByPhone(String phone) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;

		String query = "SELECT * from user\n" +
				"WHERE phone = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setString(1, phone);

		List<User> userList = executeQuery(ps);

		connection.close();
		if (userList.size() > 0)
			return userList.get(0);
		else //if it's empty
			return null;
	}

	public static User getUserById(int id) throws SQLException, NamingException {

		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		User res;

		String query = "SELECT * from user\n" +
				"WHERE iduser = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setInt(1, id);

		List<User> userList = executeQuery(ps);

		connection.close();
		if (userList.size() > 0)
			return userList.get(0);
		else //if it's empty
			return null;
	}

	public static List<User> getUserByName(String name) throws SQLException, NamingException {
		Connection connection;
		PreparedStatement ps;

		String query = "SELECT * from user\n" +
				"WHERE name = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setString(1, name);

		List<User> userList = executeQuery(ps);

		connection.close();

		return userList;
	}

	public static List<User> getUserBySurname(String surname) throws SQLException, NamingException {
		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		List<User> res = new ArrayList<>();

		String query = "SELECT * from user\n" +
				"WHERE surname = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setString(1, surname);

		List<User> userList = executeQuery(ps);

		connection.close();

		return userList;
	}

	public static List<User> getUserByBirthdate(Date birthdate) throws SQLException, NamingException {
		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		List<User> res = new ArrayList<>();

		String query = "SELECT * from user\n" +
				"WHERE birthdate = ? ;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);
		ps.setDate(1, birthdate);

		List<User> userList = executeQuery(ps);

		connection.close();

		return userList;
	}

	public static List<User> getAllUsers() throws SQLException, NamingException {
		Connection connection;
		PreparedStatement ps;
		ResultSet rs;
		List<User> res = new ArrayList<>();

		String query = "SELECT * from user;";

		connection = Connector.getConnection();

		ps = connection.prepareStatement(query);

		List<User> userList = executeQuery(ps);

		connection.close();

		return userList;
	}


	/**
	 * todo
	 *
	 * @param password
	 * @param user
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @return, NamingException
	 */
	public static boolean checkPassword(String password, User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
		return PasswordHash.validatePassword(password, user.getPasswordHash());
	}

}
