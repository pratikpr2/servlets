package com.bridgelabz.servlets.repositories;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseConnectionFactory {

	public static DataSource getMysqlConnection() {
		// TODO Auto-generated method stub
		Properties prop =  new Properties();
		FileInputStream file = null;
		MysqlDataSource mysqlDB = null;
		try {
			file = new FileInputStream("/home/bridgelabz/mycodes/register&login/src/com/bridgelabz/servlets/files/datasource.properties");
			prop.load(file);
			mysqlDB = new MysqlDataSource();
			mysqlDB.setUrl(prop.getProperty("MYSQL_DB_URL"));
			mysqlDB.setUser(prop.getProperty("MYSQL_DB_USERNAME"));
			mysqlDB.setPassword(prop.getProperty("MYSQL_DB_PASSWORD"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mysqlDB;
	}

	
}
