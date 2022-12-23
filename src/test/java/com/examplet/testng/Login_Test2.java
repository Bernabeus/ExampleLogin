package com.examplet.testng;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_Test2 {
	WebDriver driver;
	private ExcelRead readFile;
	private String[][] searchUserP;
	By userNameLocator = By.name("user-name");
	By passwordLocator = By.name("password");
	By loginBtnLocator = By.id("login-button");
	By btnA = By.id("react-burger-menu-btn");
	By btnlogout = By.id("logout_sidebar_link");

	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.value", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		readFile = new ExcelRead();
		String filepath = "./Usuarios.xlsx";
		searchUserP = readFile.readExcelF(filepath, "Hoja1");
	}

	@Test(dataProvider = "authenticationData")
	public void login(String email, String pass) throws InterruptedException {

		driver.findElement(userNameLocator).sendKeys(email);
		driver.findElement(passwordLocator).sendKeys(pass);
		driver.findElement(loginBtnLocator).click();

		Thread.sleep(4000);

		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
			assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
			driver.get("https://www.saucedemo.com/");

		} else {
			System.out.println("La sesion no fue logueada");
			driver.navigate().refresh();
			assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		}

	}

	@DataProvider(name = "authenticationData")
	public Object[][] getData() throws IOException {

		Object[][] data = new Object[2][2];
		for (int i = 0; i < 2; i++) {
			data[i][0] = searchUserP[i+3][0];
			data[i][1] = searchUserP[i+3][1];
		}

		return data;
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
