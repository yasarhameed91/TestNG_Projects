package com.testNG;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {
    public static String getLinkUrl(WebDriver driver, String linkText) {
    	driver = new ChromeDriver();
    	driver.get("https://en.m.wikipedia.org/wiki/Main_Page");
        return null;
    }
}
