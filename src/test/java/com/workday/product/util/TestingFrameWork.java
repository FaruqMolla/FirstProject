package com.workday.product.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingFrameWork extends BaseTest{
	
	@Test
	public void test1() {
	WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.workday.com/");
	driver.findElement(By.xpath("//nav[@class='cmp-navigation menu']//span[contains(text(),'Products')]")).click();
	driver.quit();
	
	}
}
