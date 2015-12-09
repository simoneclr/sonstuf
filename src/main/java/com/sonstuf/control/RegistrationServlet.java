package com.sonstuf.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.EmailValidator;
import com.sonstuf.utils.PasswordHash;
import com.sonstuf.utils.ProjectGlobals;
import com.sonstuf.utils.Retval;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String op;
		Retval operationStatus;
		ObjectMapper mapper;

		op = request.getParameter("op");

		if (op == null) {

			operationStatus = new Retval(false, "Invalid request: missing op parameter");

		} else {

			switch (op) {

				case "register":

					operationStatus = doRegistration(request);
					break;

				default:

					//TODO: please escape op to avoid code injection
					operationStatus = new Retval(false, op + ": Unknown operation");
					break;
			}
		}

		mapper = new ObjectMapper();
		response.getWriter().write(mapper.writeValueAsString(operationStatus));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private Retval doRegistration(HttpServletRequest request) {

		User user;
		String name, surname, email, password1, password2, phone, birthdate;
		Date parsedBirthDate;

		name = request.getParameter("name");
		surname = request.getParameter("surname");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		birthdate = request.getParameter("birthdate");
		password1 = request.getParameter("password1");
		password2 = request.getParameter("password2");

		if (name == null || name.length() == 0) {

			return new Retval(false, "Name field is mandatory");
		}

		if (surname == null || surname.length() == 0) {

			return new Retval(false, "Last name field is mandatory");
		}

		if (email == null || email.length() == 0) {

			return new Retval(false, "Email field is mandatory");
		}

		if (phone == null || phone.length() == 0) {

			return new Retval(false, "Telephone number is mandatory");
		}

		if (birthdate == null || birthdate.length() == 0) {

			return new Retval(false, "Birth date is mandatory");
		}

		if (password1 == null || password1.length() == 0) {

			return new Retval(false, "Please type a password");
		}

		if (password2 == null || password2.length() == 0) {

			return new Retval(false, "Please confirm your password");
		}

		if (!EmailValidator.validateEmail(email)) {

			return new Retval(false, "Please double check your email address");
		}

		try {
			parsedBirthDate = parseBirthDate(birthdate);
		} catch (ParseException e) {
			return new Retval(false, "Birth date seems invalid");
		}

		if (!password1.equals(password2)) {

			return new Retval(false, "Passwords do not match");
		}

		user = new User();

		user.setName(name);
		user.setSurname(surname);

		try {

			user.setPasswordHash(PasswordHash.createHash(password1));

			password1 = null;
			password2 = null;
			System.gc();


		} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
			return new Retval(false, "Backend error: " + e1.getMessage());
		}

		user.setEmail(email);
		user.setAdmin(false);
		user.setBirthDate(new java.sql.Date(parsedBirthDate.getTime()));
		user.setPhone(phone);

		try {
			return UserModel.insert(user);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException
				| SQLException | NamingException e) {
			return new Retval(false, e.getMessage());
		}
	}

	private static Date parseBirthDate(String date) throws ParseException {

		SimpleDateFormat sdf;

		sdf = new SimpleDateFormat(ProjectGlobals.DATE_INPUT_FORMAT);

		return sdf.parse(date);
	}

}
