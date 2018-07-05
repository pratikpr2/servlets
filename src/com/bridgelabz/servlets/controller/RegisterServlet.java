package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.servlets.model.User;
import com.bridgelabz.servlets.services.ServletServices;

/**
 * Servlet implementation class RegisterSErvlet
 */
//@WebServlet("/RegisterSErvlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 
		User user = new User();
		
		user.setFirstName(firstName);
		user.setLastname(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		ServletServices service = new ServletServices();
		
		service.regUser(user);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("/Home.jsp");
		dispatch.include(request, response);
		out.println("<html><body><div align='center'><h3>Registration SuccesFull</h3><br><p>Please Login To Continue..</p></div></body></html>");
	}

}
