package com.sonstuf.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonstuf.model.CategoryModel;
import com.sonstuf.model.bean.Category;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class CategoriesServlet
 */
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoriesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		List<Category> categories;
		PrintWriter writer;
		boolean comma;
		ObjectMapper mapper;

		writer = response.getWriter();
		mapper = new ObjectMapper();

		writer.write('[');
		comma = false;

		try {

			categories = CategoryModel.getAllCategories();

			for (Category category : categories) {

				if (!comma) {
					comma = true;
				} else {
					writer.write(',');
				}

				writer.write(mapper.writeValueAsString(
						MiniPacket.categoryToMiniPacket(category)));
			}

		} catch (SQLException | NamingException e) {

			e.printStackTrace();
		}

		writer.write(']');

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request,
	                      HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private static class MiniPacket {

		private int idcategory;
		private String category;

		public static MiniPacket categoryToMiniPacket(Category category) {

			MiniPacket res;

			res = new MiniPacket();

			res.setIdcategory(category.getIdCategory());
			res.setCategory(category.getName());

			return res;
		}

		/**
		 * @return the idcategory
		 */
		public int getIdcategory() {
			return idcategory;
		}

		/**
		 * @param idcategory the idcategory to set
		 */
		public void setIdcategory(int idcategory) {
			this.idcategory = idcategory;
		}

		/**
		 * @return the category
		 */
		public String getCategory() {
			return category;
		}

		/**
		 * @param category the category to set
		 */
		public void setCategory(String category) {
			this.category = category;
		}
	}

}
