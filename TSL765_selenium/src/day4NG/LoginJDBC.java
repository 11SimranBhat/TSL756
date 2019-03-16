package day4NG;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginJDBC {
	Connection conn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	}
	
	 public LoginJDBC() throws SQLException
	{
		 
			java.sql.Statement st= conn.createStatement();
			ResultSet rs = st.executeQuery("select * from Login");
			if(rs.next()) 
			{
				
			}
	};
}
