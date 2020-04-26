package com.deviget.test;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.deviget.master.TestDriver;
import com.deviget.pageobjects.BSN_LandingPage;
import com.deviget.pageobjects.BSN_ProductPage;
import com.deviget.pageobjects.BSN_SearchResults;

public class TSD_ValidateIphoneAd extends TestDriver {
	
	
	@Test
	public void ValidateIphoneAdTest()
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
			
		}catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(landing.passed, true);
		assertEquals(search.passed, true);
		assertEquals(product.passed, true);
		
	}
	
	
	
	
	

}
