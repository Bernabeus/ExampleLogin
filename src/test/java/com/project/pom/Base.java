package com.project.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.value", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}

	// Para encontrar el elemento
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	// Para encontrar una lista de elemento
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	// Para conseguir el texto de un elemento
	public String getText(WebElement element) {
		return element.getText();
	}

	// Para conseguir el texto de un localizador
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	// Para escribir en un campo
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	// Para darle click en un elemento
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	// Para saber si el elemento esta listo para ser usado
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void visit(String url) {
		driver.get(url);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
}
