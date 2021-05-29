package org.qa.IspeakBetter.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.qa.IspeakBetter.base.BasePage;
import org.qa.IspeakBetter.page.LoginPage;
import org.qa.IspeakBetter.util.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPge;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPge = new LoginPage(driver);
	}
	@Test(priority = 1)
	public void veryfyLoginPageTitle() {
		String title = loginPge.getPageTitle();
		System.out.println("login page title is "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void veryfyLoginPageHeader() {
		String header = loginPge.getLoginPageHeader();
		System.out.println("login page header is "+ header);
		Assert.assertEquals(header, Constants.LOGIN_PAGE_HEADER);
	}
	@Test(priority = 3, description = "Login test is using correct username and password")
	public void loginTest1() {
		loginPge.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	@Test(priority = 4,description = "Login test is using incorrect username and incorrect password")
	public void loginTest2() {
		loginPge.doLogin(properties.getProperty("ckltest@gmail.com"), properties.getProperty("Test123"));
	}
	@AfterMethod
	public void tearDown() {
		basePage.quitBrowser();
	}
}
