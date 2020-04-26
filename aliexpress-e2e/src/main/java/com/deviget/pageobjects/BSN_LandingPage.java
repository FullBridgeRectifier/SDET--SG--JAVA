package com.deviget.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BSN_LandingPage {
	
	public boolean passed = false;
	WebDriver driver;
	By searchBox = By.id("search-key");
	
	public BSN_LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void setSearch(String searchItem) 
	{
		try 
		{
			driver.findElement(searchBox).sendKeys(searchItem);	
			passed = true;
		}
		catch(Exception e) {
			System.out.println("Could not send the text to the search box, trace: " + e.getMessage());
		}
		
		
	}
	
}
