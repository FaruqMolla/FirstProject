package com.workday.product.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinancialManagemnt_ConsolidateAndClose {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		System.out.println("setting up the browser");
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.workday.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
@Test
public void closeAndCosolidateTest() {
	
	WebElement product=driver.findElement(By.xpath("//ul[@class='cmp-navigation__group']//span[contains(text(),'Products')]"));
	Actions act = new Actions(driver);
	act.moveToElement(product).build().perform();
	WebElement FM=driver.findElement(By.xpath("//span[contains(text(),'Accounting, payables, receivables, cash and asset')]"));
	act.moveToElement(FM).click().build().perform();
	WebElement finance= driver.findElement(By.xpath("(//a[contains(text(),'Financial Management')])[2]"));
	act.moveToElement(finance).build().perform();
	//WebElement close=driver.findElement(By.xpath("//a[contains(text(),'Consolidate and Close')]"));
	act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Consolidate and Close')]"))).click().build().perform();
   String expectedTitle=driver.getTitle();
   System.out.println("expected title is :"+ expectedTitle);
   String actualTitle="Financial Consolidation and Close Software | Workday";
   Assert.assertEquals(actualTitle, expectedTitle);
   System.out.println("test pass");
}

@AfterTest
public void destroy() {
	driver.close();
}
}
