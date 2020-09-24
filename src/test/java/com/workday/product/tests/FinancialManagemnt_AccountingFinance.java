package com.workday.product.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinancialManagemnt_AccountingFinance {
	

@Test
public void fmTest() {
	product();
}

	public static WebElement product() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.workday.com/");
		driver.findElement(By.xpath("//nav[@class='cmp-navigation menu']//span[contains(text(),'Products')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Accounting, payables, receivables, cash and asset')]")).click();
		WebElement ele1=driver.findElement(By.xpath("//div[@class='hotspot']//a[contains(text(),'Financial Management')]"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ele1));
		WebElement cliclable=driver.findElement(By.xpath("//a[contains(text(),'Accounting and Finance')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		action.moveToElement(cliclable).click().build().perform();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		String expectedTitle=driver.getTitle();
		System.out.println("title is :"+expectedTitle);
		String actualTitle="Enterprise Accounting and Finance Software | Workday";
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("test pass");
		}else {System.out.print("test fail");}
		
		driver.quit();
		return null;

		
	}
}
