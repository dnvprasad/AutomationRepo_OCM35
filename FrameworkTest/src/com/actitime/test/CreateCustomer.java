package com.actitime.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actitime.genericlib.Browser;
import com.actitime.genericlib.FileLib;
import com.actitime.genericlib.WebDriverCommonLib;
/**
 * 
 * @author Prasad
 *
 */

public class CreateCustomer extends Browser{

	@Test
	public  void ceraateCustomerTest() throws Throwable   {
	
		/*read the data from common file & Test Script data from external resources*/
				 
		FileLib flib=new FileLib();
		WebDriverCommonLib wlib=new WebDriverCommonLib();
		
		String URL=flib.getPropertyFileData("url");
		String UName=flib.getPropertyFileData("UserName");
		String PASSWORD=flib.getPropertyFileData("Password");
		String CName=flib.getExcelData("Sheet1", 1, 2);
		
		/*Step 1 : Launching Browser*/
		launchBrowser();
		/*Step 2 : Login to the Application*/
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(UName);
		driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		/* Navigate to Task */
		driver.findElement(By.xpath("//div[text()='TASKS']")).click();
		Thread.sleep(2000);
		/* Navigate to the Customer&Project*/
		driver.findElement(By.linkText("Projects & Customers")).click();
		Thread.sleep(2000);
		/* Click on Create Customer*/
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		/* Enter data in the field Customer Name*/
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(CName);
		Thread.sleep(3000);
		/*Click on Create Customer Button*/
		driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		Thread.sleep(3000);
		/*Verify CustomerName*/
		String ExpResult= driver.findElement(By.xpath("//span[contains(text(),'SBI_001')]")).getText();
		
		if(ExpResult.equals(CName))
		{
			System.out.println("CustomerName is Verified==PASS");
		}
		else
		{
			System.out.println("CustomerName is not Verified==FAILED");
		}
		Thread.sleep(2000); 		
		/*Close the Browse*/
		closeBrowser();
		

	}

}
