import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import util.BrowserSetup;

public class Assignment2 {
	public static void main(String[] args) throws Exception
	{
		FileInputStream inFile=new FileInputStream("\\\\Infva06621\\Share Folder\\AutomationTesting\\data.xls");
		HSSFWorkbook book=new HSSFWorkbook(inFile);
		 HSSFSheet sheet = book.getSheet("Sheet1");
		 
		WebDriver driver=BrowserSetup. browserStart("chrome","https://nseindia.com/");
		Actions action=new Actions(driver);
		
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			 String Keyword=sheet.getRow(i).getCell(0).toString();
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		driver.findElement(By.id("keyword")).sendKeys(Keyword);
		System.out.println("Xpath is>>> "+"//*[text()='"+Keyword+"']");
		WebElement E=driver.findElement(By.xpath("//*[contains(text(),'"+Keyword+"']"));
		action.moveToElement(E).click(E).perform();
		String faceV=driver.findElement(By.xpath("//span[@id='faceValue']")).getText();
		System.out.println("Face value is "+faceV);
		
		BrowserSetup.getScreenShot("abcdd");
		
		}
	/*	TakesScreenshot screen=(TakesScreenshot)driver;
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
	*/
 }
}	



