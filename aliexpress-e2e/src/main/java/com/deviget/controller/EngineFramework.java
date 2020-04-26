package com.deviget.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
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
    	//Quick verification of the path for the file
    	if(pathConfigFile.isEmpty())
    	{
    		this.defect = "Configuration file is empty, blank or null";
    		System.out.println("pathconfigFile is empty");
    		return;
       	}
    	//Actually reading the parameter file
    	if (!ReadParametersFile(pathConfigFile))
        {
       	    System.out.println("File was not found at: "+ pathConfigFile);
            return;
        }
    	//Setting up the browser
    	if(!)
    	
    	
    	
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
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------Helper methods-----------------------------------------\\
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
	
	 boolean SetupBrowser(String strBrowser,String strPathServer) 
	  {
	      if (strBrowser.toUpperCase().equals("CHROME"))
	      {	          
	          if (!SetupChrome(strPathServer)) return false;
	      }	      
	      return true;
	  }
	 
	  boolean SetupChrome(String pathChrome)
	  {
	      try
	         {   
		    	  String chromeSetup = new File(System.getProperty("user.dir")).getAbsolutePath() + "/libs/Selenium_Common/chromedriver.exe";	       
			      System.setProperty("webdriver.chrome.driver", chromeSetup);	    		
			      driver = new ChromeDriver();
		      }
	      catch (Exception ex)
		      {
		          this.defect = ex.getMessage();;
		          return false;
		      }
	      return true;
	      
	  }	 
    
    
    
    
    

}
