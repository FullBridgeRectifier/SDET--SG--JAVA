package com.deviget.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BSN_LandingPage {
	
	WebDriver driver;
	By searchBox = By.id("search-key");
	
	public BSN_LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void setSearch(String searchItem) 
	{
		driver.findElement(searchBox).sendKeys(searchItem);
		
	}
	
}
