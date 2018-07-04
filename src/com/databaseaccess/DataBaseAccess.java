package com.databaseaccess;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataBaseAccess {

	MysqlDataSource mysqlDB = null;
	public MysqlDataSource getConnection() {
		mysqlDB = new MysqlDataSource(); 
		mysqlDB.setURL("jdbc:mysql://localhost:3306?");
		mysqlDB.setUser("root");
		mysqlDB.setPassword("root");
		
		return mysqlDB;
	}
	
}
