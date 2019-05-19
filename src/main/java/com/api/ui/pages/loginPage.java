package com.api.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class loginPage extends TestBase {

	//Page Factory
	
	@FindBy(id="email")//WebElement to find locator
	WebElement username;//webelement from webbrowser that is named Username it will hold the FindBy element
	
	@FindBy(id="passwd")//
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitbutton;
	
	@FindBy(xpath = "//*[@id=\'header_logo\']/a/img")
	WebElement apLogo;
	
public loginPage() {
	PageFactory.initElements(driver, this);//takes all the WebElements from above and initialize the elements 
	//this represents the webelements you are trying to initialize and which class
	
}
//driver automatically locates the title of the application
public String VerifyPageTitle() {
	return driver.getTitle();
}
//when you visit application is the logo present true or false
public boolean ValidateAPImage() {
	return apLogo.isDisplayed();
}//string variable should be different from actual webElement but will read from testbase property file
public HomePage login (String jose, String albe) {
	username.sendKeys(jose);
	password.sendKeys(albe);
	submitbutton.click();
	
	return new HomePage();
}
}