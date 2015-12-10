package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.OfferModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Offer;
import com.sonstuf.model.bean.OfferPacket;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.serializers.RequestSerializer;
import com.sonstuf.utils.serializers.UserSerializer;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
		response.setContentType("application/json");
		String op;
		
		op = request.getParameter ("op");
		
		if (op == null) {
			
			response.getWriter ().write ("Invalid request: missing op parameter");
		
		} else {

			response.setContentType("application/json");
		
			switch (op) {
				
				case "profile":
					
					sendProfile (request, response);
					break;
					
				case "userRequests":
					
					sendUserRequests (request, response);
					break;
				
				case "userOffers":
					
					sendUserOffers (request, response);
					break;
					
				default:
					
					response.getWriter ().println ("Unknown operation");
					break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		doGet (request, response);
	}
	
	private User getUserFromSession (HttpSession session) {
		
		User res;
		
		res = null;
		
		if (session != null) {
			
			res = (User) session.getAttribute ("user");
		}
		
		return res;
	}
	
	private void sendProfile (HttpServletRequest request,
			HttpServletResponse response) {
			
		User user;
		ObjectMapper mapper;
		SimpleModule module;
		
		user = getUserFromSession (request.getSession ());
			
		if (user != null) {
			
			try {
				
				mapper = new ObjectMapper ();
				
				module = new SimpleModule ();
				module.addSerializer (User.class,
						new UserSerializer<User> ());
				mapper.registerModule (module);
				
				response.getWriter ()
						.write (mapper.writeValueAsString ((user)));
				
			} catch (IOException e) {
				
				e.printStackTrace ();
			}
		}
	}
	
	private void sendUserRequests (HttpServletRequest request,
			HttpServletResponse response)throws IOException {
		
		User currentUser;
		List<Request> userRequests;
		PrintWriter writer;
		SimpleFilterProvider filters;
		boolean comma;
		
		comma = false;
		
		currentUser = getUserFromSession (request.getSession ());
		writer = response.getWriter ();
		
		if (currentUser != null) {
			
			try {
				
				filters = new SimpleFilterProvider();

				filters.addFilter("rankFilter",
						SimpleBeanPropertyFilter.serializeAllExcept ("rankO"));
				filters.addFilter ("filter",
						SimpleBeanPropertyFilter.serializeAll ());
						
				userRequests = RequestModel
						.getRequestsByUserId (currentUser.getIdUser ());
				
				writer.write ("[");
				
				
				for (Request r : userRequests) {
					
					if (!comma) {
						comma = true;
					} else {
						writer.write(',');
					}
					
					writer.write (new Packet (r).toJSON ());
					
				}
				
				writer.write ("]");
				
			} catch (SQLException | NamingException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private void sendUserOffers (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		User currentUser;
		List<Offer> userOffers;
		PrintWriter writer;
		boolean comma;
		
		comma = false;
		
		currentUser = getUserFromSession (request.getSession ());
		writer = response.getWriter ();
		userOffers = null;
		
		if (currentUser != null) {
			
			try {
				
				userOffers = OfferModel.getOffersByUserId (currentUser.getIdUser ());
				
				writer.write ("[");
				
				for (Offer offer : userOffers) {
					
					if (!comma) {
						comma = true;
					} else {
						writer.write(',');
					}
					
					writer.write (OfferPacket.getOfferPacketFromOffer (offer)
							.toJSON ());
				}
				
				writer.write ("]");
				
			} catch (SQLException | NamingException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private class Packet implements JsonPacket {
		
		private int idRequest;
		private User user;
		private Request request;
		
		public Packet (Request request) throws SQLException, NamingException {
			
			this.idRequest = request.getIdRequest ();
			this.user = UserModel.getUserById (request.getIdUser ());
			this.request = request;
		}
		
		@Override
		public String toJSON () throws JsonProcessingException {
			
			ObjectMapper mapper;
			SimpleFilterProvider filters;
			SimpleModule module;
			
			mapper = new ObjectMapper ();
			filters = new SimpleFilterProvider();
			
			module = new SimpleModule ();
			module.addSerializer (Request.class,
					new RequestSerializer<> ("title", "description", "place", "time", "postTimeStamp"));
			mapper.registerModule (module);
			
			filters.addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept (
							"name",
							"rankR"
					));
			
			return mapper.setFilterProvider (filters).writeValueAsString (this);
		}
		
		public int getIdRequest () {
			return idRequest;
		}
		
		public void setIdRequest (int idRequest) {
			this.idRequest = idRequest;
		}
		
		public User getUser () {
			return user;
		}
		
		public void setUser (User user) {
			this.user = user;
		}
		
		public Request getRequest () {
			return request;
		}
		
		public void setRequest (Request request) {
			this.request = request;
		}
	}
}
