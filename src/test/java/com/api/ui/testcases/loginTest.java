package com.api.ui.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.loginPage;
import com.api.ui.util.testUtil;


public class loginTest extends TestBase {

	loginPage LoginPage;
	testUtil testutils;
	HomePage homePage;//creating global variables to use information inside
	
	public loginTest() {
		super();
	}
		@BeforeMethod
		public void setUpDriver() {
		intialization();//From test base opening up browser
		LoginPage = new loginPage();//Needed to access the methods
		
	}
		@Test(priority = 1)
		public void loginPageTitleTest() {
		String hometitle = LoginPage.VerifyPageTitle();//Hometitle is holding the title 
			Assert.assertEquals(hometitle, "Later will check on the site");
			//Accepts two strings and compares the string hometitle and verify that they equal
		
		}
		
		@Test(priority=2)
		public void apLogoTest() {
		boolean valid  = LoginPage.ValidateAPImage();
		Assert.assertEquals(true, false);//Compares the image that is represented on loginpage web Element 
		}
		
		@Test(priority=3)
		public void actuallogin() throws Exception {
		//Anytime we are trying to read a file input stream or excel it will always throw an exception
		homePage = LoginPage.login(propt.getProperty("username"), propt.getProperty("password"));
		//Using the fileinputstream to read the information inside using the propt.getproperty
		}
		
		@AfterMethod
		public void CloseBrowser() {
			driver.quit();
		}
	}

