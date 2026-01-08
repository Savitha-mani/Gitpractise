package com.savitha.selenium.selenium_framwork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.savitha.selenium.selenium_framwork.pageobjects.Cartpage;
import com.savitha.selenium.selenium_framwork.pageobjects.LoginScreen;
import com.savitha.selenium.selenium_framwork.pageobjects.ProductPage;
import com.savitha.selenium.selenium_framwork.pageobjects.bankinformation;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<String> myproducts=Arrays.asList("ADIDAS ORIGINAL");
		List<String> mycartproducts=new ArrayList<String>();
		String mycountry="India";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		LoginScreen loginScreen=new LoginScreen(driver);
		loginScreen.Login();
		String Logintext=loginScreen.ValidateLogin();
		Assert.assertEquals(Logintext, "Login Successfully");
	Thread.sleep(2000);
	ProductPage productpage=new ProductPage(driver);
	productpage.AddingproductstoCart(myproducts);
	productpage.Gotocart();
	Cartpage cartpage=new Cartpage(driver);
	List<String> cartproducts=cartpage.checkcart(mycartproducts);
	Assert.assertTrue(cartproducts.containsAll(myproducts) &&
            myproducts.containsAll(cartproducts));
	cartpage.checkouticon();
	bankinformation bankinformation=new bankinformation(driver);
	bankinformation.bankdetails(mycountry);
	bankinformation.placingorder();
	
	WebElement orderconfirmation=driver.findElement(By.tagName("h1"));
	String confirmationmessage=orderconfirmation.getText();
	Assert.assertEquals(confirmationmessage.toLowerCase(), ("Thankyou for the order.").toLowerCase(), "Order confirmed with correct message");
	
	}
	

}
