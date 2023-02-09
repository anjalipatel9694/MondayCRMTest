package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginpage;

	public LoginTest() throws IOException {
		super();

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialization();
		loginpage = new LoginPage();
		loginpage.clickLoginLink();
		
	}

	@Test(priority = 1)
	public void validateLoginPageTest() {
		String actualtitle = loginpage.validateLoginPageTitle();
		Assert.assertEquals(actualtitle, "monday.com: Where Teams Get Work Done");
	}
	
	@Test(priority = 2, groups = "smoke")
	public void enterCorrectEmailandPasswordTest() {
		loginpage.enterCorrectEmailandPassword(prop.getProperty("email"),prop.getProperty("password"));
		
	}
	
	@Test(priority = 3)
	public void enterinvalidEmailTest() {
		String emailerror = loginpage.enterinvalidEmail(prop.getProperty("wrongemail"));
		 
		Assert.assertEquals(emailerror, "We couldn't find this email. Would you like to\n"
				+ "sign up with this address?");
	}
	
	@Test(priority = 4)
	public void enterWrongPasswordTest() {
		String passworderror = loginpage.enterWrongPassword(prop.getProperty("email"), prop.getProperty("wrongpassword"));
		Assert.assertEquals(passworderror, "Incorrect email or password");
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
