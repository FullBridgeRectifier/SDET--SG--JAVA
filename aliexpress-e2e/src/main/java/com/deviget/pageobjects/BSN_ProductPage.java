package com.deviget.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BSN_ProductPage {
	
	public boolean passed = false;
	WebDriver driver;
	String strQty;
	By qtyInStock = By.xpath("//div[@class='product-quantity-tip']");
	
	
	
	public BSN_ProductPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void switchToNewTab()
	{
		ArrayList<String> availableTabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(availableTabs.get(1));
	    
	}
	
	public void validateStock()
	{
		strQty = driver.findElement(qtyInStock).getText();
		strQty = strQty.substring(0, 5);
		strQty = strQty.replaceAll("\\D+", "");	
		if(Integer.valueOf(strQty) > 0)
		{
			System.out.println("Item has stock, test was a success, ending test now");
			passed = true;
		}
		
	}
	

}
