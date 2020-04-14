package com.iNetBankingGuru.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageDemoGuru {
	
	WebDriver ldriver;
	
	public LoginPageDemoGuru(WebDriver rdriver ) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}

	@FindBy(name="uid")
	WebElement txtUsername;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnSubmit;
	
	@FindBy(name="btnReset")
	WebElement btnReset;
	
	@FindBy(xpath ="a[contains(text(),'Log out')]")
	WebElement logout;
	

	
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnSubmit.click();
	}
	public void clickReset() {
		btnReset.click();
	}
	public void logout() {
		logout.click();
	}
	
	
	
	

}
