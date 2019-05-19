package com.api.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase{
	
	
	@FindBy(css="input[class='cart_quantity_input form-control grey']") 
	WebElement Qty;
	
	@FindBy(css="a[title='Subtract']")
	WebElement subtract;
	
	@FindBy(css="a[title='Add']")
	WebElement add;
	
	@FindBy(xpath="//p[@class='address_add submit']//a[@class='button button-small btn btn-default']")
	WebElement NewAddress;
	
	@FindBy(css="a[class='button btn btn-default standard-checkout button-medium']")
	WebElement Proceedfinal;
	
	@FindBy(css="input[name='cgv']")
	WebElement Termscondit;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement ConfirmOrder;
	
	@FindBy(css="a[class='bankwire']")
	WebElement Bankwirepay;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement OrderConfirm;
	
	@FindBy(xpath="//p[@class='cheque-indent']")
	WebElement OrderConfirmation;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage proceedCheckout() {
		Proceedfinal.click();
		return this;
		
	}
	
	public OrderSummaryPage proceedaddresscheckout() {
		NewAddress.click();
		return this;
	}
	
	public OrderSummaryPage Termsandcondition() {
		Termscondit.click();
		return this;
	}
	
	public OrderSummaryPage paymenttype() {
		Bankwirepay.click();
		ConfirmOrder.click();
		return this;
		
	}
	
	public String getConfirmationMessage() {
		return OrderConfirmation.getText();
	}
	
	
	
}
