package day3;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.BrowserSetup;

public class Assignment {
	
	public static void main(String[] args) 
	{
	     
		WebDriver driver=BrowserSetup. browserStart("chrome","https://nseindia.com/");
		Actions action=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("keyword")).sendKeys("Reliance Industries Limited");
		driver.findElement(By.xpath("//*[text()='Reliance Industries Limited']")).click();
		

		TakesScreenshot screen=(TakesScreenshot)driver;
        File src=screen.getScreenshotAs(OutputType.FILE);
        
        try {
		
			FileHandler.copy(src,new File(".\\screen.png"));
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
        }
        
        String faceV=driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
        System.out.println("Face value is"+faceV);
        String high52=driver.findElement(By.xpath("//*[@id='high52']/font")).getText();
        System.out.println("Face value is"+high52);
        String low52=driver.findElement(By.xpath("//*[@id='low52']/font")).getText();
        System.out.println("Face value is"+low52);
        
	}
}
	

//action.sendKeys(driver.findElement(By.id("keyword")),Keys.ENTER);