package com.deviget.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BSN_LandingPage {
	
	public boolean passed = false;
	WebDriver driver;
	By searchBox = By.id("search-key");
	By popUp = By.className("ui-window ui-window-normal ui-window-transition ui-newuser-layer-dialog");
	By popUpCloseButton = By.className("close-layer");
	
	public BSN_LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void closePopupIfPresent()
	{
		try 
		{
			driver.findElement(popUp).isDisplayed();
			driver.findElement(popUpCloseButton).click();
			passed = true;
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("First time user popup was not displayed this is ok, as sometimes aliexpress deactivates the popup: " + e.getMessage());
			passed = true;
		}
		
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
