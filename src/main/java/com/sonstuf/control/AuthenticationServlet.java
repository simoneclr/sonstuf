package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.Retval;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FORM_USERNAME_FIELD = "userName";
	private static final String FORM_PASSWORD_FIELD = "password";
	private static final String FORM_REMEMBER_ME_FIELD = "rememberMe";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String op;
		Object operationStatus;
		ObjectMapper mapper;

		op = request.getParameter("op");

		if (op == null) {

			operationStatus = new Retval(false, "Invalid request: missing op parameter");

		} else {

			switch (op) {

				case "authenticate":

					operationStatus = doLogin(request);
					break;

				case "logout":

					operationStatus = doLogout(request);
					break;

				case "checkLogin":

					operationStatus = checkLogin(request);
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private Retval doLogin(HttpServletRequest request) {

		HttpSession session;
		String username, password; // NOTA: username might also contain user's phone number
		User tempUser;
		boolean isPasswordRight;

		session = request.getSession(true);

		username = request.getParameter(FORM_USERNAME_FIELD);
		password = request.getParameter(FORM_PASSWORD_FIELD);

		if (username == null) {

			return new Retval(false, "Invalid request: username parameter missing");
		}

		if (password == null) {

			return new Retval(false, "Invalid request: password parameter missing");
		}

		try {

			tempUser = UserModel.getUserByMail(username);

			if (tempUser == null) {

				tempUser = UserModel.getUserByPhone(username);

				if (tempUser == null) {

					return new Retval(false, "Invalid email/phone number or password");
				}
			}

			isPasswordRight = UserModel.checkPassword(password, tempUser);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException | NamingException | SQLException ex) {

			return new Retval(false, ex.getMessage());
		}

		if (!isPasswordRight) {

			return new Retval(false, "Invalid email/phone number or password");
		}

		session.setAttribute("user", tempUser);

		return new Retval(true);
	}

	private Retval doLogout(HttpServletRequest request) {

		HttpSession session;

		session = request.getSession();

		if (session != null) {

			session.removeAttribute("user");
		}

		return new Retval(true);
	}

	private MiniPacket checkLogin(HttpServletRequest request) {

		HttpSession session;
		User loggedUser;

		session = request.getSession();

		if (session != null) {

			loggedUser = (User) session.getAttribute("user");

			if (loggedUser != null)
				return new MiniPacket(true, loggedUser.getName(), loggedUser.isAdmin ());
		}

		return new MiniPacket(false, null, false);
	}
	
	private class MiniPacket implements JsonPacket {
		
		private boolean logged;
		private boolean isAdmin;
		private String name;
		
		public MiniPacket (boolean logged, String name, boolean isAdmin) {
			
			this.logged = logged;
			this.name = name;
			this.isAdmin = isAdmin;
		}
		
		@Override
		public String toJSON () throws JsonProcessingException {
			
			ObjectMapper mapper;
			
			mapper = new ObjectMapper ();
			return mapper.writeValueAsString (this);
		}

		public boolean isLogged () {
			return logged;
		}

		public void setLogged (boolean logged) {
			this.logged = logged;
		}

		public boolean isAdmin () {
			return isAdmin;
		}

		public void setAdmin (boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		public String getName () {
			return name;
		}

		public void setName (String name) {
			this.name = name;
		}
	}

}
