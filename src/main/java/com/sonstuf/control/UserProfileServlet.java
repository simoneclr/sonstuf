package com.sonstuf.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.Retval;

/**
 * Servlet implementation class UserProfileServlet
 */
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op;
		
		op = request.getParameter ("op");
		
		if (op == null) {
			
			response.getWriter ().write ("Invalid request: missing op parameter");
		
		} else {
		
			switch (op) {
				
				case "profile":
					
					sendProfile (request, response);
					break;
					
				default:
					
					response.getWriter ().println ("Unknown operation");
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void sendProfile (HttpServletRequest request, HttpServletResponse response) {
		
		ObjectMapper mapper;
		User user;
		HttpSession session;
		
		session = request.getSession ();
		
		if (session != null) {
			
			/* NOTA: due to the loginFilter, session here should never be null since
			 * to access this servlet we require a logged user
			 */
			
			user = (User) session.getAttribute ("user");
			
			if (user != null) {
				
				/* NOTA: same as before, here we should always find a user */
				
				mapper = new ObjectMapper (); 
				
				try {
					response.getWriter ().write (mapper.writeValueAsString (
							MiniPacket.userToMiniPacket (user)));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * PAGINA PERSONALE UTENTE
	input:
	USER = {
		"idUser": "<userId>",
		"name" : "<name>",
		"surname" : "<surname>" ,
		"telephone" : "<telephone>",
		"email" : "<email>" ,
		"birthdate" : "birthdate",
		"rankO" : "<doubleRank>" ,
		"rankR" : "<doubleRank>"
	}
	*/
	
	private static class MiniPacket {
		
		private int idUser;
		private String name;
		private String surname;
		private String telephone;
		private String email;
		private String bithdate;
		private double rankO;
		private double rankR;
		
		public static MiniPacket userToMiniPacket (User user) {
			
			MiniPacket res;
			
			res = new MiniPacket ();
			
			res.setIdUser (user.getIdUser ());
			res.setName (user.getName ());
			res.setSurname (user.getSurname ());
			res.setTelephone (user.getPhone ());
			res.setEmail (user.getEmail ());
			res.setBithdate (user.getBirthDate ().toString ()); //TODO: time format?
			res.setRankO (user.getRankO ());
			res.setRankR (user.getRankP ());
			
			return res;
		}
		
		public int getIdUser () {
			return idUser;
		}
		public void setIdUser (int idUser) {
			this.idUser = idUser;
		}
		public String getName () {
			return name;
		}
		public void setName (String name) {
			this.name = name;
		}
		public String getSurname () {
			return surname;
		}
		public void setSurname (String surname) {
			this.surname = surname;
		}
		public String getTelephone () {
			return telephone;
		}
		public void setTelephone (String telephone) {
			this.telephone = telephone;
		}
		public String getEmail () {
			return email;
		}
		public void setEmail (String email) {
			this.email = email;
		}
		public String getBithdate () {
			return bithdate;
		}
		public void setBithdate (String bithdate) {
			this.bithdate = bithdate;
		}
		public double getRankO () {
			return rankO;
		}
		public void setRankO (double rankO) {
			this.rankO = rankO;
		}
		public double getRankR () {
			return rankR;
		}
		public void setRankR (double rankR) {
			this.rankR = rankR;
		}
	}

}
