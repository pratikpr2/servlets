package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static PrintWriter out;
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstname");
		String lastName =  request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String query="insert into servlet.regUsers(firstname,lastname,email,password) values(?,?,?,?)";
		String search = "select email from servlet.regUsers";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(search);
			while(rs.next()) {
				if(rs.getString(1).equals(email)) {
					out=response.getWriter();
					out.println("<html><body bgcolor='pink'><div align='center'><p>User Exists with Same Email Id</p><br><a href='index.html'>Go To Home</a></div></body></html>");
					return;
				}
			}
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, password);
			
			pst.executeUpdate();
			
			out = response.getWriter();
			out.println("<html><body bgcolor='pink'>"+"<h2 align='center'>Welcome</h2><br>"+"<p align='center'>"+firstName+"</p></h1></body></html>");
			out.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
