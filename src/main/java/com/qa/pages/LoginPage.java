package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//object repository
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(id = "user_email")
	WebElement email;
	
	@FindBy(xpath = "//div[@class='next-wrapper']")
	WebElement nextbtn;
	
	@FindBy(id = "user_password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='next-wrapper']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//div[@class='email-not-found-text']")
	WebElement wrongemailerror;
	
	@FindBy(xpath = "//div[@class='notice-component warning']")
	WebElement wrongpassworderror;
	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	//Actions
	public void clickLoginLink() {
		loginLink.click();
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterCorrectEmailandPassword(String e_mail,String pwd) {
		email.sendKeys(e_mail);
		nextbtn.click();
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	public String enterinvalidEmail(String e_mail) {
		email.sendKeys(e_mail);
		nextbtn.click();
		return wrongemailerror.getText();
		
	}
	
	public String enterWrongPassword(String e_mail, String pwd) {
		email.sendKeys(e_mail);
		nextbtn.click();
		password.sendKeys(pwd);
		loginbtn.click();
		return wrongpassworderror.getText();
		
	}
	

	
}
