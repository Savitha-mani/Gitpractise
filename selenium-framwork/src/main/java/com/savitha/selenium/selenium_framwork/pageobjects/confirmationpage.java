package com.savitha.selenium.selenium_framwork.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class confirmationpage {
	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(tagName = "h1")
	WebElement orderconfirmation;
	
	public String getconfirmationmessage() {
	
	String confirmationmessage=orderconfirmation.getText();
	return confirmationmessage;

}
}
