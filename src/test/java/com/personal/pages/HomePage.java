package com.personal.pages;


import org.openqa.selenium.By;

public class HomePage extends Page {


	private By customerLoginbtnLocator = By.cssSelector("div > div:first-child > button.btn.btn-primary.btn-lg");
	private By bankManagerLoginbtnLocator= By.cssSelector("div > div:last-child > button.btn.btn-primary.btn-lg");
	

	

	public CustomerPage enterCustomerLoginPage() {
		
		click(customerLoginbtnLocator, "customerLoginbtnLocator");
		return new CustomerPage();
	}
	
	public BankManagerPage enterBankManagerLoginPage() {
		
		
		click(bankManagerLoginbtnLocator, "bankManagerLoginbtnLocator", 5, "visibilityOfElementLocated");
		return new BankManagerPage();
	}

	

}
