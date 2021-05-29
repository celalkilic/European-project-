package org.qa.IspeakBetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.IspeakBetter.base.BasePage;
import org.qa.IspeakBetter.util.Constants;
import org.qa.IspeakBetter.util.ElementUtil;

public class LoginPage extends BasePage{
	//fields
	
	WebDriver driver;
	ElementUtil elementUtil;
	//locators
	
	By clickLoginBtnId = By.id("cmdSiginLink");
	By clickSingInBtnId = By.id("signin");
	By usernameId = By.id("_email");
	By passwordId = By.id("_password");
	By loginBtnId = By.id("cmdSignin");
	By header = By.xpath("//h1[@class = 'rsp']");
	//constructor
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page actions
	
	public String getPageTitle() {
		return elementUtil.doGetPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	public String getLoginPageHeader() {
		return elementUtil.doGetText(header);
	}
	
	public HomePage doLogin(String userN, String pssWrd) {
		elementUtil.doClick(clickLoginBtnId);
		elementUtil.doClick(clickSingInBtnId);
		elementUtil.doSendKeys(usernameId, userN);
		elementUtil.doSendKeys(passwordId, pssWrd);
		elementUtil.doClick(loginBtnId);
		return new HomePage(driver);
	}	
}
