package com.sonstuf.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.Retval;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet () {
		super ();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String op;
		Retval operationStatus;
		ObjectMapper mapper;
		
		op = request.getParameter ("op");
		
		if (op == null) {
			
			operationStatus = new Retval (false, "Invalid request: missing op parameter");
		
		} else {
		
			switch (op) {
				
				case "register":
					
					operationStatus = doRegistration (request);
					break;
					
				default:
					
					//TODO: please escape op to avoid code injection
					operationStatus = new Retval (false, op + ": Unknown operation");
					break;
			}
		}
		
		mapper = new ObjectMapper ();
		response.getWriter ().write (mapper.writeValueAsString (operationStatus));
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet (request, response);
	}
	
	private Retval doRegistration (HttpServletRequest request) {
		
		User user;
		String name, surname, email, password1, password2, phone, birthdate;
		
		name = request.getParameter ("name");
		surname = request.getParameter ("surname");
		email = request.getParameter ("email");
		phone = request.getParameter ("phone");
		birthdate = request.getParameter ("birthdate");
		password1 = request.getParameter ("password1");
		password2 = request.getParameter ("password2");
		
		//start of the field check
		
		if (!validateEmail (email)) {
			
			return new Retval (false, "Please double check your email address");
		}
		
		if (!validateDate (birthdate)) {
			
			return new Retval (false, "Birth date seems invalid");
		}
		
		if (!password1.equals (password2)) {
			
			return new Retval (false, "Passwords do not match");
		}
		
		user = new User ();
		//TODO: user creation
		
		return null;
	}
	
	private boolean validateEmail (String emailAddress) {
		
		Pattern pattern;
		Matcher matcher;
		
		pattern = Pattern.compile (EMAIL_PATTERN);
		matcher = pattern.matcher (emailAddress);
		
		return matcher.matches ();
	}
	
	private static boolean validateDate (String date) {
		
		SimpleDateFormat sdf;
		
		sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		try {
			
			sdf.parse (date);
			return true;
			
		} catch (ParseException e) {
			
			return false;
		}
	}
	
}
