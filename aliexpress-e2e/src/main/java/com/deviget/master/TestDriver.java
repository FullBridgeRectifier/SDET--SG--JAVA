package com.deviget.master;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.deviget.controller.*;

public class TestDriver {
	
	protected String strPathConfigFile;
	protected WebDriver driver;
	protected EngineFramework engine;
	
	
	
	@BeforeClass
    public void SetupEngine()
    { 
    	String parametersFile = new File(System.getProperty("user.dir")).getAbsolutePath() + "/Parameters.txt";
        strPathConfigFile = parametersFile;        
        Assert.assertEquals(StartEngine(strPathConfigFile), true);        
    }	
	
	protected boolean StartEngine(String pathConfig)
	{
		engine = EngineFramework(driver, pathConfig);
		
	}
	
	
	
	

}
