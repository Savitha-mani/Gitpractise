package com.savitha.selenium.selenium_framwork.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Basetest {
	Properties prop=new Properties();
	public WebDriver driver;
	FileInputStream fis;
	public Basetest() {
			try {
			fis = new FileInputStream("C:\\Users\\savit\\eclipse-workspace\\selenium-framwork\\src\\main\\java\\com\\savitha\\selenium\\selenium_framwork\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public WebDriver BrowserInit() {
	String browsername=prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("Chrome")) {
	driver=new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("firefox")){
		driver=new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;
}
	
	public String screenshotutil(String testcasename,WebDriver driver) throws IOException {
		TakesScreenshot ts=	(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"\\reports"+testcasename+"\\.png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"\\reports"+testcasename+"\\.png";
		
		}
	@BeforeMethod
	public  void gotoURL() {
		driver=BrowserInit();
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
