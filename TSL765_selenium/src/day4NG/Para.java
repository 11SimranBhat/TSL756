package day4NG;

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

public class Para {
	Workbook book;
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void Login(String userName, String password) {
	  driver.get("http://127.0.0.1:8080/htmldb");
	  driver.findElement(By.xpath("//*[@type='text']")).sendKeys(userName);
	  driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  driver.findElement(By.linkText("Logout")).click();
	  driver.findElement(By.partialLinkText("Log")).click();
	  }

  @DataProvider
  public Object[][] dp() {
	  
	  Excel excel = new Excel("D:\\abc.xlsx");
	  Object data[][]= new Object[5][2] ;
      
	  for(int i=0;i<excel.rowCount("Sheet1");i++)
	  {
	  data[i][0]=excel.Read("Sheet1",i, 0);
      data[i][1]=excel.Read("Sheet1",i, 1);
	  }
      return data;
       };
  
  @AfterMethod
  public void AfterMethod(ITestResult result)
  {
	  System.out.println(ITestResult.FAILURE);
	  System.out.println(ITestResult.SUCCESS);
	  System.out.println(ITestResult.SKIP);
	  
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  System.out.println("Taking Screenshot");
		  BrowserSetup.getScreenShot(result.getName());
	  }
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