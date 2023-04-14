package com.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Basics {
	
	/* 
	 * Following are sequence of execution 
	 * 
	 * @BeforeSuite
	 * @BeforeTest
	 * @BeforeClass
	 * 
	 * @BeforeMethod
	 * @test 1
	 * @AfterMethod
	 *
	 * @BeforeMethod
	 * @test 2
	 * @AfterMethod 
	 * 
	 * @AfterClass
	 * @AfterTest
	 * @AfterSuite
	 * 
	 */
	
	
	
	
	@BeforeSuite
	public void setUp() {
		System.out.println("Setup system property for chrome");
	}
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launch the browser");
	}

	@BeforeClass
	public void login() {
		System.out.println("login to web-app");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("Enter the URL");
	}
	
	@Test(priority =1)
	public void googleTitleTest() {
		System.out.println("Google Title Test");
	}
	@Test
	public void amazonTitleTest() {
		System.out.println("Amazon Title Test");
	}
	@Test
	public void microsoftTitleTest() {
		System.out.println("Microsoft Title Test");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("logout from the web-app");
	}
	@AfterTest
	public void deleteAllCookies() {
		System.out.println("deleteAllCookies");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("closeBrowser");
	}
	@AfterSuite
	public void generateTestReport() {
		System.out.println("generateTestReport");
	}

}
