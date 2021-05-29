package org.qa.IspeakBetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.IspeakBetter.base.BasePage;
import org.qa.IspeakBetter.util.Constants;
import org.qa.IspeakBetter.util.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	//locators
	By showVocabularyBasket = By.xpath("//center//a[@class='btn btn2 small turkuaz']");
	By enterWord = By.xpath("//input[@class = 'form-control']");
	By search = By.xpath("//button[@name='job']");
	By backBtn = By.xpath("//a[@class='btn btn-info btn-sm']");
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//page actions
	public String getHomePageTitle() {
		return elementUtil.doGetPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	public void clickOnShowBtn() {
		elementUtil.doClick(showVocabularyBasket);
	}
	public void enterWord() {
		elementUtil.doSendKeys(enterWord, "car");
	}
	public void clickOnSearchAndBackBtn() {
		elementUtil.doClick(search);
		elementUtil.doClick(backBtn);
	}
	
}
