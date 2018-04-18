package com.log4uj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTours
{

	public static Logger logger = Logger.getLogger("NewTours");
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("Log4j.properties");
		
		FirefoxDriver driver = new FirefoxDriver();
		logger.info("Firefox Browser Opened Successfully");
		
		driver.get("http://facebook.com");
		logger.info("Successfully navigate to Facebook HomePage");
		
		driver.findElement(By.id("email")).sendKeys("Hello");
		logger.info("Entered Valid Email Id into Email Element");
		
		
		driver.close();
		logger.info("Application Closed");
		

	}

}
