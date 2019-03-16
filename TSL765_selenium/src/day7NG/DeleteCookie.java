package day7NG;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import util.Base;

public class DeleteCookie extends Base {
 
	Actions action;
	@Test
  public void f() {
		action=new Actions(driver);

	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:8927019648916366274::NO:::");
	  
	  driver.findElement(By.id("P11_USERNAME")).sendKeys("sys");
	  driver.findElement(By.id("P11_PASSWORD")).sendKeys("Newuser123");
	  action.moveToElement(driver.findElement(By.cssSelector("input[value='Login']"))).click().perform();

	  if(driver.getTitle().equals("Oracle"))
	  {
		  Set<Cookie> allCookie=driver.manage().getCookies();
		  for(Cookie C:allCookie)
		  {
			  System.out.println("Cookie name is:"+C.getName());
			  System.out.println("Cookie Domain is:"+C.getDomain());
			  System.out.println("Cookie Expiry is"+C.getExpiry());
			  System.out.println("Cookie value is:"+C.getValue());
			  System.out.println("Cookie Path is"+C.getPath());
			  
		  }
		  driver.manage().deleteAllCookies();
		  System.out.println("Cookies Deleted");
		  Set<Cookie> allCookie2=driver.manage().getCookies();
		  System.out.println("Hi");
		  System.out.println(allCookie2.size());
		  for(Cookie C:allCookie2)
		  {
			  System.out.println("After logout");
			  System.out.println("Cookie name is:"+C.getName());
			  System.out.println("Cookie Domain is:"+C.getDomain());
			  System.out.println("Cookie Expiry is"+C.getExpiry());
			  System.out.println("Cookie value is:"+C.getValue());
			  System.out.println("Cookie Path is"+C.getPath());
			  
		  }
		  driver.findElement(By.linkText("SQL")).click();
		  driver.navigate().refresh();
		  
	  }
		  else
		  {
			  System.out.println("login failed");
		  }
  }
	  
  
}
