package com.sonstuf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sonstuf.utils.ProjectGlobals;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	
	/**
	 * Default constructor.
	 */
	public LoginFilter () {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy () {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter (ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if (request instanceof HttpServletRequest) {
			
			HttpServletRequest httpRequest;
			HttpSession session;
			
			httpRequest = (HttpServletRequest) request;
			session = httpRequest.getSession ();
			
			if (session != null && session.getAttribute ("user") != null) {
				// pass the request along the filter chain
				chain.doFilter (request, response);
			} else {
				errorPageForward (httpRequest, response);
			}
		}
		
		
	}
	
	private void errorPageForward (ServletRequest request,
			ServletResponse response) throws ServletException, IOException {
			
		request.setAttribute ("errorMessage", "Forbidden: registered user only area");
		
		request.getRequestDispatcher (ProjectGlobals.ERROR_PAGE)
				.forward (request, response);
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init (FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
