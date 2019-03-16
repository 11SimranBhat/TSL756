package day7NG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import util.Base;

public class alertExample extends Base {
  @Test
  public void alertTest() throws InterruptedException {
	 
	  //magneticautomation link 
	  driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
	  //on clickDate element by inspect rightclick copy and enter outerhtml
	  driver.findElement(By.xpath("//button[@onclick='myFunction1()']")).click();
	  //it opens the window in the alert msg box
	  Alert a=driver.switchTo().alert();
	  //for showing it on console
	  String txt=a.getText();
	  System.out.println("txt");
	  Thread.sleep(3000);
	  //it is used for Ok button
	  a.accept();
	  Thread.sleep(4000);
	  
	  driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	  Alert a2=driver.switchTo().alert();
	  String txt1=a2.getText();
	  System.out.println("txt1");
	  a2.sendKeys("John");
	  Thread.sleep(3000);
	  a2.accept();
	  Thread.sleep(4000);
	  
	  
  }
}
