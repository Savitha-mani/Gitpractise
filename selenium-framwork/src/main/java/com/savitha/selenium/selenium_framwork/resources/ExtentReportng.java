package com.savitha.selenium.selenium_framwork.resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
public class ExtentReportng {
	public static ExtentReports extentreportng() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Selenium report");
		reporter.config().setDocumentTitle("Index");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "Savitha");
		return reports;
	}
}
