package com.sonstuf.control;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.JsonPacket;
import com.sonstuf.utils.Retval;
import com.sonstuf.utils.serializers.RequestSerializer;
import com.sonstuf.utils.serializers.RequestSerializerNoDescription;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Servlet implementation class RequestsServlet
 */
public class RequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {

		String op;
		PrintWriter writer;

		writer = response.getWriter();
		op = request.getParameter("op");

		if (op != null) {

			switch (op) {

				case "listAll":

					listAllRequests (writer);
					break;

				case "view":

					viewRequest (request, writer);
					break;
					
				case "insert":
					
					ObjectMapper mapper;
					
					mapper = new ObjectMapper ();
					writer.write (mapper
							.writeValueAsString (insertRequest (request)));
					break;

				default:

					response.getWriter().write("Unsupported operation");
			}
		} else {
			
			response.getWriter ().write ("Missing op parameter");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {

		//TODO: inserimento richiesta
		doGet(request, response);
	}

	private void listAllRequests(PrintWriter writer) {

		List<Request> requests;
		boolean comma;

		comma = false;
		writer.write('[');

		try {

			requests = RequestModel.getAllRequests();
			
			for (Request request : requests) {

				if (!comma) {
					comma = true;
				} else {
					writer.write(',');
				}
				
				writer.write (new PacketNoDescription (request).toJSON ());
			}

		} catch (SQLException | NamingException | JsonProcessingException e) {

			e.printStackTrace();
		}

		writer.write(']');
	}

	private void viewRequest (HttpServletRequest request, PrintWriter writer) {
		
		String requestId;
		int parsedId;
		Request r;

		requestId = request.getParameter("idRequest");

		if (requestId == null || requestId.length() == 0) {

			writer.write("Invalid operation: the idRequest parameter should be specified");
			return;
		}

		try {

			parsedId = Integer.parseInt(requestId);

		} catch (NumberFormatException e) {

			writer.write("Invalid parameter: the requestId parameter should be a valid integer");
			return;
		}

		try {

			r = RequestModel.getRequestById(parsedId);

			if (r != null) {
				writer.write(new Packet (r).toJSON ());
			} else {
				writer.write("Invalid request: item not found");
			}

		} catch (SQLException | NamingException | JsonProcessingException e) {

			writer.write("Backend error");
			e.printStackTrace();
			return;
		}
	}
	
	private Retval insertRequest (HttpServletRequest request) {		
		
		String title, description, place, category, time;
		int categoryId;
		Request newRequest;
		
		title = request.getParameter ("title");
		description = request.getParameter ("description");
		place = request.getParameter ("place");
		category = request.getParameter ("categoryId");
		time = request.getParameter ("time");
		
		if (title == null)
			return new Retval (false, "Missing \"title\" parameter");
		
		if (description == null) 
			return new Retval (false, "Missing \"description\" parameter");
		
		if (place == null)
			return new Retval (false, "Missing \"place\" parameter");
		
		if (category == null) 
			return new Retval (false, "Missing \"categoryId\" parameter");
		
		if (time == null) 
			return new Retval (false, "Missin \"time\" parameter");
		
		try {
			
			categoryId = Integer.parseInt (category);
			
		} catch (NumberFormatException e) {
			
			return new Retval (false, "Invalid categoryId integer");
		}
		
		try {
			if (CategoryModel.getCategoryById (categoryId) == null)
				return new Retval (false, "Invalid categoryId: category not found");
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
			return new Retval (false, "Backend error: " + e.getMessage ());
		}
		
		newRequest = new Request ();
		
		newRequest.setDescription (description);
		newRequest.setTitle (title);
		newRequest.setPlace (place);
		newRequest.setIdCategory (categoryId);
		newRequest.setDateTime (time);
		
		try {
			RequestModel.insert (newRequest);
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
			return new Retval (false, "Backend error: " + e.getMessage ());
		}
		
		return new Retval (true);
	}
	
	private class Packet implements JsonPacket {
		
		private int idRequest;
		private User user;
		private Request request;
		
		public Packet (Request request)
				throws SQLException, NamingException {
			
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
					new RequestSerializer<Request> ());
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
	
	private class PacketNoDescription extends Packet {

		public PacketNoDescription (Request request)
				throws SQLException, NamingException {
			super (request);
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
					new RequestSerializerNoDescription<Request> ());
			mapper.registerModule (module);
			
			filters.addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept (
							"name",
							"rankR"
					));
			
			return mapper.setFilterProvider (filters).writeValueAsString (this);
		}
	}
}
