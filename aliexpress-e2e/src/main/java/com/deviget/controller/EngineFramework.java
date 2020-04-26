package com.deviget.controller;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EngineFramework {
	
	public WebDriver driver;
	public String baseURL;
	public String browser;
	public String defect;
	public boolean passed=false;
    String pathConfigFile;
    int intDefaultTimeOut = 30;
        
    Properties prop = new Properties();
    
    public EngineFramework(WebDriver driver, String pathConfigFile)
    {
    	this.driver = driver;
    	this.pathConfigFile = pathConfigFile;
    }
    
    public void RunEngine()
    {
    	this.passed = false;
    	this.defect = "Initializing engine";
    	if(pathConfigFile.isEmpty())
    	{
    		this.defect = "Configuration file is empty, blank or null";
    		System.out.println("pathconfigFile is empty");
    		return;
       	}
    	
    	if (!ReadParametersFile(pathConfigFile))
        {
       	    System.out.println("File was not found at: "+ pathConfigFile);
            return;
        }
    	
    }
    
	boolean ReadParametersFile(String pathConfigFile)
	{
		
		System.out.println(".........................................ReadPropertiesFile");
		if(verifyFileExist(pathConfigFile))
		{
			this.passed = false;
			return false;
		}
		baseURL = prop.getProperty("baseUrl");
		browser = prop.getProperty("browser").trim();
		return true;	
		
	}
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Helper methods
	private boolean verifyFileExist(String pathConfigFile) {
		try{
			prop.load(new FileInputStream(pathConfigFile));
			this.passed = true;
			return true;
		}
		catch(IOException ex){
			this.passed = false;
			this.defect = ex.getMessage();
			return false;
		}
		
	}
    
    
    
    
    

}
