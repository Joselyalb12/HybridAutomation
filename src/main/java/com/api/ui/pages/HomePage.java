package com.api.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase {
	
	//Finish the input of the WebElements from the WebSite
	@FindBy(css="[class='login']")
	WebElement SignInButton;
	
	@FindBy(id="contact-link")
	WebElement ContactButton;
	
	@FindBy(id="search_query_top")
	WebElement SearchInputBox;
	
	@FindBy(css="[name='submit_search']")
	WebElement SearchBoxclick;
	
	@FindBy(css="[class='logout']")
	WebElement logoutButton;
	
	@FindBy(css="[title='Women']")
	WebElement WomenQuickLink;
	
	@FindBy(css="[title='Dresses']")
	WebElement DressQuickLink;
	
	@FindBy(css="[title='T-shirts']")
	WebElement TshirtQuickLink;
	
	
	public HomePage() {
			PageFactory.initElements(driver, this);
			
	}
	public SearchPage searchProduct(String productname) {
		SearchInputBox.sendKeys(productname);
		SearchBoxclick.click();
		return new SearchPage();		
		
	}
	
	public void ClickonSignin() {
		SignInButton.click();
	}
	public void ClickonContactLink() {
		ContactButton.click();
	}
	public void logOut() {
		logoutButton.click();
	}
}
