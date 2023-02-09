package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class NotificationPage extends TestBase{

	

	//Page Factory
	@FindBy(xpath = "//div[@class='surface-navigation-dialog-item-component']")
	WebElement notificationLink;
	
	//@FindBy(id = "notifications-button")
	//WebElement notificationLink;
	
	@FindBy(xpath = "//div[@id='notifications_popup_preview']/div/span[contains(text(),'Notifications')]")
	WebElement notificationText;
	
	
	public NotificationPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void clickNotificationLink() {
		notificationLink.click();
	}
	
	public boolean verifyNotificationTextDispaly() {
		return notificationText.isDisplayed();
	}
	
	
	
	
}
