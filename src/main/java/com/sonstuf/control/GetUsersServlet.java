package com.sonstuf.control;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.ProjectGlobals;
import com.sonstuf.utils.serializers.UserSerializer;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GetUsersServlet extends HttpServlet {
	/**
	 * bean like user but with only the fields that the operator can match.
	 */
	private static class UserPattern {
		private String name;
		private String surname;
		private String phone;
		private String email;
		private Date birthDate;

		/**
		 * @return true if there is a name to match, false otherwise
		 */
		public boolean isNameSetted() {
			if (name != null && !name.equals("")) return true;
			return false;
		}

		/**
		 * @return true if there is a surname to match, false otherwise
		 */
		public boolean isSurnameSetted() {
			if (surname != null && !surname.equals("")) return true;
			return false;
		}

		/**
		 * @return true if there is a phone to match, false otherwise
		 */
		public boolean isPhoneSetted() {
			if (phone != null && !phone.equals("")) return true;
			return false;
		}

		/**
		 * @return true if there is an email to match, false otherwise
		 */
		public boolean isEmailSetted() {
			if (email != null && !email.equals("")) return true;
			return false;
		}

		/**
		 * @return true if there is a birth date to match, false otherwise
		 */
		public boolean isBirthDateSetted() {
			if (birthDate != null) return true;
			return false;
		}

		/**
		 * @param obj checks if the specified user matches the pattern.
		 * @return
		 */
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof User))
				return false;

			User user = (User) obj;

			//if the user name is in the pattern.
			if (this.isNameSetted())
				if (!this.getName().equals(user.getName())) return false; //if different user names.

			//if the surname is in the pattern.
			if (this.isSurnameSetted())
				if (!this.getSurname().equals(user.getSurname())) return false; //if different surnames.

			//if the phone number is in the pattern.
			if (this.isPhoneSetted())
				if (!this.getPhone().equals(user.getPhone())) return false; //if different phones.

			//if the email is in the pattern.
			if (this.isEmailSetted())
				if (!this.getEmail().equals(user.getEmail())) return false; //if different emails.

			//if the birthdate is in the pattern.
			if (this.isBirthDateSetted())
				if (!this.getBirthDate().equals(user.getBirthDate())) return false; //if different birth dates.

			return true;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(String dateStr) throws ParseException {
			if (dateStr == null || dateStr.equals("")) {
				this.birthDate = null;
				return;
			}
			SimpleDateFormat df = new SimpleDateFormat(ProjectGlobals.DATE_INPUT_FORMAT);
			this.birthDate = new Date(df.parse(dateStr).getTime());
		}
	}

	public GetUsersServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		UserPattern pattern = parseJson(request.getReader());


		List<User> userListDB = null;
		try {
			userListDB = requestDataFromDB(pattern);
		} catch (SQLException | NamingException e) {
			response.getWriter().write(e.toString());
		}

		sendMatchingUsers(userListDB, pattern, response);

	}

	private void sendMatchingUsers(List<User> list, UserPattern pattern, HttpServletResponse response) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addSerializer(User.class, new UserSerializer<>("idUser", "name", "surname", "telephone", "email", "birthdate"));
		mapper.registerModule(module);

		try {
			PrintWriter writer = response.getWriter();
			writer.write("[");

			boolean done = false;
			for (User user : list) {
				if (pattern.equals(user)) { //retain only the Users that match the pattern
					if (!done) {
						done = true;
					} else {
						writer.write(',');
					}
					String json = mapper.writeValueAsString(user);

					writer.write(json);

				}
			}

			writer.write("]");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * stops at the first not null field of the pattern.
	 * fields order: phone, email, name, surname, birthdate.
	 *
	 * @param pattern the user pattern, some field can be null, if all fields are null all the users are retrieved.
	 * @return the list of users that match the first constraint.
	 * @throws SQLException
	 * @throws NamingException
	 */
	private List<User> requestDataFromDB(UserPattern pattern) throws SQLException, NamingException {
		List<User> userList = new ArrayList<>();
		//search for the first setted field in the pattern, query all the user that match that field and return this list.
		if (pattern.isPhoneSetted())
			userList.add(UserModel.getUserByPhone(pattern.getPhone()));

		else if (pattern.isEmailSetted())
			userList.add(UserModel.getUserByMail(pattern.getEmail()));

		else if (pattern.isNameSetted())
			userList = UserModel.getUserByName(pattern.getName());

		else if (pattern.isSurnameSetted())
			userList = UserModel.getUserBySurname(pattern.getSurname());

		else if (pattern.isBirthDateSetted())
			userList = UserModel.getUserByBirthdate(pattern.getBirthDate());

		else {

			userList = UserModel.getAllUsers();

		}

		return userList;
	}

	private UserPattern parseJson(BufferedReader jsonReader) throws IOException {
		UserPattern res = null;
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			while ((line = jsonReader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) {
			throw new IOException("impossible to read the json");
		}

		ObjectMapper mapper = new ObjectMapper();
		res = mapper.readValue(jb.toString(), UserPattern.class);
		return res;
	}


}
