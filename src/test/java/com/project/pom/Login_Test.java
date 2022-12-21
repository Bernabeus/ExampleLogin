package com.project.pom;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login_Test {
	
	private WebDriver driver;
	private ReadExcel readFile;
	static ExtentTest test;
	static ExtentReports report;
	private String[][] searchUserP;
	
	LoginPage loginPage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		report = new ExtentReports(System.getProperty("user.dir") + "\\Reporte_resultados_pruebas.html");
		test = report.startTest("TestSwagLabs");
	}

	
	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		readFile = new ReadExcel();
		loginPage.visit("https://www.saucedemo.com/");
		String filepath = "./Usuarios.xlsx";
		searchUserP = readFile.readExcelF(filepath, "Hoja1");
	}


	@Test
	public void test0() throws InterruptedException, IOException {
		
		loginPage.loginUser(searchUserP[0][0], searchUserP[0][1]);
		String url = loginPage.loginMessage();
	
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de primera sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", loginPage.loginMessage());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el primer test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
		
	}
	
	@Test
	public void test1() throws InterruptedException, IOException {
		
		loginPage.loginUser(searchUserP[1][0], searchUserP[1][1]);
		
		String url = loginPage.loginMessage();
	
		
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de segunda sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", loginPage.loginMessage());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el segundo test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
		
	}
	
	@Test
	public void test2() throws InterruptedException, IOException {
		
		loginPage.loginUser(searchUserP[2][0], searchUserP[2][1]);
		
		String url = loginPage.loginMessage();
	
		
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de tercera sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", loginPage.loginMessage());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el tercer test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
		
	}
	
	@Test
	public void test3() throws InterruptedException, IOException {
		
		loginPage.loginUser(searchUserP[3][0], searchUserP[3][1]);
		String url = loginPage.loginMessage();
	
		
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de cuarta sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", loginPage.loginMessage());
			driver.quit();
		} else {
			test.log(LogStatus.FAIL, "Prueba fallida en el cuarto test");
			driver.quit();
			assertEquals("https://www.saucedemo.com/inventory.html", url);
			
		}
		
	}
	
	@Test
	public void test4() throws InterruptedException, IOException {
		/*
		for (int i = 0; i < searchUserP.length; i++)
        {
            for (int j = 0; (searchUserP[i] != null && j < searchUserP[i].length); j++) {
                System.out.print(searchUserP[i][j] + " ");
            }
 
            System.out.println();
        }*/
		
		loginPage.loginUser(searchUserP[4][0], searchUserP[4][1]);
		
		String url = loginPage.loginMessage();
	
		
		if (url.equals("https://www.saucedemo.com/inventory.html")) {
			test.log(LogStatus.PASS, "Inicio de quinta sesion correcto");
			assertEquals("https://www.saucedemo.com/inventory.html", loginPage.loginMessage());
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
