package com.iNetBankingGuru.TestCases;

import org.testng.annotations.Test;

import com.iNetBankingGuru.pageObjects.LoginPageDemoGuru;

public class TC001 extends BaseClass{
	
	@Test
	public void logintest() {
		driver.get(baseURL);
		LoginPageDemoGuru lpg = new LoginPageDemoGuru(driver);
		lpg.setUsername(userName);
		lpg.setPassword(passWord);
		lpg.clickSubmit();
		
		if (driver.getTitle().equals("Welcome To Manager's Page of Guru99 Bank")) {
			System.out.println("Pass");
		}
		
	}
	

}
