package com.bridgelabz.servlets.repositories;

import javax.sql.DataSource;

public interface DAOConnect {

	public DataSource getConnection();
	
}
