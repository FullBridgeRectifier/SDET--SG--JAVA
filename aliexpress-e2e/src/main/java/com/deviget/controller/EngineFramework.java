package com.deviget.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
    	if(!SetupBrowser(browser))
    	{
    		System.out.println("Error while fetching and enabling the browser driver");
            return;
    	}
    	//Actually opening the page.
    	if (!OpenApplication())
        {
       	 System.out.println("Error on OpenApplication (URL)");
   	         return ;
        }        
        this.passed = true;
    	
    	
    	
    }
    
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------------------------------Helper methods-----------------------------------------\\
    boolean ReadParametersFile(String pathConfigFile)
	{
		
		System.out.println(".........................................ReadPropertiesFile");
		if(!verifyFileExist(pathConfigFile))
		{
			this.passed = false;
			return false;
		}
		baseURL = prop.getProperty("baseURL");
		browser = prop.getProperty("browser").trim();
		return true;	
		
	}
    
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
	
	 boolean SetupBrowser(String strBrowser) 
	  {
	      if (strBrowser.toUpperCase().equals("CHROME"))
	      {	          
	          if (!SetupChrome()) return false;
	      }	      
	      return true;
	  }
	 
	  boolean SetupChrome()
	  {
	      try
	         {   
		    	  String chromeSetup = new File(System.getProperty("user.dir")).getAbsolutePath() + "/libs/Selenium_Common/chromedriver.exe";	       
			      System.setProperty("webdriver.chrome.driver", chromeSetup);	    		
			      driver = new ChromeDriver();
			      driver.manage().window().maximize();
			      driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		      }
	      catch (Exception ex)
		      {
		          this.defect = ex.getMessage();;
		          return false;
		      }
	      return true;
	      
	  }
	  
	  boolean OpenApplication()
	  {
		  if(baseURL.isEmpty())
		  {
			  System.out.println("Error while opening the application, base url is empty");
			  return false;
		  }
		  try
	         {
	             driver.get(baseURL);
	             driver.manage().timeouts().implicitlyWait(intDefaultTimeOut, TimeUnit.SECONDS);
	         }
	         catch (Exception ex)
	         {
	        	 System.out.println(ex.getMessage());
	             this.defect = ex.getMessage();
	             return false;
	         }
		  return true;
		  
	  }
    
    
    
    
    

}
