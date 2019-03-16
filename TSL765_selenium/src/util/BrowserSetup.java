package util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class BrowserSetup {
	static WebDriver driver=null;
	
	public static WebDriver browserStart(String name) 
	{
		
	
		
          if(name.equalsIgnoreCase("chrome"))
		{
        	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
         	driver=new ChromeDriver();
		}
          else if(name.equalsIgnoreCase("firefox"))
      	{
        	  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
        	  driver=new FirefoxDriver();
		}
      	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      	return driver;
		
}
	
	public static WebDriver browserStart(String name,String url) 
	{
		
		 driver=browserStart(name);
	      driver.get(url);
      	return driver;
      	
		
}
	public static void getScreenShot(String name)
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
	        File src=screen.getScreenshotAs(OutputType.FILE);
	        
	        try {
				FileHandler.copy(src, new File(".\\"+name+".png"));
			} catch (Exception e) {
				System.out.println("ERROR");
				// TODO: handle exception
			}
	      
	}
}