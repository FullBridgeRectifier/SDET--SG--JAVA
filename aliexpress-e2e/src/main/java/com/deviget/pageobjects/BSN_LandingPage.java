package com.deviget.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class BSN_LandingPage {
	
	public boolean passed = false;
	WebDriver driver;
	By searchBox = By.id("search-key");
	By popUp = By.cssSelector("div[data-widget-cid='widget-21']");
	By popUpCloseButton = By.className("close-layer");
	By searchButton = By.className("search-button");
	By popUpInternalPages = By.className("newuser-container");
	By popUpCloseButtonInternalPages = By.className("next-dialog-close");
	
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
	
	public void clickSearch()
	{
		try 
		{
			driver.findElement(searchButton).click();	
			passed = true;
			 //Verify if page displayed popup after redirection
				   try
				   {
					   driver.findElement(popUpInternalPages).isDisplayed();
					   driver.findElement(popUpCloseButtonInternalPages).click();
					   
				   }
				   catch(NoSuchElementException e)
				   {
					   System.out.println("Popup was not shown, this is ok: " + e.getMessage());
				   }
		   
		}
		catch(Exception e) {
			System.out.println("Could not send click the search button, trace: " + e.getMessage());
		}
	}
	
}
