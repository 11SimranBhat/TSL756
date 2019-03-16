package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Script1 {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver is a interface .
		// Example : FirefoxDriver, ChromeDriver, OperaDriver which implements WebDriver.
	//	FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.gecko.driver","C:\\Users\\vshadmin\\Desktop\\Varsha Diksha\\Jars\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
      // here no need to call the child specific  functions...S
		driver.get("https://www.seleniumhq.org/");//url must star with http
		driver.findElement(By.linkText("Download")).click();
		String title = driver.getTitle();

	System.out.println("I am on "+title+" page");
	driver.findElement(By.name("q")).sendKeys("LNT");
	Thread.sleep(3000);//throws declaratin
	driver.quit();//for closing browser
	}

}
