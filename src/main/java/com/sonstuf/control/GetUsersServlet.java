package com.sonstuf.control;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.User;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetUsersServlet extends HttpServlet {

	public GetUsersServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ");
		User pattern = parseJson(request.getReader());


		List<User> userListDB = null;
		try {
			System.out.println("1");
			userListDB = requestDataFromDB(pattern);
			System.out.println("2");
		} catch (SQLException | NamingException e) {
			System.out.println("3");
			response.getWriter().write(e.toString());
			System.out.println("4");
		}
		System.out.println("\t\t\tdim "+ userListDB.size());
		//filtrate userList based on the pattern
		PrintWriter writer = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		writer.write('[');

		SimpleFilterProvider filters;

		filters = new SimpleFilterProvider();
		filters.addFilter("filter",
				SimpleBeanPropertyFilter.serializeAllExcept("passwordHash", "rankO", "rankP"));
		boolean done = false;
		try {
			for (User user : userListDB) {
				if (pattern.equalsIgnoringNullFields(user)) { //retain only the Users that match the pattern
					if (!done) {
						done = true;
					} else {
						writer.write(',');
					}
					System.out.println("user: "+user.getName());
					writer.write(mapper.setFilterProvider(filters)
							.writeValueAsString(user));

				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		writer.write(']');
	}

	/**
	 * stops at the first not null field of the pattern.
	 * fields order: phone, email, name, surname, birthdate.
	 * @param pattern the user pattern, some field can be null, if all fields are null all the users are retrieved.
	 * @return the list of users that match the first constraint.
	 * @throws SQLException
	 * @throws NamingException
	 */
	private List<User> requestDataFromDB(User pattern) throws SQLException, NamingException {
		List<User> userList = new ArrayList<>();
		if (pattern.getPhone() != null)
			userList.add(UserModel.getUserByPhone(pattern.getPhone()));
		else if (pattern.getEmail() != null)
			userList.add(UserModel.getUserByMail(pattern.getEmail()));
		else if (pattern.getName() != null)
			userList = UserModel.getUserByName(pattern.getName());
		else if (pattern.getSurname() != null)
			userList = UserModel.getUserBySurname(pattern.getSurname());
		else if (pattern.getBirthDate() != null)
			userList = UserModel.getUserByBirthdate(pattern.getBirthDate());
		else userList = UserModel.getAllUsers();
		System.out.println("list: "+userList.get(0).getName());
		return userList;
	}

	private User parseJson(BufferedReader jsonReader) throws IOException {
		User res = null;
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			while ((line = jsonReader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			throw new IOException("impossible to read the json");
		}

		String jsonUser=jb.toString();
		System.out.println("jsonUser: "+jsonUser + "" + System.currentTimeMillis());
		ObjectMapper mapper = new ObjectMapper();
		res = mapper.readValue(jb.toString(), User.class);
		System.out.println("name: "+res.getName());

		System.out.println("Sono qui");
		return res;
	}


}
