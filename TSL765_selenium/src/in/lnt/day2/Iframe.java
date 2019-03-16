package in.lnt.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.BrowserSetup;

public class Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=BrowserSetup. browserStart("chrome","file:///C:/Users/vshadmin/Desktop/frame.html");
		
		//driver.switchTo().frame(0);
		//driver.findElement(By.name("q")).sendKeys("LNT");
		
		
		driver.switchTo().frame(driver.findElement(By.id("bing")));
		driver.findElement(By.name("q")).sendKeys("LNT");
	
		driver.switchTo().defaultContent();
		driver.switchTo().frame("new");
		driver.findElement(By.name("userName")).sendKeys("123");
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[3]")));
		driver.findElement(By.name("p_t01")).sendKeys("sys");
		
	}

}
