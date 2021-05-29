package org.qa.IspeakBetter.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.IspeakBetter.base.BasePage;
import org.qa.IspeakBetter.page.HomePage;
import org.qa.IspeakBetter.page.LoginPage;
import org.qa.IspeakBetter.util.Constants;
import org.qa.IspeakBetter.util.ElementUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPage loginPge;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		properties = basePage.initialize_properties();
		driver = basePage.initialize_driver(properties);
		loginPge = new LoginPage(driver);
		homePage = loginPge.doLogin(properties.getProperty("username"), properties.getProperty("password"));
	}
	@Test(priority = 1)
	public void veryfyHomePageTitle() {
		homePage.getHomePageTitle();
		String actualTitle = homePage.getHomePageTitle();
		System.out.println("login page header is "+ actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void veryfyClcikOnShowBtn() {
		homePage.clickOnShowBtn();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://onlinestudent.ispeakbetter.com/onlinestudent.php?job=vocabulary";
		Assert.assertEquals(actualURL, expectedURL);
	}
	@Test(priority = 3)
	public void veryfyEnterWordBtn() {
		homePage.enterWord();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://onlinestudent.ispeakbetter.com/onlinestudent.php";
		Assert.assertEquals(actualURL, expectedURL);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
