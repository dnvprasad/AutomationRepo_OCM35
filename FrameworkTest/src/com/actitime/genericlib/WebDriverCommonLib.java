package com.actitime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Prasad
 *
 */

public class WebDriverCommonLib {

/**
 * Used to wait for page to load in GUI
 * return : void
 * @param element
 */
	public void waitForPagetoLoad()
	{
	Browser.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	
/**
 * Used to wait for element present in the GUI
 * @Param element	
 */
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(Browser.driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
/** 
 * Custom wait for element present in GUI
 * @param element
 * @throws Throwable 
 */
	public void waitForElementinGUI(WebElement element) throws Throwable
	{
		int count=0;
		while(count<=20)
		{
			try
			{
				element.isEnabled();
				break;
			}
			catch(Exception ex)
			{
				Thread.sleep(3000);
				count++;
			}
		}
	}
	
	/**
	 * Select the value from the dropdown based on text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel =new Select(element);
		sel.selectByVisibleText(text);
	}
	
/**
 * Select the value from the dropdown based on index
 * @param element
 * @param index
 */
public void select(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	}
	
	
}
