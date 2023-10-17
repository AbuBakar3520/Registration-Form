package com.connection.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.jsp.tagext.TryCatchFinally;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abu", "root", "root");
			System.out.println("connection is created");
		} catch (Exception e) {
          e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	
}
