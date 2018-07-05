package com.bridgelabz.servlets.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
//@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		request.getRequestDispatcher("Profile.jsp").include(request, response);
		if(session!=null) {
			System.out.println("session not empty");
			System.out.println(session.getAttribute("userName"));
			String name = session.getAttribute("userName").toString();
			//name = session.getAttribute("userName").toString();
			
			out.println("<html><body><div align='center'><h3>Welcome</h3><br><p>"+name+"</p></div></body></html>");
		
		
		}
		
		
	}

}
