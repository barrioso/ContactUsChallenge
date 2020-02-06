package com.contactus.qa.Pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.contactus.qa.TestBase.TestBase;

public class HomePage extends TestBase {
	
	// Object Repository Definition 
	@FindBy(id = "contact-link")
	WebElement contactUsLnk;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions performed
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
		
	public ContactUsPage clickOnContactsLink(){
		contactUsLnk.click();
		return new ContactUsPage();
	}
}
