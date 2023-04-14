package com.testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Priority {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yasar\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}
	
	/*
	 *If priority is set same for the tests the it will execute based on the alphabetical order 
	 */
	
	@Test(priority=1)
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=1)
	public void googleLogoTest() {
		WebElement logo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		boolean logoPresent=logo.isDisplayed();
		Assert.assertTrue(logoPresent);
	}
	@Test(priority=1)
	public void googleSearchTest() {
		WebElement enterTheSearchText = driver.findElement(By.xpath("//input[@class='gLFyf']"));
		enterTheSearchText.sendKeys("C# Tutorial");
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ESCAPE);
		
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		
		String searchPageTitle=driver.getTitle();
		System.out.println(searchPageTitle);
		Assert.assertEquals("C# Tutorial - Google Search",searchPageTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
