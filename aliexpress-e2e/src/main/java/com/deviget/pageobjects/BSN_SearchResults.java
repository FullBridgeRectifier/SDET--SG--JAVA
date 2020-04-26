package com.deviget.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BSN_SearchResults {
	
	public boolean passed = false;
	WebDriver driver;
	By nextPageButton = By.xpath("//button[@aria-label='Next page, current page 1']");
	By productSelector = By.xpath("//div[@product-index='1']//a[@class='item-title']");
	
	
	public BSN_SearchResults(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void navigateToSecondPage()
	{
		try 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//removing WebElement nextButton = driver.findElement(nextPageButton);
			//did not work js.executeScript("arguments[0].scrollIntoView();", nextButton);
			js.executeScript("window.scrollBy(0,13000)");
			driver.findElement(nextPageButton).click();
			passed = true;
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Could not click the next page button verify stacktrace: " + e.getMessage());
			
		}
		
	}
	
	public void clickItem()
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement elementToBeStale = driver.findElement(productSelector);
			ExpectedCondition<Boolean> cond1 = ExpectedConditions.stalenessOf(elementToBeStale);
			ExpectedCondition<WebElement> cond2 = ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@product-index='1']//a[@class='item-title']"));
			ExpectedCondition<Boolean> cond = ExpectedConditions.and(cond1, cond2);
			wait.until(cond);
			driver.findElement(productSelector).click();
			passed = true;
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Could not click the product or item verify stacktrace: " + e.getMessage());
			
		}
		
	}
	
	
	
	

}
