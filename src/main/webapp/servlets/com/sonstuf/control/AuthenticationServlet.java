package com.sonstuf.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sonstuf.utils.Retval;

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
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		// Request's session; if absent, create it
		HttpSession session;
		String op, username, password;
		
		session = request.getSession (true);
		op = request.getParameter ("op");
		
		/*
		// For picking up methods return values
		Retval retval = null;
		
		switch (op) {
			case "login":
				
				retval = authenticate (username, password, session, request,
						response);
						
				String role = retval.getDescription ();
				
				String destination = request.getParameter ("dest");
				String context = ((HttpServletRequest) request)
						.getContextPath ();
				destination = destination.replace (context, "");
				
				if (role.equals (ADMIN_ROLE)) {
					request.setAttribute ("title", "Conferma");
					request.setAttribute ("message",
							"Sei stato loggato con permessi di amministratore");
					request.setAttribute ("actionMessage",
							"Login amministartore");
					request.getRequestDispatcher (destination).forward (request,
							response);
							
				} else if (role.equals (USER_ROLE)) {
					request.setAttribute ("title", "Conferma");
					request.setAttribute ("message",
							"Hai ottenuto l'accesso alle risorse private");
					request.setAttribute ("actionMessage", "Login");
					request.getRequestDispatcher (destination).forward (request,
							response);
							
				} else {
					request.setAttribute ("loginError",
							Boolean.valueOf ("true"));
					request.setAttribute ("errorMessage",
							retval.getDescription ());
					request.setAttribute ("destination", destination);
					request.getRequestDispatcher (ProjectGlobals.LOGIN_PAGE)
							.forward (request, response);
				}
				
				break;
				
			case "logout":
				
				logOut (request, response, session);
				
				break;
				
			case "signup":
				
				try {
					retval = signUp (request, session);
				} catch (NamingException | SQLException
						| NoSuchAlgorithmException
						| InvalidKeySpecException ex) {
					retval = new Retval (false,
							"Impossibile portare a termine la registrazione. Dettagli tecnici: "
									+ ex.getMessage ());
				}
				
				if (retval.getSuccess ()) {
					request.setAttribute ("title", "Conferma");
					request.setAttribute ("message",
							"Grazie, per esserti iscritto ! ;-) "
									+ "Una email di convalida verrà inviata al tuo indirizzo di posta");
					request.setAttribute ("actionMessage", "Sign Up");
					request.getRequestDispatcher (
							ProjectGlobals.CONFIRMATION_PAGE)
							.forward (request, response);
							
				} else {
					request.setAttribute ("signuperror", true);
					request.setAttribute ("errorMessage",
							retval.getDescription ());
					request.getRequestDispatcher (ProjectGlobals.SIGN_IN_PAGE)
							.forward (request, response);
				}
				
				break;
				
			case "delete":
				
				try {
					retval = removeAccount (password, session);
					logOut (request, response, session);
				} catch (SQLException | NamingException
						| NoSuchAlgorithmException
						| InvalidKeySpecException ex) {
					retval = new Retval (false,
							"Errore durante la connessione al database. Dettagli tecnici: "
									+ ex.getMessage ());
				}
				
				if (retval.getSuccess ()) {
					session.invalidate ();
					
					request.setAttribute ("title", "Conferma");
					request.setAttribute ("message",
							"IL tuo account è stato correttamente cancellato");
					request.setAttribute ("actionMessage", "Cancella account");
					request.getRequestDispatcher (
							ProjectGlobals.CONFIRMATION_PAGE)
							.forward (request, response);
							
				} else {
					request.setAttribute ("deletionError", true);
					request.setAttribute ("errorMessage",
							retval.getDescription ());
					request.getRequestDispatcher (ProjectGlobals.SIGN_OUT_PAGE)
							.forward (request, response);
				}
				
				break;
				
			case "changepw":
				
				try {
					retval = changePw (request, session);
				} catch (NamingException | SQLException
						| NoSuchAlgorithmException
						| InvalidKeySpecException ex) {
					retval = new Retval (false,
							"Impossibile cambiare password! Riprova dopo!: "
									+ ex.getMessage ());
				}
				
				if (retval.getSuccess ()) {
					logOut (request, response, session);
					
				} else {
					request.setAttribute ("changepwerror", true);
					request.setAttribute ("errorMessage",
							retval.getDescription ());
					request.getRequestDispatcher (
							ProjectGlobals.CHANGE_PASSWORD)
							.forward (request, response);
				}
				
				break;
				
			default:
				request.setAttribute ("title", "Attenzione");
				request.setAttribute ("message",
						"L'operazione richiesta non è disponibile");
				request.setAttribute ("actionMessage", "Attenzione");
				request.getRequestDispatcher (ProjectGlobals.CONFIRMATION_PAGE)
						.forward (request, response);
				break;
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private Retval doAuth (HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session;
		String username, password;
		Retval res;
		
		session = request.getSession (true);
		
		username = request.getParameter (FORM_USERNAME_FIELD);
		password = request.getParameter (FORM_PASSWORD_FIELD);
		
		if (username == null) {
			
			return new Retval (false, "Invalid request: username parameter missing");
		}
		
		if (password == null) {
			
			return new Retval (false, "Invalid request: password parameter missing");
		}
		
		/*
		String role;
		User user;
		boolean isPasswordRight;

		try {

			user = UserModel.getUserByEmail (username);

			if (user == null) {

				return new Retval (false, "Utente inesistente");
			}

			isPasswordRight = UserModel.checkPassword (password, user);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException | NamingException | SQLException ex) {
			Logger.getLogger (AuthenticationServlet.class.getName ()).log (Level.SEVERE, null, ex);
			return new Retval (false, ex.getMessage ());
		}

		if (!isPasswordRight) {
			res = new Retval (false, "Password errata");

		} else if (!user.isActive ()) {

			res = new Retval (false, "Controlla la tua email per confermare il tuo account");

		} else {

			role = user.getRuolo ();

			updateSuccessfulLoginForUser (user, session);

			String rememberMe = request.getParameter ("remember_me");

			if (rememberMe != null && rememberMe.equals ("1")) {

				Retval ret = setAuthCookies (user.getIdUtente (), request, response);

				if (ret.getSuccess ()) {

					res = new Retval (true, role);

				} else {

					res = ret;

				}
			} else {
				res = new Retval (true, role);
			}
		}
		*/

		return null;
	}

}
