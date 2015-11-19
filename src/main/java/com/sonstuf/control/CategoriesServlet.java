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
import com.sonstuf.model.bean.Category;
import com.sonstuf.utils.Retval;

/**
 * Servlet implementation class CategoriesServlet
 */
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriesServlet () {
		super ();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		List<Category> categories;
		PrintWriter writer;
		boolean comma;
		
		writer = response.getWriter ();
		
		writer.write ('[');
		comma = false;
		
		try {
		
			categories = CategoryModel.getAllCategories ();
			
			for (Category category : categories) {
				
				if (!comma) {
					comma = true;
				} else {
					writer.write (',');
				}
				
				writer.write ("\"" + category.getName () + "\"");
			}
			
		} catch (SQLException | NamingException e) {
			
			e.printStackTrace();
		}
		
		writer.write (']');
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		doGet (request, response);
	}
	
}
