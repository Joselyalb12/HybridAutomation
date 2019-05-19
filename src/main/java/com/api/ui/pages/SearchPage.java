package com.api.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

	public class SearchPage extends TestBase {
			
		@FindBy(id="add_to_cart")
		WebElement addCartButton;
		
		@FindBy(css="[title='Proceed to checkout']")
		WebElement CheckOut;
		
		@FindBy(css= "[class='page-heading product-listing']")
		WebElement searchHeading;
		
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		public ProductDetailsPage selectProduct(String productname) {
			
			String locator = "[class='product-name'][title='"+ productname +"']";
			
			driver.findElement(By.cssSelector(locator)).click();
			return new ProductDetailsPage();
		}
		public String getHeader() {
			return searchHeading.getText();
		}
		
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	