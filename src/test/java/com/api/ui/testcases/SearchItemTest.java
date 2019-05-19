package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.SearchPage;
import com.api.ui.pages.loginPage;

public class SearchItemTest extends TestBase {
	
	
	loginPage LoginPageOR;
	HomePage homepageOR;
	SearchPage searchpageOR;

public SearchItemTest() {
	super();
	
}
@BeforeMethod
public void setUpdriver() {
	intialization();
	LoginPageOR = new loginPage();
	homepageOR = new HomePage();
	
}
@Test(priority = 3)
public void TestSearchItem() {
	String product = "Evening";
	homepageOR.ClickonSignin();
	homepageOR = LoginPageOR.login(propt.getProperty("username"), propt.getProperty("password"));
	
	searchpageOR = homepageOR.searchProduct("Evening");
	String header = searchpageOR.getHeader();
	System.out.println(header);
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	homepageOR.logOut();
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
	
}










}