package com.deviget.master;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.deviget.controller.*;

public class TestDriver {
	
	protected String strPathConfigFile;
	protected String baseUrl;
	protected WebDriver driver;
	protected EngineFramework engine;
	
	
	//Setup engine is in charge of calling the EngineFramework in order to bring forward the actual browser driver
	@BeforeClass
    public void SetupEngine()
    { 
    	String parametersFile = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\parameters.txt";
        strPathConfigFile = parametersFile;        
        Assert.assertEquals(StartEngine(strPathConfigFile), true);        
    }	
	
	protected boolean StartEngine(String pathConfig)
	{
		engine = new EngineFramework(driver, pathConfig);
		engine.RunEngine();
	
		if(!engine.passed)
		{
			Assert.fail("Engine failed to start");			
		}
		driver = engine.driver;
		baseUrl = engine.baseURL;
		return true;
	}
	
	//Used to end the browser after each test
	@AfterClass
    protected void CloseAllDriver(){

        driver.close();
        driver.quit();
    }
}
