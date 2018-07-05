package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.bridgelabz.servlets.services.ServletServices;

/**
 * Servlet Filter implementation class RegistrationFilter
 */
//@WebFilter("/RegistrationFilter")
public class RegistrationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegistrationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		PrintWriter out = response.getWriter();
		String name = request.getParameter("email");
		ServletServices service = new ServletServices();
		if(!service.validateUser(name)) {
			System.out.println("unique Email ");
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/Registration.jsp");
			dispatch.include(request, response);
			out.println("<html><div align='center'><p>Email Already Exists<p><br><p>Provide Different Email..</p></div></html>");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
