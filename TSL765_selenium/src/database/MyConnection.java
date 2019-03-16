package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection
{
	private static Connection connRef; // just a reference , default value is null
	
	private MyConnection() { 
		System.out.println("MyConnection ctor...");
	}
	public static Connection getMyConnection() { // class's function  , and not the object's function
		if(connRef == null) {
			try {
				
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				
				connRef  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connRef;
	}
}