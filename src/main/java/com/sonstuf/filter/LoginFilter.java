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
				//TODO: forward to and error/page or login page
				response.getWriter ().write ("Ciccia");
			}
		}
		
		
	}
	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init (FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
}
