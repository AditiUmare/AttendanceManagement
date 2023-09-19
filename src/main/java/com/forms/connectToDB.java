package com.forms;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectToDB {
	public static Connection getConnection() throws Exception
	{
		Connection con = null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "mysql");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return con;
		
	}

}
