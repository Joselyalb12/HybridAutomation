package com.api.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase {
	//Find the elements on the page through page factory
	@FindBy(id="short_description_content")
	WebElement ProductDetail;
	
	@FindBy(id="group_1")
	WebElement size1;
	
	@FindBy(id="quantity_wanted")
	WebElement Quantity;
	
	@FindBy(css="button[class='exclusive']")
	WebElement AddCart;
	
	@FindBy(id="wishlist_button")
	WebElement WishlistButton;
	
	@FindBy(css="div[class='fancybox-inner']")
	WebElement AddWishlistmsg;
	
	@FindBy(css="a[title='close']")
	WebElement AddWishlistclose;
	
	@FindBy(css="a[title='Proceed to checkout']")
	WebElement Proceedtocheckout;
	////////////////////////////////////////
	//Constructor that initializes the page factory and the elements above
	public ProductDetailsPage () {
		PageFactory.initElements(driver, this);
		
	}
	//This is the only method here below
	//If this is true AddtoWishlist will be shown onto the console and addwishlistclose.click will close the button
	public void verifyAddwishlistMsg() {
		Assert.assertEquals(AddWishlistmsg.getText(), "Add to Wishlist");
		AddWishlistclose.click();
	}
//+color+ is the concatination where the color will change ie blue green	
	public ProductDetailsPage selectProductColor(String color) {
		String locator ="[name='"+color+"']";//a css selector is created in a string value css="[name='"+color+"']"
		driver.findElement(By.cssSelector(locator)).click();//then creating a css for locator and clicking on it.
		return this;//<- Due to the fact that it will be repeated as in different sizes and color etc.
	
}//Using the constructor---Passing a Parameter bring in String value = Constructor Overloading
	public ProductDetailsPage inputQuantity(String quantity) {
		Quantity.clear();
		Quantity.sendKeys(quantity);
		return this;
		
	}	
	public ProductDetailsPage selectSize(String size) {
		Select select = new Select(size1);
		select.selectByVisibleText(size);
		return this;
	}	
	public ProductDetailsPage clickAddCart() {
		AddCart.click();
		return this;
		
	}
	
	public ProductDetailsPage clickAddWishlistButton() {
		WishlistButton.click();
		return this;
		
	}
	public OrderSummaryPage proceedCheckout() {
		Proceedtocheckout.click();
		return new OrderSummaryPage();

		
	}
	
	
}
