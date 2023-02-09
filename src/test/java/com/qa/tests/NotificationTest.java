package com.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.NotificationPage;

public class NotificationTest extends TestBase {

	public NotificationTest() throws IOException {
		super();

	}

	LoginPage loginpage;
	NotificationPage notificationpage;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		initialization();
		loginpage = new LoginPage();
		notificationpage = new NotificationPage();
		loginpage.clickLoginLink();
		loginpage.enterCorrectEmailandPassword(prop.getProperty("email"), prop.getProperty("password"));
		
	}

	@Test
	public void clickNotificationLinkTest() {
		notificationpage.clickNotificationLink();
	}

	@Test
	public void verifyNotificationTextDispalyTest() {
		notificationpage.clickNotificationLink();
		 Assert.assertTrue(notificationpage.verifyNotificationTextDispaly());
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
