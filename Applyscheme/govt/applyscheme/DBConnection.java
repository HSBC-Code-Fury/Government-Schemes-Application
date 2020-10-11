package com.govt.applyscheme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?characterEncoding=latin1&useConfigs=maxPerformance","root","abcd1234");  

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void closeConneciton() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}