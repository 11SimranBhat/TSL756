package Day7Junit;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.BrowserSetup;

public class LinkImagesTest {
	
	static WebDriver driver;
	//it is a static method
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver=BrowserSetup.browserStart("chrome");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void test()throws Exception {
		
		driver.get("http://google.com");
		//alllinks will have all the element with a and img 
		List<WebElement>alllinks=driver.findElements(By.xpath("//a"));
		alllinks.addAll(driver.findElements(By.tagName("img")));
		for(WebElement E:alllinks)
		{
			String url=E.getAttribute("href");
			//called the urlTest function
			urlTest(url);
		}
	}

	public void urlTest(String url) throws Exception
	{
		URL u=new URL(url);
		URLConnection C=u.openConnection();
		HttpsURLConnection HC=(HttpsURLConnection)C;
		HC.connect();
		
		int code=HC.getResponseCode();
		if(code==200)
		{
			System.out.println(url+"Working");
		}
		else
		{
			System.out.println(url+"NotWorking");
		}
	}
}
