package com.bridgelabz.servlets.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.bridgelabz.servlets.model.User;
import com.bridgelabz.servlets.repositories.ConnectToDatabase;

public class ServletServices implements Services {
	DataSource ds;
	@Override
	public User getUser(String email,String password) {
		String name = email;
		String pwd = password;
		User user = new User();
		ConnectToDatabase connect = new ConnectToDatabase();
		ds = connect.getConnection();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select * from servlet.regUsers where email=? and password=?";
		try {
			con=ds.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, pwd);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				user.setFirstName(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				
				if(rs!=null) {
					try {
						rs.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if(pst!=null) {
					try {
						pst.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
				return user;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		// TODO Auto-generated method stub
		
	}

	public boolean validateUser(String name) {
		// TODO Auto-generated method stub
		ConnectToDatabase connect = new ConnectToDatabase();
		ds = connect.getConnection();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query="select email from servlet.regUsers";
		try {
			con = ds.getConnection();
			st = con.createStatement();
			rs =st.executeQuery(query);
			while(rs.next()) {
				if(rs.getString(1).equals(name)) {
					
					if(rs!=null) {
						try {
							rs.close();
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					if(st!=null) {
						try {
							st.close();
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					if(con!=null) {
						try {
							con.close();
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					
					return true;
				
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(rs!=null) {
			try {
				rs.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public void regUser(User user) {
		// TODO Auto-generated method stub
		ConnectToDatabase connect = new ConnectToDatabase();
		ds = connect.getConnection();
		Connection con = null;
		PreparedStatement pst = null;
		String query = "insert into servlet.regUsers(firstname,lastname,email,password) values(?,?,?,?)";
		
		try {
			con = ds.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, user.getFirstName());
			pst.setString(2, user.getLastname());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			
			pst.executeUpdate();
			
			System.out.println("User Registered");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(pst!=null) {
			try {
				pst.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
}
