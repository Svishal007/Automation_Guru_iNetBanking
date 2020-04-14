package com.iNetBankingGuru.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBankingGuru.pageObjects.LoginPageDemoGuru;
import com.iNetBankingGuru.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		LoginPageDemoGuru lpg= new LoginPageDemoGuru(driver);
		lpg.setUsername(user);
		logger.info("UID done");
		lpg.setPassword(pwd);
		logger.info("password provided");
		lpg.clickSubmit();
		logger.info("Login done");
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.warn("Login Passed");
			lpg.logout();
			logger.warn("Logedded out");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;

		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getdata() throws IOException {
		String excelPath= "C:\\Users\\admin\\Desktop\\TestAutomation\\iNetBankingGuru\\src\\test\\java\\com\\iNetBankingGuru\\TestData\\LoginData.xlsx";
		//String excelPath= System.getProperty("user.dir")+"src/test/java/com/iNetBankingGuru/TestData/LoginData.xlsx";
		System.out.println(excelPath);

		int rownum= XLUtils.getrowCount(excelPath, "Sheet1");
		
		int colcount=XLUtils.getCellCount(excelPath, "Sheet1", 1);
		String logindata[][] = new 	String [rownum][colcount];
		
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
			}
		}
		return logindata;
		
	}
	

}
