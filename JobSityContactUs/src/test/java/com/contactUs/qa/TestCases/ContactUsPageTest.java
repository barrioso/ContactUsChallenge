package com.contactUs.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.contactus.qa.Pages.ContactUsPage;
import com.contactus.qa.Pages.HomePage;
import com.contactus.qa.TestBase.TestBase;
import com.contactus.qa.TestUtil.TestUtil;

public class ContactUsPageTest extends TestBase {
	
	HomePage homePage;
	ContactUsPage contactUsPage;
	String expectedResult = "";
	String actualResult = "";
	
	String sheetName = "contactUsForm";
	
	public ContactUsPageTest() {
		super();
	}

	//The whole test suite have test cases which are separated independent with each other
	//TestNG framework was used to launch the browser and reach the Contact Us page before each test case
	//The @test annotation is used to execute each of those test cases
	//And after each test case the browser is closed
	
	@BeforeMethod
	public void launchBrowser() {
		initialization();
		homePage = new HomePage();
		contactUsPage = homePage.clickOnContactsLink(); 
	}
	
	/*Test Name: ----*/
	/*Test user to validate if the title page is correct    
	 */
	
	@Test(priority=5)
	public void verifyContactUsPageTitleTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "Contact us - My Store";
		actualResult = contactUsPage.verifyContactUsPageTitle();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	/*Test Name: TC015_Given_ContactUs_page_when_Email_empty_then_message_NOT_submitted_and_warning_message_displayed*/
	/*Given the user goes to Contact Us page 
	 * when the user leaves the Message field empty and Submit the form
	 * then the message displayed should be "The message cannot be blank.    
	 */
	
	@Test(priority=2)
	public void verifyWarningAlertEmailEmtpyFieldTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "Invalid email address.";
		actualResult = contactUsPage.verifyEmptyEmailWarningMessage();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	/*Test Name: TC018_Given_ContactUs_page_when_Subject_empty_then_message_NOT_submitted_and_warning_message_displayed*/
	/*Given the user goes to Contact Us page 
	 * when the user leaves the Subject drop down field empty and Submit the form 
	 * then the message displayed should be "Please select a subject from the list provided."   
	 */
	
	@Test(priority=3)
	public void verifyWarningAlertSubjectEmtpyFieldTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "Please select a subject from the list provided.";
		actualResult = contactUsPage.verifyEmptySubjetWarningMessage();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	/*Test Name: TC016_Given_ContactUs_page_when_Message_empty_then_message_NOT_submitted_and_warning_message_displayed*/
	/*Given the user goes to Contact Us page 
	 * when the user leaves the Message field empty and Submit the form
	 * then the message displayed should be "The message cannot be blank.    
	 */
	
	@Test(priority=4)
	public void verifyWarningAlertMessageEmtpyFieldTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "The message cannot be blank.";
		actualResult = contactUsPage.verifyEmptyMessageWarningMessage();
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	/*Test Name: ------*/
	/*Test Description: Test to force to fail the "success form submitted"
	 * Expected result changed from "Your message has been successfully sent to our team."
	 * to  "Your message has been successfully sent to our team-FAILED TEST HARDCODED."   
	 */
	
	@Test(priority=1)
	public void verifySuccessMessageAlertTestHardcoded() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "Your message has been successfully sent to our team-FAILED TEST HARDCODED.";
		actualResult = contactUsPage.verifySuccesMessageAlert();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	/*Test Name: TC014_Given_ContactUs_page_when_fillout_all_fields_then_message_submitted_succesfully*/
	/*Test Description: Given the user goes to Contact Us page 
	 * when the user fills out all the available fields 
	 * then the message displayed should be "Your message has been successfully sent to our team."   
	 */
	
	@Test(priority=6)
	public void verifySuccessMessageAlertTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "Your message has been successfully sent to our team.";
		actualResult = contactUsPage.verifySuccesMessageAlert();
		Assert.assertEquals(actualResult, expectedResult);
	}
		
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
}

