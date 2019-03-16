package in.lnt.day2;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;



public class Google {

	public static void main(String[] args) 
	{
	     
		WebDriver driver=BrowserSetup. browserStart("firefox","https://www.seleniumhq.org/");
String ParentId= driver.getWindowHandle();

List<WebElement> ls= driver.findElements(By.xpath("/html/body/div[3]/div[1]/ul/li"));
	  System.out.println(ls.size());
	  for( WebElement E:ls) {
		  new Actions(driver).keyDown(Keys.CONTROL).click(E).keyUp(Keys.CONTROL).perform();
	  }
		
		
		
//		Actions action=new Actions(driver);
//      WebElement search=driver.findElement(By.linkText("Download"));
//      Action a1= action.keyDown(Keys.CONTROL).click(search).build();
//      WebElement search1=driver.findElement(By.linkText("Documentation"));
//      Action a2= action.click(search1).build();
////      Action a=action.moveToElement(search).keyDown(Keys.SHIFT).sendKeys(search,"lnt").keyUp(Keys.SHIFT).doubleClick(search).contextClick(search)
////     // sendKeys(search,Keys.ENTER)
////      .build();
//      a1.perform();
//      a2.perform();
//      
      
	Set<String> allWin= driver.getWindowHandles();
	Iterator<String> itr = allWin.iterator();
		while(itr.hasNext()) {
			String Id=itr.next();
			System.out.println(Id);
			if(!(Id.equals(ParentId))) {
				driver.switchTo().window(Id);
				System.out.println("you are on:"+driver.getTitle());
				driver.close();
			}
		}
		
	}

}
