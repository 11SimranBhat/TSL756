package in.lnt.day1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeForm {
	public static void main(String [] args) 
	{
				
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.blazedemo.com/");
		
		Select select=new Select(driver.findElement(By.name("fromPort")));
		//select.selectByVisibleText("Portland");
		//select.selectByIndex(6);
		select.selectByValue("Boston");
		System.out.println(driver.findElement(By.name("fromPort")).getText());
		List<WebElement> ls=	select.getOptions();
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(ls.get(i).getText());
		}
		new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
		driver.findElement(By.cssSelector("input[value='Find Flights']")).click();
		driver.findElement(By.cssSelector("input[value='Choose This Flight']")).click();

/*List<WebElement> all=driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
all.get(4).click();	*/	
		driver.findElement(By.cssSelector("input#inputName")).sendKeys("Arjun");
		driver.findElement(By.cssSelector("input[name='address']")).sendKeys("Ghansoli");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Delhi");
		driver.findElement(By.cssSelector("input[name='zipCode']")).sendKeys("110031");
		new Select(driver.findElement(By.name("cardType"))).selectByVisibleText("American Express");
		driver.findElement(By.cssSelector("input[name='creditCardNumber']")).sendKeys("123456789");
		driver.findElement(By.cssSelector("input[name='creditCardMonth']")).sendKeys("10");
		driver.findElement(By.cssSelector("input[name='creditCardYear']")).sendKeys("2019");
		driver.findElement(By.cssSelector("input[name='nameOnCard']")).sendKeys("Arjun Sisodia");
	
		WebElement E=driver.findElement(By.id("rememberMe"));
		boolean isselected=E.isSelected();
		if(isselected==true)
		{
			driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		}
		else
		{
			driver.findElement(By.id("rememberMe")).click();
			driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
		}
	
	}
}
