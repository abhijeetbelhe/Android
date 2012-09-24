package com.example.tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.driver.InitializeDriver;
import com.example.pages.HomePage;


/**
 * @author Nishant Verma, mail me: nishuverma@gmail.com
 * Befor running these test make sure you run this command "adb forward tcp:8080 tcp:8080" and 
 * start WebDriver App on Android Device 
 *
 */
public class SearchFunctionality {
	private WebDriver driver;
	
	
	@Before
	public void setUp() throws Exception {
		InitializeDriver init = new InitializeDriver();
		driver = init.GetAndroidDriver();
		driver.navigate().to("http://m.flipkart.com");
	}

	
	@Test
	public void SearchForMobile() {
		HomePage homePage = new HomePage(driver);
		homePage.search("Samsung Galaxy S2");
		assertTrue(driver.findElements(By.linkText("Samsung Galaxy S 2 I9100 (Noble Black)")).get(0).getText().contains("Samsung Galaxy S 2 I9100 (Noble Black)"));
	}
	
	@Test
	public void SearchForBook(){
		HomePage homePage = new HomePage(driver);
		WebElement bookCategory =  driver.findElements(By.className("namebs")).get(0);
		bookCategory.click();
		homePage.search("Steve Jobs");
		WebElement resultOfSearch = driver.findElements(By.linkText("Steve Jobs: The Exclusive Biography")).get(0);
		assertTrue(resultOfSearch.getText().contains("Steve Jobs: The Exclusive Biography"));
		WebElement buyNow = driver.findElements(By.tagName("INPUT")).get(2); 
		buyNow.click();
		assertTrue(driver.findElements(By.tagName("LABEL")).get(0).getText().contains("Email: (required)"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
}
