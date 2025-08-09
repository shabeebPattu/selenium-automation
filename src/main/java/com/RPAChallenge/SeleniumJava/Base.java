package com.RPAChallenge.SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Base {
	public WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.get("https://rpachallenge.com/");
		driver.manage().window().fullscreen();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	

}
