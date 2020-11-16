package com.workday.product.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinancialManagemnt_AuditAndControls {

	
	
	@Test
	public void auditTest() {
		auditAndFinance();	
	}
public  WebElement auditAndFinance() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.workday.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement product=driver.findElement(By.xpath("//ul[@class='cmp-navigation__group']//span[contains(text(),'Products')]"));
	Actions act = new Actions(driver);
	act.moveToElement(product).build().perform();
	WebElement FM=driver.findElement(By.xpath("//span[contains(text(),'Accounting, payables, receivables, cash and asset')]"));
	act.moveToElement(FM).click().build().perform();
	WebElement Finance= driver.findElement(By.xpath("(//a[contains(text(),'Financial Management')])[2]"));
	act.moveToElement(Finance).build().perform();
	WebElement Audit_Controls=driver.findElement(By.xpath("//a[contains(text(),'Audit and Internal Controls')]"));
	act.moveToElement(Audit_Controls).click().build().perform();
	String ExpectedTitle=driver.getTitle();
	System.out.println("Expected title is: "+ ExpectedTitle);
	String AcutatTitle= "Accounting Audit and Internal Controls Software | Workday";
	if(ExpectedTitle.equalsIgnoreCase(AcutatTitle)) {
		System.out.println("test pass");
	}else {System.out.println("test fail");}
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement audit=driver.findElement(By.xpath("//a[contains(text(),'audit and internal controls')]"));
	wait.until(ExpectedConditions.elementToBeClickable(audit)).click();
	int size=driver.findElements(By.tagName("iframe")).size();
	System.out.println(" iframe size is "+size);
	
	
	//driver.switchTo().frame(0);

	
	//int Innersize=driver.findElements(By.tagName("iframe")).size();
	//System.out.println(" iframe nsize is "+Innersize);

	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Lead[FirstName]")));
		
		driver.findElement(By.xpath("//input[@id='Lead[FirstName]']")).sendKeys("Faruq");
		
		driver.findElement(By.xpath("//input[@id='Lead[LastName]']")).sendKeys("Molla");
		
		driver.findElement(By.xpath("//input[@id='Lead[Lead[Email]]']")).sendKeys("Faruq");
		
		driver.findElement(By.xpath("//input[@id='Lead[FirstName]']")).sendKeys("Faruq");
		
		driver.findElement(By.xpath("//input[@id='Lead[FirstName]']")).sendKeys("Faruq");
		
		driver.findElement(By.xpath("//input[@id='Lead[FirstName]']")).sendKeys("Faruq");
		
		//input[@id='Lead[FirstName]
	// need work on 

	return null;
	
}
}
