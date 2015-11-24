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
		User pattern = parseJson(request.getReader());
		List<User> userListDB = null;
		try {
			userListDB = requestDataFromDB(pattern);
		} catch (SQLException | NamingException e) {
			response.getWriter().write(e.toString());
		}
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
					writer.write(mapper.setFilterProvider(filters)
							.writeValueAsString(user));

				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		writer.write(']');
	}

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

		ObjectMapper mapper = new ObjectMapper();
		res = mapper.readValue(jb.toString(), User.class);

		return res;
	}


}
