package com.savitha.selenium.selenium_framwork.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.savitha.selenium.selenium_framwork.Baseclass.Baseclass;

public class LoginScreen extends Baseclass
{
	WebDriver driver;
	
	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement incorrectlogin;
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(css="input[name='login']")
	WebElement Login;
	
	By loginMessageLocator =By.xpath("//div[@aria-label='Login Successfully']");
	
	
	public ProductPage Login(String emailid,String passcode) {
		email.sendKeys(emailid);
		password.sendKeys(passcode);
		Login.click();
		ProductPage productpage=new ProductPage(driver);
		return productpage;
		
		
	}
	
	public String ValidateLogin() {
		WebElement Loginmessage=visiblityofElement(loginMessageLocator);
		String Logintext=Loginmessage.getText();
		return Logintext;
	}
	
	public String InvalidLogin() {
		visiblityofElement(incorrectlogin);
		String Logintext=incorrectlogin.getText();
		return Logintext;
		
		
	}

}
