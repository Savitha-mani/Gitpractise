package com.savitha.selenium.selenium_framwork.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.savitha.selenium.selenium_framwork.Baseclass.Baseclass;

public class Cartpage extends Baseclass {
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']")
	List<WebElement> productsincart;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	WebElement checkout;
	
	public List<String> checkcart(List<String> mycartproducts) {
	for(WebElement cartprodut:productsincart) {
		WebElement mycart= cartprodut.findElement(By.tagName("h3"));
		mycartproducts.add(mycart.getText());
		
	}
	return mycartproducts;
	
	}
	
	public bankinformation checkouticon() {
		moveToElement(checkout);
		bankinformation bankinformation=new bankinformation(driver);
		return bankinformation;
	}
	
}
