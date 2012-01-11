package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;

public class InitializeDriver {
	private WebDriver driver;
	
	public WebDriver GetAndroidDriver()
	{
		driver = new AndroidDriver(); 
		return driver;
	}

}
