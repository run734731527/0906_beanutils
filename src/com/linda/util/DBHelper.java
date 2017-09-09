package com.linda.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

public class DBHelper {
private static DataSource dataSource;
static{
	Properties prop=new Properties();
	InputStream in=DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties");
	try {
		prop.load(in);
		try {
			dataSource=BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static Connection getConnection(){
	try {
		return dataSource.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new ExceptionInInitializerError(e);
	}
}
public static DataSource getDataSource(){
	return dataSource;
}
}
