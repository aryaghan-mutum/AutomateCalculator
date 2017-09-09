package com.calculator.test;

/*
 * Author: Anurag Muthyam aka (polta)
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.calculator.testbase.TestBase;

public class TestApp extends TestBase{

	private WebElement elem1;
	private WebElement elem2;
	private WebElement equals;
	private String str = null;
	private int result;


	@Test
	public void addNumbers() throws InterruptedException{	
		elem1 = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[2]"));  //8
		elem1.click();

		WebElement plus = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[4]")));
		plus.click();

		elem2 = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[10]"))); //2
		elem2.click();
		
	    equals = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[15]"));
		equals.click();
				
		//store the number in the result variable which is the actual value
	    str = driver.findElement(By.xpath("//*[@id='calculator']/div[1]/div")).getText();
	    result = Integer.parseInt(str);
		System.out.println("Add numbers: " + result);		
		Assert.assertEquals(result, 10);	
		
	}
	
	@Test
	public void subtractNumbers() throws InterruptedException{	
		elem1 = driver.findElement(By.xpath(".//*[@id='calculator']/div[2]/span[2]"));
		elem1.click();

		WebElement minus = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[8]")));
		minus.click();

		elem2 = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[10]")));
		elem2.click();
		
		equals = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[15]"));
		equals.click();
		
		str = driver.findElement(By.xpath("//*[@id='calculator']/div[1]/div")).getText();
		result = Integer.parseInt(str);
		System.out.println("Subtract numbers: " + result);
		Assert.assertEquals(result, 6);
	}
	
	@Test
	public void multiplyNumbers() throws InterruptedException{	
		elem1 = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[2]"));
		elem1.click();

		WebElement multiply = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[16]")));
		multiply.click();

		elem2 = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[10]")));
		elem2.click();
		
		equals = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[15]"));
		equals.click();
		
		str = driver.findElement(By.xpath("//*[@id='calculator']/div[1]/div")).getText();
		result = Integer.parseInt(str);
		System.out.println("Multiply numbers: " + result);
		Assert.assertEquals(result, 16);
	}
	
	@Test
	public void divideNumbers() throws InterruptedException{	
		elem1 = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[2]"));
		elem1.click();

		WebElement divide = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[12]")));
		divide.click();

		elem2 = driver.findElement(By.xpath(("//*[@id='calculator']/div[2]/span[10]")));
		elem2.click();
		
		equals = driver.findElement(By.xpath("//*[@id='calculator']/div[2]/span[15]"));
		equals.click();
		
		str = driver.findElement(By.xpath("//*[@id='calculator']/div[1]/div")).getText();
		result = Integer.parseInt(str);
		System.out.println("Divide numbers: " + result);
		Assert.assertEquals(result, 4);	
	}

}
