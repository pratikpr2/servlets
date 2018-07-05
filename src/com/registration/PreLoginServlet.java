package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.registration.utility.RegistrationUtility;
/**
 * Servlet implementation class PreLoginServlet
 */

public class PreLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String name = request.getParameter("email");
		String pwd = request.getParameter("password");
		
		if(RegistrationUtility.validate(name,pwd)) {
		
			//System.out.println(userName);
			Cookie ck = new Cookie("name", name);
			response.addCookie(ck);
			//RequestDispatcher dispatch = request.getRequestDispatcher("Profile.jsp");
			//dispatch.forward(request, response);
			response.sendRedirect("profile");
			//out.println("Valid user!");
			
		}
		else {
			
			
			RequestDispatcher dispatch = request.getRequestDispatcher("/Home.jsp");
			dispatch.include(request, response);
			out.println("<html><div align='center'><p>Wrong UserName/Password<p></div></footer></html>");
		}
		
	}

}
