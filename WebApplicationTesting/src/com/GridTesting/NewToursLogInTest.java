package com.GridTesting ;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewToursLogInTest
{

	@Parameters("Browser")
	
	@Test
	public void LogIn(String b) throws MalformedURLException
	{
		
		// Nodes 
		System.out.println(b);
		
		DesiredCapabilities cap= null;
		
		if(b.equals("firefox"))
		{
			
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			
		}
		else
			if(b.equals("chrome"))
			{
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}
		
		
		                                                                     // HuB             //Node
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),cap);
		
		
		driver.get("http://newtours.demoaut.com");
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String expected_title = "Find";
		String actual_title=driver.getTitle();
		
		System.out.println(expected_title);
		System.out.println(actual_title);
		
		//Assert.assertEquals(actual_title, expected_title);
		
		Assert.assertTrue(actual_title.contains(expected_title), "Title not Matched");
		
		
		driver.close();
		
		
	}
	
	
	
}
