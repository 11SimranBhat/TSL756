package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Database {

	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/");//url must star with http
		String title = driver.getTitle();
		
		System.out.println("I am on "+title+" page");

		driver.findElement(By.name("p_t01")).sendKeys("sys");
		driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
		driver.findElement(By.xpath("//*[@id=\"wwvFlowForm\"]/div[6]/table/tbody/tr/td[3]/table[2]/tbody/tr/td/input[1]")).click();
		driver.findElement(By.xpath("/html/body/form/a[4]/img")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
