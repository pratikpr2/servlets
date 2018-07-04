package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("Profile.jsp").include(request, response);
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		//String query = "Select firstName from servlet.regUsers "
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			st = con.createStatement();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		Cookie[] ck=request.getCookies();
		if(ck!=null) {
			String name = ck[0].getValue();
			System.out.println(name);
			if(!name.equals("")||name!=null) {
				//out.println("<div align='center'><b>Welcome To Profile<b></div>");
				
			}
		}
		else
		{
			out.println("<html><div align='center'><p>Please Login First<p></div></footer></html>");
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		}
	}

}
