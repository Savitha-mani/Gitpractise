package com.savitha.selenium.selenium_framwork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAlonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> myproducts=Arrays.asList("ZARA COAT 3", "IPHONE 13 PRO");
		List<String> mycartproducts=new ArrayList<String>();
		String mycountry="India";
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("Savi321@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Savitha!23");
		WebElement Login=driver.findElement(By.cssSelector("input[name='login']"));
		Login.click();
		By loginMessageLocator =By.xpath("//div[@aria-label='Login Successfully']");
		WebElement Loginmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(loginMessageLocator));
		String Logintext=Loginmessage.getText();
		System.out.println(Logintext);
		Assert.assertEquals(Logintext, "Login Successfully");
		
	List<WebElement> products=driver.findElements(By.xpath("//div[@class='card-body']/h5"));
	for(WebElement prod :products) {
		String productname=prod.getText();
		System.out.println(productname);
		for(String item:myproducts) {
		if(productname.contains(item)) {
		WebElement Addtocart=prod.findElement(By.xpath("following-sibling::button[2]"));
		Addtocart.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Product Added To Cart']")));
		}
			}
	}
	Thread.sleep(2000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
	WebElement cartbtn=driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
	cartbtn.click();
	List<WebElement> productsincart=driver.findElements(By.xpath("//div[@class='cartSection']"));
	for(WebElement cartprodut:productsincart) {
		WebElement mycart= cartprodut.findElement(By.tagName("h3"));
		mycartproducts.add(mycart.getText());
		
	}
	System.out.println(mycartproducts);
	
	Assert.assertTrue(mycartproducts.containsAll(myproducts) &&
            myproducts.containsAll(mycartproducts));

	WebElement checkout=driver.findElement(By.xpath("//button[contains(text(),'Checkout')]"));
	Actions action=new Actions(driver);
	action.moveToElement(checkout).click().perform();
	WebElement creditcardinfo=driver.findElement(By.xpath("//div[contains(text(),'Credit Card Number ')]//following-sibling::input"));
	creditcardinfo.clear();
	creditcardinfo.sendKeys("123456789");
	WebElement month=driver.findElement(By.xpath("//select[@class='input ddl'][1]"));
	Select select =new Select(month);
	select.selectByVisibleText("07");
	WebElement date=driver.findElement(By.xpath("//select[@class='input ddl'][2]"));
	Select select1 =new Select(date);
	select1.selectByVisibleText("15");
	WebElement cvv=driver.findElement(By.xpath("//div[contains(text(),'CVV Code')]//following-sibling::input"));
	cvv.sendKeys("321");
	WebElement selectcountry= driver.findElement(By.cssSelector("input[placeholder$='Select Country']"));
	selectcountry.sendKeys("ind");
	List<WebElement> countries=driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button"));
	for(WebElement country : countries) {
		WebElement countryelement=country.findElement(By.xpath(".//span"));
		String countryname=countryelement.getText();
		if(countryname.equals(mycountry)) {
			countryelement.click();
			break;
		}
	}
	WebElement placeorder=driver.findElement(By.xpath("//a[contains(.,'Place Order')]"));
	placeorder.click();
	WebElement orderconfirmation=driver.findElement(By.tagName("h1"));
	String confirmationmessage=orderconfirmation.getText();
	Assert.assertEquals(confirmationmessage.toLowerCase(), ("Thankyou for the order.").toLowerCase(), "Order confirmed with correct message");
	
	}
	

}
