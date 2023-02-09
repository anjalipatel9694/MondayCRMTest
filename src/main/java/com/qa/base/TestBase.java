package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("C:\\QA\\Selenium_WorkSpace\\MondayCRMTest\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fi);
	}
	
	public static void initialization() {
		String browser = prop.getProperty("browser");
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
