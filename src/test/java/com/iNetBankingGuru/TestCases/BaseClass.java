package com.iNetBankingGuru.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	

	public String baseURL="https://demo.guru99.com/V4/";
	public String userName="mngr254440";
	public String passWord="pAmuzYm";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Driver\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
