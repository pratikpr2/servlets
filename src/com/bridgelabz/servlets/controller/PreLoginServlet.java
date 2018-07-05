package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.servlets.model.User;
import com.bridgelabz.servlets.services.ServletServices;

/**
 * Servlet implementation class PreLoginServlet
 */
//@WebServlet("/PreLoginServlet")
public class PreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("email");
		String pwd = request.getParameter("password");
		ServletServices service = new ServletServices();
		User user = service.getUser(name, pwd);
		if(user!=null) {
			//System.out.println(user.getFirstName());
			RequestDispatcher dispatch = request.getRequestDispatcher("getProfile");
			dispatch.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20);
			session.setAttribute("userName", user.getFirstName());
			System.out.println(session.getAttribute("userName"));
		}
		else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/Home.jsp");
			dispatch.include(request, response);
			out.println("<html><div align='center'><p>Wrong PassWord<p></div></html>");
		}
		
		
	}

}
