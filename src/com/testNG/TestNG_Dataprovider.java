package com.testNG;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class TestNG_Dataprovider {
	
	
	/*
	 * create an excel file with data
	 * create a class to get the data from the excel file (name it as getData)
	 * The use that in the test
	 * @Test(dataprovider ="getData")
	 * testcase - LoginTest(Username, Password)
	 */
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\yasar\\chromedriver\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://sit-spa.accuv.com/");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider ="getTestData")
	public void accuvLoginTest(String UN,String PWD) {
		WebElement Username=driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement Password=driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement nextBtn=driver.findElement(By.xpath("//input[@value='Next']"));
		WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Log in']"));
		Username.sendKeys("");
		nextBtn.click();
		Password.sendKeys("");
		loginBtn.click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
