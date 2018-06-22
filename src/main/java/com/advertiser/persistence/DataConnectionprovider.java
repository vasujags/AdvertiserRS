package com.advertiser.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataConnectionprovider 
{
	public  Connection getConnection() throws SQLException
	{
		Connection conn = getMysqlDataSource().getConnection();
		return conn;
	}
	
	public  DataSource getMysqlDataSource() {
	    MysqlDataSource dataSource = new MysqlDataSource();

	    // Set dataSource Properties
	    dataSource.setServerName("localhost");
	    dataSource.setPortNumber(3306);
	    dataSource.setDatabaseName("ADVERTISERDB");
	    dataSource.setUser("test");
	    dataSource.setPassword("test1");
	    return dataSource;
	  }
	

}
