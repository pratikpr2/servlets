package com.bridgelabz.servlets.repositories;

import javax.sql.DataSource;

public class ConnectToDatabase implements DAOConnect {
	DataSource ds = null;
		@Override
		public DataSource getConnection() {
			// TODO Auto-generated method stub
			ds =DatabaseConnectionFactory.getMysqlConnection();
			if(ds!=null) {
				System.out.println("Connection Established");
			}
			else
				System.out.println("Could Not Connect");
			
			return ds;
	}
}


