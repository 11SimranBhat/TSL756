package day7NG;

import java.util.Set;
import org.openqa.selenium.Cookie;

import org.testng.annotations.Test;

import util.Base;

public class CookieTest extends Base {
  @Test
  public void Google() {
	  
	  driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:8927019648916366274::NO:::");
	  Set<Cookie> allCookie=driver.manage().getCookies();
	  for(Cookie C:allCookie)
	  {
		  System.out.println("Cookie name is:"+C.getName());
		  System.out.println("Cookie Domain is:"+C.getDomain());
		  System.out.println("Cookie Expiry is"+C.getExpiry());
		  System.out.println("Cookie value is:"+C.getValue());
		  System.out.println("Cookie Path is"+C.getPath());
		  
	  }
	  
  }
}
