package com.deviget.test;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.deviget.master.TestDriver;
import com.deviget.pageobjects.BSN_LandingPage;

public class TSD_ValidateIphoneAd extends TestDriver {
	
	
	@Test
	public void ValidateIphoneAdTest()
	{
		BSN_LandingPage landing = new BSN_LandingPage(driver);
	
		try 
		{
			landing.setSearch("iphone");
		}catch(Exception e)
		{
		    e.printStackTrace();
		}
		assertEquals(landing.passed, true);
		
	}
	
	

}
