package com.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.personal.base.BaseClass;


public class Page extends BaseClass{
	
	
		
	WebDriver driver;
	WebDriverWait wait;
	
	
	

	private By homebtnLocator = By.xpath("//button[@class='btn home']");
	
	
	

	
		public HomePage goToHomePage() {
			click(homebtnLocator, "homebtnLocator");	
			return new HomePage();
		}
	
		

}




