package com.iNetBankingGuru.TestCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	

	public String baseURL="https://demo.guru99.com/V4/";
	public String userName="mngr254440";
	public String passWord="pAmuzYm";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		//Logger functionality
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
