package com.manpcak.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mainpack.qa.Base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	public static String TEST_DATA_SHEET_PATH ="/home/rahul/R&S_Software_Solutions/Rahul_Automation/" +
											"src/main/java/com/mainpack/qa/TestData/FreeCrm_testData.xls";
	
	public static Workbook book;
	public static Sheet sheet;
	public static String sheetName;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		}
		catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}			
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(currentDir+"/screenshot"+System.currentTimeMillis()+".png"));

		/*if(osName.startsWith("Mac"))
		*/
//			FileUtils.copyFile(srcFile, new File(currentDir+"/screenshot"+System.currentTimeMillis()+".png"));
		/*}
		else
		{
			FileUtils.copyFile(srcFile, new File(currentDir+"\\screenshot\\"+System.currentTimeMillis()+".png"));
		*/
	}
	
	
	// all common methods will be created here like 
	// switching to frame
	// taking screenshot
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public void switchToMainContent()
	{
		driver.switchTo().defaultContent();
	}
}
