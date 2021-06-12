package com.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.personal.base.BaseClass;


public class Page extends BaseClass{
	
	
		
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	private WebElement homebtn;
	private By homebtnLocator = By.xpath("//button[@class='btn home']");
	
	
	

	
		public HomePage goToHomePage() {
			homebtn= driver.findElement(homebtnLocator);
			homebtn.click();		
			return new HomePage();
		}
	
		

}




