package com.iNetBankingGuru.TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.iNetBankingGuru.pageObjects.LoginPageDemoGuru;

public class TC001 extends BaseClass{
	
	@Test
	public void logintest() {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPageDemoGuru lpg = new LoginPageDemoGuru(driver);
		lpg.setUsername(userName);
		logger.info("Entered Username");
		lpg.setPassword(passWord);
		logger.info("Entered Password");
		lpg.clickSubmit();
		logger.info("Login Test Passed");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		System.out.println("Title is : - Guru99 Bank Manager HomePage");
		
	}
	

}
