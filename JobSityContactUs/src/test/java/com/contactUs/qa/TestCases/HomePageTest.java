package com.contactUs.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.contactus.qa.Pages.HomePage;
import com.contactus.qa.TestBase.TestBase;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	String expectedResult = "";
	String actualResult = "";
	
	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void launchBrowser() {
		initialization();
		homePage = new HomePage();
		
	}
	
	@Test(priority=1)
	public void verifyContactUsPageTitleTest() throws InterruptedException{
		Thread.sleep(1000);
		expectedResult = "My Store";
		actualResult = homePage.verifyHomePageTitle();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
}


