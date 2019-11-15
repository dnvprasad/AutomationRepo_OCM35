package com.actitime.genericlib;
/**
 * @author Prasad
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
/**
 * Launch the browser based on Property file Key
 * @throws Throwable 
 */
	public static void launchBrowser() throws Throwable
	{
		
/* Create an Object to the FileLib class to read the Browser data from properties file*/
		
		FileLib flib=new FileLib();
		String BROWSER=flib.getPropertyFileData("Browser");
		
		/*Launch the Browser*/
		if(BROWSER.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		
	}
	/**
	 * Close the Browser
	 */
	public static void closeBrowser()
	{
		driver.close();
	}

}


