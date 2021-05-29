package org.qa.IspeakBetter.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.qa.IspeakBetter.util.JavaScriptUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	//fields
	public WebDriver driver;
	public Properties properties;
	public static String flash;
	
	//initialize_driver
	
	public WebDriver initialize_driver(Properties properties) {
		String browser = properties.getProperty("browser");
		String headless = properties.getProperty("headless");
		flash = properties.getProperty("elementflash");
	//driver options here
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			if (headless.equalsIgnoreCase("no")) {
				ChromeOptions op = new ChromeOptions();
				op.addArguments("--headless");
				driver = new ChromeDriver(op);
			}else {
				driver = new ChromeDriver();
			}
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (headless.equalsIgnoreCase("yes")) {
				FirefoxOptions ff = new FirefoxOptions();
				ff.addArguments("--headless");
				driver = new FirefoxDriver(ff);
			}else {
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}	
	
	//initialize_properties
	
	public Properties initialize_properties() {
		properties = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\c&z\\Documents\\IspeakBetter2021\\"
					+ "src\\main\\java\\org\\qa\\IspeakBetter\\config\\config.properties");
			properties.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception accured while quiting the browser");
		}
	}
	public void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("some exception accured while closing the browser");
		}
	}
	

}
