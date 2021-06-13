package com.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage extends Page{

	
	private By selectCustomerDropdownLocator = By.name("userSelect");
	private By loginBtnLocator = By.xpath("//button[@type='submit']");
	private By logoutBtnLocator = By.cssSelector("button.btn.logout");
	
	 public CustomerPage loginAsCustomer(String selectOption) {
			
		 selectCustomerDropdown(selectOption);
		 loginAsCustomer();
		return new CustomerPage();          
			
		}
	 
	 
	 private CustomerPage selectCustomerDropdown(String selectOption)
	 {
		 staticDropDown(selectCustomerDropdownLocator, selectOption, "selectCustomerDropdownLocator");
		 return new CustomerPage();   
	 }
	 private CustomerPage loginAsCustomer()
	 {
		 click(loginBtnLocator, "loginBtnLocator", 5, "elementToBeClickable");
		 return new CustomerPage();   
	 }
	 
	 public CustomerPage logoutAsCustomer()
	 {
		 click(logoutBtnLocator, "logoutBtnLocator", 5,"elementToBeClickable");
		 return new CustomerPage();   
	 }
	 
			 
	 
	 
	 


}
