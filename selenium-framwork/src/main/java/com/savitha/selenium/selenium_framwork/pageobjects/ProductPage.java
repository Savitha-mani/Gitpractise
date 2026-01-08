package com.savitha.selenium.selenium_framwork.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.savitha.selenium.selenium_framwork.Baseclass.Baseclass;
public class ProductPage extends Baseclass{
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='card-body']/h5")
	List<WebElement> products;
	
	By productadded=By.cssSelector("div[aria-label='Product Added To Cart']");
	
	public void AddingproductstoCart(List<String> myproducts) {
		for(WebElement prod :products) {
			String productname=prod.getText();
			System.out.println(productname);
			for(String item:myproducts) {
			if(productname.contains(item)) {
			WebElement Addtocart=prod.findElement(By.xpath("following-sibling::button[2]"));
			Addtocart.click();
			visiblityofElement(productadded);
		}
			}
	}
}
}
