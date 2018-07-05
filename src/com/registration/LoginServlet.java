package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String query = "select firstName from servlet.regUsers where email=? and password = ?";
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				String user = rs.getString(1);
				RequestDispatcher dispatch=request.getRequestDispatcher("Profile.jsp");
			}
			else
				out.println("<html><body><head><body>\n" + 
						"<div align=\"center\">\n" + 
						"<img src=\"google.jpg\" alt=\"Image Logo\" width=\"160em\" height=\"100\">\n" + 
						"</div></head><h2 align='center'>Invalid User</h2><p align ='center'>Please Register</p></body></html>");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
