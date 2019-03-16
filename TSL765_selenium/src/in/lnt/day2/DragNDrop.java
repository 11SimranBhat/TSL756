package in.lnt.day2;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.BrowserSetup;



public class DragNDrop {

	public static void main(String[] args) 
	{
	     
		 WebDriver driver=BrowserSetup. browserStart("firefox","http://jqueryui.com/droppable/");
    	   Actions action=new Actions(driver);
	   
    	   driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
    	   
         WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        action.dragAndDrop(drag, drop).perform();
        BrowserSetup.getScreenShot("jay");
   //TakesScreenshot screen=(TakesScreenshot)driver;
//   File src=screen.getScreenshotAs(OutputType.FILE);
//        
//        try {
//			FileHandler.copy(src, new File(".\\DragNDrop.png"));
//		} catch (Exception e) {
//			System.out.println("ERROR");
//			// TODO: handle exception
//		}
      
     //action.dragAndDrop(drag,drop).perform();
	  
	
		
		
	}

}
