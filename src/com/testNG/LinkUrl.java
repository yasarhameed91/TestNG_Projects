package com.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LinkUrl {
	@Test
	public static void getLinkUrl(WebDriver driver, String linkText) {
    	driver = new ChromeDriver();
    	driver.get("https://en.m.wikipedia.org/wiki/Main_Page");
       // return null;
    }
}
