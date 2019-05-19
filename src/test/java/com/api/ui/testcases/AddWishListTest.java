package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.api.ui.pages.HomePage;
import com.api.ui.pages.ProductDetailsPage;
import com.api.ui.pages.SearchPage;
import com.api.ui.pages.loginPage;

public class AddWishListTest extends TestBase{
	
	
	
	loginPage LoginPageOR;
	HomePage homepageOR;
	SearchPage searchpageOR;
	ProductDetailsPage productdetailspageOR;

public AddWishListTest() {
	super();
	
}
@BeforeMethod
public void setUpdriver() {
	intialization();
	LoginPageOR = new loginPage();
	homepageOR = new HomePage();

}
@Test
public void testAddProductToWishList() {
	
	String product = "Printed Chiffon Dress";
	homepageOR.ClickonSignin();
	homepageOR = LoginPageOR.login(propt.getProperty("username"), propt.getProperty("password"));
	//SearchProduct
	searchpageOR = homepageOR.searchProduct(product);
	String header = searchpageOR.getHeader();
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	//Add Product to Wishlist
	productdetailspageOR.clickAddWishlistButton();
	productdetailspageOR.verifyAddwishlistMsg();
	homepageOR.logOut();
	
	
}
@AfterMethod
public void tearDown() {
	driver.quit();
}


}
