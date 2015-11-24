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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.RequestModel;
import com.sonstuf.model.UserModel;
import com.sonstuf.model.bean.Category;
import com.sonstuf.model.bean.Request;
import com.sonstuf.model.bean.User;

/**
 * Servlet implementation class CategoriesServlet
 */
public class GetUserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserRequestServlet () {
		super ();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

		int idRequest=(int)request.getAttribute("idRequest");
		MiniPacket result=null;
		PrintWriter writer;

		ObjectMapper mapper;

		writer = response.getWriter ();
		mapper = new ObjectMapper ();




		try {

			User user=null;
			Request request2= RequestModel.getRequestById(idRequest);


			writer.write (mapper.writeValueAsString (result.ToMiniPacket(user,request2)));





		} catch (SQLException | NamingException e) {

			e.printStackTrace();
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



	private static class MiniPacket {

		private int idRequest;
		private User user;
		private Request request;

		public static MiniPacket ToMiniPacket (User user,Request request) {

			MiniPacket res;

			res = new MiniPacket ();

			res.setIdRequest (request.getIdRequest ());
			res.setUser (user);
			res.setRequest (request);

			return res;
		}


		public int getIdRequest() {
			return idRequest;
		}

		public void setIdRequest(int idRequest) {
			this.idRequest = idRequest;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Request getRequest() {
			return request;
		}

		public void setRequest(Request request) {
			this.request = request;
		}
	}
}

