	package com.api.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.api.ui.pages.ContactsPage;
import com.api.ui.pages.HomePage;

public class ContactTest extends TestBase {

	
	ContactsPage contactspage;
	HomePage homepage;
	
	public ContactTest() {
		super ();
	}
		@BeforeMethod
		public void setUpdriver() {
			intialization();
			contactspage = new ContactsPage();
			homepage = new HomePage();
		}
		
		@Test
		public void testContact() {
			homepage.ClickonContactLink();
			contactspage = contactspage.fillContactFormO("Customer Service", "Josely.alberto@gmail.com", "Testing","This is test purpose");
			
			contactspage.submitMessage();
			String successMsg = contactspage.getMessage();
			Assert.assertEquals(successMsg,"will check the message on the site later");
			
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
	
	
