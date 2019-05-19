package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.api.ui.util.testUtil;
import com.api.ui.util.webEventlistener;

public class TestBase {//We are using a constructor model because theClass is used TestBase
	
	//These are the property values that we are going to work with
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;//importing or making connections with the built in functions from the driver.
	public static webEventlistener eventlistener;//Listens to the logs while the above line records the logs
	
	public TestBase(){	
		try {//Try and Catch to catch any errors and locate errors
				propt = new Properties();
				
				//Finding the URL path for the file of the property 
				FileInputStream ipa = new FileInputStream("C:\\Users\\Josel\\Desktop\\Automation Documents\\Automation.test1\\src\\main\\java\\com\\api\\ui\\config\\config.properties");
						
					propt.load(ipa);
				
		}catch (FileNotFoundException e) {//different types of error	
			e.printStackTrace();
		}catch (IOException e) {//different types of error
			e.printStackTrace();//print the error
		}
	}
//Creating the method for every webdriver for the getproperty browser/chrome/InternetExplorer
public static void intialization() {
		String browserName = propt.getProperty("browser");
			
				if(browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/resources/driver folder/chromedriver.exe");
						driver = new ChromeDriver();
					
}
				else if(browserName.equalsIgnoreCase("InternetExplorer")) {
					System.setProperty("Webdriver.ie.driver", "‪C:\\Users\\Josel\\Desktop\\MicrosoftWebDriver.exe");
					driver = new InternetExplorerDriver();
			/////////////////////////////////////////////////////////////
				}
				//Records the events such that if it passes/fails/skips to verify and validate that the test execution passed/failed/skipped
				//creating object for action that's occurring and sharing with driver
				en_driver = new EventFiringWebDriver(driver);
				//creating object of WebEcentListener to register it with eventFiringWebdriver
				eventlistener = new webEventlistener();
				//event can be captured based on the method we create webeventlistener class
				en_driver.register(eventlistener);
				//since we know driver object is for browser en_driver is for event thats taking place. 
				//we declaring that they are equal to each when they are exchanging the info
				driver = en_driver;
			////////////////////////////////////////////////////////	
				driver.manage().window().maximize();
				
				driver.get(propt.getProperty("url"));
				
				driver.manage().deleteAllCookies();
				//testutil and pageload is created through the inhertiance concept on Class testUtil.java
				driver.manage().timeouts().implicitlyWait(testUtil.Implicit_Wait, TimeUnit.SECONDS );//10 seconds is given to open up browser if not execution failed
				driver.manage().timeouts().implicitlyWait(testUtil.Page_load, TimeUnit.SECONDS );//10 seconds to load page
				

				
				
				
				
}







}

		
		