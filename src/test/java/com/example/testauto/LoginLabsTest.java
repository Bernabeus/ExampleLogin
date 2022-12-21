package com.example.testauto;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginLabsTest {

	private WebDriver driver;

	By userNameLocator = By.name("user-name");
	By passwordLocator = By.cssSelector("input[name='password']");
	By loginBtnLocator = By.id("login-button");

	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.value", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void testLogin0() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("standard_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);

		String url = driver.getCurrentUrl();

		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de primera sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el primer test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
	}

	@Test
	public void testLogin1() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("locked_out_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de sesion correcto ");
			assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
			driver.quit();
		} else {
			test.log(LogStatus.ERROR, "Prueba fallida en el segundo test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
		
	}


	@Test
	public void testLogin2() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("problem_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		Thread.sleep(4000);
		/*List<WebElement> spans = driver.findElements(By.tagName("span"));

		if (!spans.isEmpty()) {
			assertEquals("PRODUCTS", spans.get(0).getText());
			if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
				test.log(LogStatus.PASS, "Inicio de sesion correcto 3");
				driver.quit();
			}
		} else {
			driver.quit();
			test.log(LogStatus.FAIL, "Prueba fallida");
		}*/
		
		String url = driver.getCurrentUrl();

		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de tercera sesion correcto ");
			assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el tercer test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
	}

	@Test
	public void testLogin3() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("performance_glitch_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		Thread.sleep(4000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de cuarta sesion correcto ");
			assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el cuarto test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
	}

	@Test
	public void testLogin4() throws InterruptedException {
		driver.findElement(userNameLocator).sendKeys("performance_glitch_user");
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		driver.findElement(loginBtnLocator).click();

		Thread.sleep(4000);
		String url = driver.getCurrentUrl();

		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de quinta sesion correcto ");
			assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el quinto test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}

	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

}
