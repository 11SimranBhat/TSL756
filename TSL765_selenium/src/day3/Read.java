package day3;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import util.BrowserSetup;


public class Read
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream inFile=new FileInputStream("\\\\Infva06621\\Share Folder\\AutomationTesting\\Book1.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(inFile);
		 XSSFSheet sheet = book.getSheet("Sheet1");
		 
		 WebDriver driver=BrowserSetup.browserStart("chrome","http://127.0.0.1:8080/htmldb/");
		 
		 for(int i=0;i<=sheet.getLastRowNum();i++)
		 {
			 
		 String data=sheet.getRow(i).getCell(0).toString();
		 System.out.println(data);
		 
		 String data2=sheet.getRow(i).getCell(1).toString();
		 System.out.println(" "+data2);
		 
		 driver.findElement(By.id("P11_USERNAME")).sendKeys(data);
		driver.findElement(By.id("P11_PASSWORD")).sendKeys(data2);
		driver.findElement(By.xpath("//*[contains(@type,'BUTTON')]")).click();
			
		driver.findElement(By.linkText("Logout")).click();
		 
		 
		 
		 
		 
		 }
		 
	}
}