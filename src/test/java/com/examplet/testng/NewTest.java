package com.examplet.testng;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class NewTest {

	private WebDriver driver;

	By userNameLocator = By.name("user-name");
	By passwordLocator = By.cssSelector("input[name='password']");
	By loginBtnLocator = By.id("login-button");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.value", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	
	
	@Test
	public void f() {
		driver.findElement(userNameLocator).sendKeys("standard_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String url = driver.getCurrentUrl();

		assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"), "La url no coincide");
		
	}

	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	

}
