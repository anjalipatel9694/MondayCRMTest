package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//@FindBy(id = "notifications-button")
	//WebElement notificationLink;
	
	@FindBy(xpath = "//div[@class='surface-navigation-dialog-item-component']")
	WebElement notificationLink;
	
	@FindBy(id = "homepage-button")
	WebElement homepageLink;
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public boolean verifyHomePageLinkPresent() {
		return homepageLink.isDisplayed();
		
	}
	
	public boolean verifyNotificationLinkPresent() {
		return notificationLink.isDisplayed();
	}

}
