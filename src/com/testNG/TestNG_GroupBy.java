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

public class TestNG_GroupBy {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yasar\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
	}
	
	@Test(priority=1,groups="Title")
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test(priority=1,groups="Logo")
	public void googleLogoTest() {
		WebElement logo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		boolean logoPresent=logo.isDisplayed();
		Assert.assertTrue(logoPresent);
	}
	@Test(priority=1,groups="Search")
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
	
	@Test(priority=1,groups="Test")
	public void Test_3() {
		System.out.println("Test 3");
	}
	
	@Test(priority=1,groups="Test")
	public void Test_4() {
		System.out.println("Test 4");
	}
	
	@Test(priority=1,groups="Test")
	public void Test_5() {
		System.out.println("Test 5");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
