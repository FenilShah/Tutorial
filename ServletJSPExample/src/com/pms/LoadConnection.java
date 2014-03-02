package com.pms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoadConnection {
	private static Connection conn = null;
	private static void loadDriver(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		loadDriver();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodcartdb","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
