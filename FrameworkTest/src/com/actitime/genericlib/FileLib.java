package com.actitime.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Prasad
 *
 */
public class FileLib {
/**
 * Read the data from property file based on key
 * @param key
 * @return value of the key
 * @throws Throwable 
 * 	
 */
	public String getPropertyFileData(String Key) throws Throwable {

		
	FileInputStream fis=new FileInputStream("./TestData/common.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	
	String value = pobj.getProperty(Key);
	return value;
	}
	
/**
* Read the data from excel sheet
* @return String Data
* @Throws Throwable
*/
	public String getExcelData(String sheetName,int rownum,int colnum) throws Throwable {

		FileInputStream fis=new FileInputStream("./TestData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(sheetName);
		Row row=sh.getRow(rownum);
		String data=row.getCell(colnum).getStringCellValue();
		return data;		
	}
	
/** 
* Write the data back to Excel sheet
* @return Void
* @Throws Throwable
*/
	public void setExceldata(String sheetName,int rownum,int colnum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row=sh.getRow(rownum);
		Cell cel=row.createCell(colnum);
		cel.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./TestData/TestData.xlsx");
		wb.write(fos);
		wb.close();		
	}
}
	


