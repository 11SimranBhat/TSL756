package day4NG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.BrowserSetup;
import util.Excel;

public class Para2 {
	Connection c;
	Workbook book;
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void Login(String userName, String password){
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(userName);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  
	  try {
		if(driver.getTitle().equals("Oracle"))
		  {
			  System.out.println("success");
			  PreparedStatement ps = c.prepareStatement("update Login set status='success' where uname='"+userName+"'");
		      ps.executeUpdate();
		  }
		  else
		  {
			  System.out.println("failure");
			  PreparedStatement ps = c.prepareStatement("update Login set status='failure' where uname='"+userName+"'");
		      ps.executeUpdate();
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  }

  @DataProvider
  public Object[][] dp() throws Exception{
	  
	  DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
	  c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "Newuser123");
	  ResultSet r2=c.createStatement().executeQuery("select count(*) from Login");
	  r2.next();
	 // System.out.println(r2);
	// Excel excel = new Excel("D:\\abc.xlsx");
	  
	  Object data[][]= new Object[r2.getInt(1)][2] ;
	  int i=0;
	  ResultSet rs=c.createStatement().executeQuery("select * from Login");

	 while(rs.next())
	 {
	  data[i][0]=rs.getString(1);
      data[i][1]=rs.getString(2);
      i++;
	  }
      return data;
       };
  
  @AfterMethod
  public void AfterMethod(ITestResult result) throws SQLException
  {
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
  }

  @BeforeTest
  public void beforeTest() {
	  
	     driver=BrowserSetup.browserStart("chrome");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }
  }
