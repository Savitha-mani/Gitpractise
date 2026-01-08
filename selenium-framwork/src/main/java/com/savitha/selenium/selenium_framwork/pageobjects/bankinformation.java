package com.savitha.selenium.selenium_framwork.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class bankinformation {
	WebDriver driver;
	public bankinformation(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath="//div[contains(text(),'Credit Card Number ')]//following-sibling::input")
	WebElement creditcardinfo;
	@FindBy(xpath="//select[@class='input ddl'][1]")
	WebElement month;
	@FindBy(xpath="//select[@class='input ddl'][2]")
	WebElement date;
	@FindBy(xpath="//div[contains(text(),'CVV Code')]//following-sibling::input")
	WebElement cvv;
	@FindBy(css="input[placeholder$='Select Country']")
	WebElement selectcountry;
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button")
	List<WebElement> countries;
	@FindBy(xpath="//a[contains(.,'Place Order')]")
	WebElement placeorder;
	
	
	public void bankdetails(String mycountry) {
	creditcardinfo.clear();
	creditcardinfo.sendKeys("123456789");
	Select select =new Select(month);
	select.selectByVisibleText("07");
	Select select1 =new Select(date);
	select1.selectByVisibleText("15");
	cvv.sendKeys("321");
	selectcountry.sendKeys("ind");
	for(WebElement country : countries) {
		WebElement countryelement=country.findElement(By.xpath(".//span"));
		String countryname=countryelement.getText();
		if(countryname.equals(mycountry)) {
			countryelement.click();
			break;
		}
	}
	}
	
	public void placingorder() {
	placeorder.click();
	}
	
}
