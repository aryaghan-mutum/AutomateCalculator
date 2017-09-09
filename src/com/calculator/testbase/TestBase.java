package com.calculator.testbase;

/*
 * Author: Anurag Muthyam aka (polta)
 */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	protected WebDriver driver ;
	private long timeStart;
	private long timeEnd;
	private String url = "file:///Users/anuragmuthyam/Documents/workspace/AutomateCalcApp/CalculatorApp/index.html";
	private String browser = "chrome";
	
	@BeforeMethod //setup the application 
	public void setup(){
		getWebDriver();
		navigatetoPage();
		applyTimeOuts();
		
		timeStart = System.currentTimeMillis();
		System.out.println("START TIME : " + timeStart + " ms ");
	}
	
	@AfterMethod 	//Quit the browser
	public void tearDown(){
		try{
			driver.quit();
		}catch(Exception ex){
			System.out.println("Exception: " + ex);
		}	
		
		timeEnd = System.currentTimeMillis();
		System.out.println("END TIME (ms) : " + timeEnd + " ms ");
	    long timeDiff = (timeEnd - timeStart);
		System.out.println("Time Difference : " + timeDiff + " ms ");
	    Assert.assertTrue((timeDiff / 1000 < 1));
	}
	
	//apply implicit waits and age load timeout 
	private void applyTimeOuts() {
		driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);		
	}
	
	//navigate to the provided link
	private void navigatetoPage() {
		driver.get(url);
		driver.manage().window().maximize();		
	}
	
	//user can select cross browser platform chrome or firefox to display the application
	private void getWebDriver() {
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
			driver = new FirefoxDriver();
		}		
	}
	

}
