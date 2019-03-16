package day4NG;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws SQLException {
	  
	  
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	  Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Newuser123");
	  ResultSet rs=c.createStatement().executeQuery("select * from Login");
	  while(rs.next())
	  {
		  System.out.println(rs.getString(1));
		  System.out.println(rs.getString(2));
	  }
  }
}
