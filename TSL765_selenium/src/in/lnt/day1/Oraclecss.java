package in.lnt.day1;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Oraclecss {
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/");//url must star with http
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username and Password");

		String username=sc.next();
		String password=sc.next();
		driver.findElement(By.cssSelector("input#P11_USERNAME")).clear();
		driver.findElement(By.cssSelector("input#P11_USERNAME")).sendKeys(username);;
		driver.findElement(By.cssSelector("input[type='password']")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);;
				driver.findElement(By.cssSelector("input[value='Login']")).click();
				
				if(driver.getTitle().equals("Oracle"))
				{
					driver.findElement(By.cssSelector("img[title='Logout']")).click();
					driver.findElement(By.cssSelector("a.htmldbinstruct")).click();
					System.out.println("login done ");
				}
				else
				{
					System.out.println("login failed ");
				}
}
}
