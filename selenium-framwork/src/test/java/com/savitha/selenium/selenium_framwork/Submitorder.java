package com.savitha.selenium.selenium_framwork;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.savitha.selenium.selenium_framwork.BaseTest.Basetest;
import com.savitha.selenium.selenium_framwork.data.Readjson;
import com.savitha.selenium.selenium_framwork.pageobjects.Cartpage;
import com.savitha.selenium.selenium_framwork.pageobjects.LoginScreen;
import com.savitha.selenium.selenium_framwork.pageobjects.ProductPage;
import com.savitha.selenium.selenium_framwork.pageobjects.bankinformation;
import com.savitha.selenium.selenium_framwork.pageobjects.confirmationpage;

public class Submitorder extends Basetest {

	
	@Test(dataProvider = "getData")
	
	public void orderingproduct(HashMap<Object, Object> input) throws InterruptedException{
		List<String> myproducts=Arrays.asList("ADIDAS ORIGINAL","ZARA COAT 3");
		List<String> mycartproducts=new ArrayList<String>();
		String mycountry="India";
		LoginScreen loginScreen=new LoginScreen(driver);
		ProductPage productpage= loginScreen.Login((String)(input.get("email")),(String)(input.get("pass")));
		String Logintext=loginScreen.ValidateLogin();
		Assert.assertEquals(Logintext, "Login Successfully");
		Thread.sleep(2000);
		productpage.AddingproductstoCart(myproducts);
		Thread.sleep(2000);
		Cartpage cartpage= productpage.Gotocart();
		List<String> cartproducts=cartpage.checkcart(mycartproducts);
		Assert.assertTrue(cartproducts.containsAll(myproducts) &&
	            myproducts.containsAll(cartproducts));
		bankinformation bankinformation=cartpage.checkouticon();
		bankinformation.bankdetails(mycountry);
		confirmationpage confirmationpage=bankinformation.placingorder();
		String confirmationmessage= confirmationpage.getconfirmationmessage();
		Assert.assertEquals(confirmationmessage.toLowerCase(), ("Thankyou for the order.").toLowerCase(), "Order confirmed with correct message");
	}	
	
	
@DataProvider

public Object[][] getData() throws IOException {
	
	Readjson rj=new Readjson();
	List<HashMap<Object, Object>>data=rj.jsontoHashmap(System.getProperty("user.dir")+"\\src\\test\\java\\com\\savitha\\selenium\\selenium_framwork\\data\\getdata.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
}

}



