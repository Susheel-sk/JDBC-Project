package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {
	
	static Connection con;
	
	public static Connection createConn() {
		try {
			  //load driver
			Class.forName("com.mysql.jdbc.Driver");
			//create connection
			String user ="root";
			String password ="Susheel@123";
			String url = "jdbc:mysql://localhost:3306/student_management";
			con=DriverManager.getConnection(url,user,password);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
