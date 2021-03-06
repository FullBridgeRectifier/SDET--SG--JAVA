package com.deviget.test;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.deviget.master.TestDriver;
import com.deviget.pageobjects.BSN_LandingPage;
import com.deviget.pageobjects.BSN_ProductPage;
import com.deviget.pageobjects.BSN_SearchResults;

public class TSD_ValidateIphoneAd extends TestDriver {
	
	
	@Test
	public void ValidateIphoneAdTestE2E()
	{
		BSN_LandingPage landing = new BSN_LandingPage(driver);
		BSN_SearchResults search = new BSN_SearchResults(driver);
		BSN_ProductPage product = new BSN_ProductPage(driver);
	
		try 
		{
			landing.closePopupIfPresent();
			landing.setSearch("iphone");
			landing.clickSearch();
			search.navigateToSecondPage();
			search.clickItem();
			product.switchToNewTab();
			product.validateStock();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(landing.passed, true);
		assertEquals(search.passed, true);
		assertEquals(product.passed, true);
	}
	
	
///Following tests use the same methods but each step has its own test (this is useful for smoke testing, while the above option can be used for quick regression)
	
	@Test
	public void ValidateLandingPageTest()
	{
		BSN_LandingPage landing = new BSN_LandingPage(driver);
		try 
		{
			landing.closePopupIfPresent();
			landing.setSearch("iphone");
			landing.clickSearch();			
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(landing.passed, true);
	}
	
	@Test
	public void ValidateSearchResultsTest()
	{
		ValidateLandingPageTest();		
		BSN_SearchResults search = new BSN_SearchResults(driver);	
		try 
		{
			search.navigateToSecondPage();
			search.clickItem();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(search.passed, true);
	}
	
	@Test
	public void ValidateProductPageTest()
	{		
		ValidateSearchResultsTest();
		BSN_ProductPage product = new BSN_ProductPage(driver);	
		try 
		{
			product.switchToNewTab();
			product.validateStock();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(product.passed, true);
	}
}
