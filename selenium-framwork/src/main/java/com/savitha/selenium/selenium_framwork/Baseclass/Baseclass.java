package com.savitha.selenium.selenium_framwork.Baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	WebDriver driver;
	WebDriverWait wait;
	
	public Baseclass(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(5)) ;
		PageFactory.initElements(driver, this);
	}
	
	By carticpon=By.xpath("//button[@routerlink='/dashboard/cart']");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartbtn;
	
	public WebElement visiblityofElement(By Locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public void elementToBeClickable(By Locator) {
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}
	
	public void moveToElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	
	public void Gotocart() {
		elementToBeClickable(carticpon);
		cartbtn.click();
		
	}

}
