package com.instagram.generic;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * This class provides all the utility methods of the automation framework
 * @author SK MOHAMMUD NASIB
 *
 */
public class FrameWorkUtility {




	/**
	 * This method is used to get the Data from the Excel Sheet
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return String
	 */
	public static String getXLData(String path,String sheet,int row,int cell)
	{
		String v= null;
		try
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wk = WorkbookFactory.create(fis);	
			v=wk.getSheet(sheet).getRow(row).getCell(cell).toString();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}


	public static void setXLData(String path,String sheet,int row,int cell,String value)
	{
		try
		{
			Workbook wk = WorkbookFactory.create(new FileInputStream(path));
			Sheet sh = wk.getSheet(sheet);
			Row r=null;
			if(sh!=null)
			{
				r=sh.getRow(row);
			}

			if(r==null)
			{
				r=sh.createRow(row);
			}
			Cell c = r.getCell(cell);
			if(c==null)
			{
				c=r.createCell(cell);
			}
			c.setCellValue(value);	
			FileOutputStream fos=new FileOutputStream(path);
			wk.write(fos);
			fos.close();
			wk.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	


	public static int getLastRowNumberInExcel(String path,String sheet)
	{
		//			It will provide the last number till where the data is stored in the excel sheet
		int value=0;
		try
		{
			Workbook wk = WorkbookFactory.create(new FileInputStream(path));
			Sheet sh = wk.getSheet(sheet);
			value=sh.getLastRowNum();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return value;

	}

	
	

	public static void verifyMSG(String actual, String expected_title)
	{
		Assert.assertEquals(actual, expected_title);
	
	}

	//		Java script executor
	public static void scrollBarJavaScript(WebElement till, WebDriver driver) {
		Point p = till.getLocation();
		int x=p.getX();
		int y=p.getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy("+x+","+y+")");

	}
public static void WaitForTitle(WebDriver driver, String str) {
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.titleContains(str));
	
}
	


}
