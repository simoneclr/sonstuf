package com.sonstuf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;
import com.sonstuf.utils.Retval;

/**
 * Servlet implementation class RequestsServlet
 */
public class RequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestsServlet () {
		super ();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		String op;
		PrintWriter writer;
		
		writer = response.getWriter ();
		op = request.getParameter ("op");
		
		if (op != null) {
			
			switch (op) {
				
				case "listAll":
					
					listAllRequests (writer);
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
	
	private void listAllRequests (PrintWriter writer) {
		
		List<Request> requests;
		ObjectMapper mapper;
		boolean done;
		MiniPacket temp;
		
		mapper = new ObjectMapper ();
		done = false;
		writer.write ('[');
		
		try {
			
			requests = RequestModel.getAllRequests ();
			
			for (Request request : requests) {
				
				System.out.println (request.getIdRequest ());
				
				if (!done) {
					done = true;
				} else {
					writer.write (',');
				}
				
				temp = MiniPacket.requestToMiniPacket (request);
				
				System.out.println ("temp:" + mapper.writeValueAsString (temp));
				
				if (temp != null) {
					
					writer.write (mapper.writeValueAsString (temp));
				}
			}
		
		} catch (SQLException | NamingException | JsonProcessingException e) {
			
		}
		
		writer.write (']');
	}
	
	private static class MiniPacket {
		
		public int idRequest;
		public MiniUser user;
		public MiniRequest request;
		
		public static MiniPacket requestToMiniPacket (Request request) {
			
			MiniPacket res;
			
			try {
				
				res = new MiniPacket ();
				
				res.idRequest = request.getIdRequest ();
				res.user = MiniUser.userToMiniUser (
						UserModel.getUserById (request.getIdUser ()));
				res.request = new MiniRequest ();
				res.request.category = CategoryModel
						.getCategoryById (request.getIdCategory ()).getName ();
				res.request.place = request.getPlace ();
				res.request.time = request.getDateTime ();
				res.request.postTimestamp = request.getPostTime ().toString ();
			
			} catch (SQLException | NamingException e) {
				
				e.printStackTrace ();
				res = null;
			}
			
			
			return res;
		}
	}
	
	private static class MiniUser {
		
		private String name;
		private double rankR;
		
		private static MiniUser userToMiniUser (User user) {
			
			MiniUser res;
			
			res = new MiniUser ();
			
			res.name = user.getName ();
			res.rankR = user.getRankP ();
			
			return res;
		}
	}
	
	private static class MiniRequest {
		
		private String category;
		private String place;
		private String time;
		private String postTimestamp;
	}
	
}
