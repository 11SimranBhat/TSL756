package day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write
{
	public static void main(String args[]) throws Exception
	{
		FileInputStream inFile=new FileInputStream("\\\\Infva06621\\Share Folder\\AutomationTesting\\Book1.xlsx");
		XSSFWorkbook book=new XSSFWorkbook(inFile);
		 XSSFSheet sheet = book.getSheet("Sheet1");
		 
		//sheet.getRow(2).getCell(1).setCellValue("manali");
		// sheet.getRow(0).getCell(2).setCellValue("LNT");
		sheet.createRow(4).createCell(2).setCellValue("apurva");
		 
		 FileOutputStream op=new FileOutputStream("D:\\Book1.xlsx");	
		 book.write(op);
	}
}
