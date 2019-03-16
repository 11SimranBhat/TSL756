package in.lnt.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPoints {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb/f?p=4550:11:8927019648916366274::NO:::");
		WebElement E=driver.findElement(By.id("P11_USERNAME"));
		
		boolean isdisplayed=E.isDisplayed();
		boolean isenabled=E.isEnabled();
		boolean isselected=E.isSelected();
		
		String sz=E.getAttribute("size");
		String typ=E.getAttribute("type");
		
		if(isdisplayed==true && isenabled==true && sz.equals("30") && typ.equals("text"))
				System.out.println("Test for UserName is pass ");
				else
					System.out.println("test for username is failed");
	}
}
