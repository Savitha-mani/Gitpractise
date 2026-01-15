package com.savitha.selenium.selenium_framwork;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.savitha.selenium.selenium_framwork.BaseTest.Basetest;
import com.savitha.selenium.selenium_framwork.pageobjects.LoginScreen;
import com.savitha.selenium.selenium_framwork.testnglistners.Retry;

public class ErrorValidations extends Basetest {
	
@Test(retryAnalyzer = Retry.class)
	
	public void loginpagevalidation() throws InterruptedException{
	
	LoginScreen loginScreen=new LoginScreen(driver);
	loginScreen.Login("Savi32@gmail.com","Savitha!23");
	String Logintext=loginScreen.InvalidLogin();
	
	
	Assert.assertEquals(Logintext, "Incorrec email or password.");
}
}
