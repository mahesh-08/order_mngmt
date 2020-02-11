package com.novogold.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn=null;
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/novogold";
	private static String user="root";
	private static String password="root";
	
	private DBConnection() {
		
	}
	
	public static Connection getconnection() {
		if(conn==null) {
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else
			return conn;
		
	}
	
}
