package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	private static Connection connection;

	public static Connection establishConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "sanchit", "sanchit");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
