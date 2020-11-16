package com.workday.product.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	
public static ExtentReports extents;



public static ExtentReports createReport(String filepath) {
	ExtentHtmlReporter htmlReport= new  ExtentHtmlReporter(filepath);
	extents= new  ExtentReports();
	
	
	
	// ExtentHtmlReporter reporter is for setting up look and feel environment.
	htmlReport.config().setDocumentTitle("Automation Report"); // Tile of report
	htmlReport.config().setDocumentTitle("salesforce automation suits");
	htmlReport.config().setReportName("Functional Testing"); // Name of the report
	htmlReport.config().setDocumentTitle("utf-8");
	
	// reporter.config().setTheme(Theme.STANDARD);
	htmlReport.config().setTheme(Theme.DARK);
	
	
	//ExtentReports extent; is setting environment with the help of java system class. 
	extents.setSystemInfo("User name", System.getProperty("user.name"));
	extents.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	extents.setSystemInfo("User Location", System.getProperty("user.country"));
	extents.setSystemInfo("OS name", System.getProperty("os.name"));
	extents.setSystemInfo("OS version", System.getProperty("os.version"));
	extents.setSystemInfo("JDK version", System.getProperty("java.version"));
	extents.setSystemInfo("Selenium version", "3.141.59");
	extents.setSystemInfo("Maven version", "3.15"); // you can write any thing.
	extents.setSystemInfo("Browser name", "chrome");
	
	extents.attachReporter(htmlReport);
	
	return extents;
	
}

}
