package com.contactus.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.contactus.qa.TestBase.TestBase;

public class ContactUsPage extends TestBase {
	
		
	// Object Repository Definition 
	@FindBy (id = "id_contact")
	WebElement subjectDrpDwn;
	
	
	@FindBy (id = "email")
	WebElement emailAsccountTxtBox;
	
	@FindBy (xpath = "//input[@class='form-control grey']")
	WebElement orderNumTxtBox;
	
	@FindBy (id = "message")
	WebElement messageTxtBox; 
	
	@FindBy (xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement submitBtn;
		
	@FindBy (xpath = "//*[@id='center_column']/div/ol/li")
	WebElement emptyEmailAlert, emptyMessageAlert, emptySubjectAlert; 
    
	@FindBy (xpath = "//*[@id='center_column']/p")
	WebElement successMessageAlert; 
	
	// Initializing the Page Objects:
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions performed
	
	public String verifyContactUsPageTitle(){
		return driver.getTitle();
	}
		
	public String verifyEmptyEmailWarningMessage(){
		Select subjectDrp = new Select (subjectDrpDwn);
		subjectDrp.selectByIndex(2);
		orderNumTxtBox.sendKeys("ORD12929-129");
		messageTxtBox.sendKeys("This message is typed to validadte the warning message displayed when the email account field is empty");
		submitBtn.click();
		
		return emptyEmailAlert.getText();
	}
	
	public String verifyEmptySubjetWarningMessage(){
		emailAsccountTxtBox.sendKeys("testuser@aol.com");
		orderNumTxtBox.sendKeys("ORD12929-139");
		messageTxtBox.sendKeys("This message is typed to validadte the warning message displayed the subject drop-down field is empty");
		submitBtn.click();
		
		return emptySubjectAlert.getText();
	}
	
	public String verifyEmptyMessageWarningMessage(){
		Select subjectDrp = new Select (subjectDrpDwn);
		subjectDrp.selectByIndex(1);
		emailAsccountTxtBox.sendKeys("testuser@aol.com");
		orderNumTxtBox.sendKeys("ORD12929-149");
		submitBtn.click();
		
		return emptyMessageAlert.getText();
	}
	
	public String verifySuccesMessageAlert(){
		Select subjectDrp = new Select (subjectDrpDwn);
		subjectDrp.selectByIndex(2);
		emailAsccountTxtBox.sendKeys("testuser@aol.com");
		orderNumTxtBox.sendKeys("ORD12929-159");
		messageTxtBox.sendKeys("This message is typed to validadte the success message displayed after to submit the form message");
		submitBtn.click();
		
		return successMessageAlert.getText();
	}
	
	public String verifySuccesMessageAlert(String subjectNum, String emailaccount, String orderNum, String messageText){
		Select subjectDrp = new Select(driver.findElement(By.id("id_contact")));
		subjectDrp.selectByVisibleText(subjectNum);
		emailAsccountTxtBox.sendKeys(emailaccount);
		orderNumTxtBox.sendKeys(orderNum);
		messageTxtBox.sendKeys(messageText);
		submitBtn.click();
		
		return successMessageAlert.getText();
	}
	
		
}
