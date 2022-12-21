package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base{
	
	By userNameLocator = By.name("user-name");
	By passwordLocator = By.cssSelector("input[name='password']");
	By loginBtnLocator = By.id("login-button");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	public void loginUser(String user, String pass) throws InterruptedException {
		type(user, userNameLocator);
		type(pass, passwordLocator);
		click(loginBtnLocator);
		
		Thread.sleep(4000);
	}
	
	public String loginMessage() {
		/*
		List<WebElement> spans = findElements(By.tagName("span"));
		return getText(spans.get(0));*/
		return getUrl();
		
	}
	
}
