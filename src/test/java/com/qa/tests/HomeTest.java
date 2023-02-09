package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomeTest extends TestBase {
	
	public HomeTest() throws IOException {
		super();
		
	}

	HomePage homepage;
	LoginPage loginpage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		loginpage.clickLoginLink();
		loginpage.enterCorrectEmailandPassword(prop.getProperty("email"), prop.getProperty("password"));

		
		
	}

	@Test(priority = 1)
	public void verifyHomePageLinkPresentTest() {
	Assert.assertTrue(homepage.verifyHomePageLinkPresent());	
	}
	
	@Test(priority = 2)
	public void verifyNotificationLinkPresentTest() {
		Assert.assertTrue(homepage.verifyNotificationLinkPresent());
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
