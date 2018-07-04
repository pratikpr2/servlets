package com.registration.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationUtility {

	static String name;
	static String password;
	static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
	
	public static boolean validate(String user,String pwd) {
		// TODO Auto-generated method stub
		name = user;
		password = pwd;
		boolean b = false;
		con = null;
		pst = null;
		rs = null;
		String query="Select email from servlet.regUsers where email=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			rs = pst.executeQuery();

			while(rs.next()) {
				if(rs.getString(1).equals(user)) {
					b= true;
				}
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}return b;
	
	}
}
