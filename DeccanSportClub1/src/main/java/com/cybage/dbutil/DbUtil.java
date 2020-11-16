package com.cybage.dbutil;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {

	public static String dbURL;
	public static String dbUser ;
	public static String dbPassword ;
	static {
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();			
			InputStream is = classloader.getResourceAsStream("app.properties");

			Properties props = new Properties();
			props.load(is);
			dbURL = props.getProperty("dbURL");
			dbUser = props.getProperty("dbUser");
			dbPassword = props.getProperty("dbPassword");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	//with connection pool
	public static Connection getConnection() throws Exception{
		Connection con = getDataSource().getConnection();
		return con;
	}

	private static BasicDataSource getDataSource()
	{        
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(dbURL);
		ds.setUsername(dbUser);
		ds.setPassword(dbPassword);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100); 
		return ds;
	}
}

