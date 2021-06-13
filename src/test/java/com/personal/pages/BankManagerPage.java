package com.personal.pages;

import org.openqa.selenium.By;

public class BankManagerPage extends Page{

	
 
 
 //----------------add customer tab-------------------------// 
 
	private By addCustomerTabLocator = By.xpath("//button[@ng-click='addCust()']");
	private By firstNameLocator = By.cssSelector("input[placeholder='First Name']");
	private By lastNameLocator= By.cssSelector("input[placeholder='Last Name']");
	private By pincodeLocator = By.cssSelector("input[placeholder='Post Code']");
	private By addCustomerBtnLocator = By.xpath("//button[@type='submit']");
	
 public BankManagerPage enterAddCustomersTab() {
		
		click(addCustomerTabLocator, "AddCustomerTabLocator");
		return new BankManagerPage();           // WHY I AM UNABLE TO USE THIS
		
	}
 
 
	public BankManagerPage addCustomer(String firstName, String lastName, String pincode) {
		setFirstName(firstName);
		setLastName(lastName);
		setPincode(pincode);
		clickAddCustomerBtn();
		
		alert("accept"); 
		return new BankManagerPage();
	}
	
	private BankManagerPage setFirstName(String firstName)    
	{
		type(firstNameLocator,firstName,"firstNameLocator",4, "elementToBeClickable" );
		return new BankManagerPage();
		
	}
		
	private BankManagerPage setLastName(String lastName)
	{
		type(lastNameLocator,lastName,"lastNameLocator");
		return new BankManagerPage();
				
	}
	
	private BankManagerPage setPincode(String pincode)
	{
		type(pincodeLocator,pincode,"pincodeLocator");
		return new BankManagerPage();
	}
	
	private BankManagerPage clickAddCustomerBtn()
	{
		click(addCustomerBtnLocator, "addCustomerBtnLocator");
		return new BankManagerPage();
		
	}


	
//------------------open account tab-----------------------// 
	
	private By openAccountTabLocator= By.xpath("//button[@ng-class='btnClass2']");
	private By customerDropDownLocator = By.id("userSelect");
	private By currencyLocator = By.id("currency");
	private By submitLocator = By.cssSelector("button[type='submit']");
	
	
	

	
	public HomePage openAccount(String name, String currency) {   // after this we are going to home page
		openAccountTab();
		setName(name);
		setcurrency(currency);
		clickSubmitBtn();
		alert("accept");
		return new HomePage();
		
	}
	
	public BankManagerPage openAccountTab() {
		click(openAccountTabLocator, "openAccountTabLocator", 5, "visibilityOfElementLocated");
		return new BankManagerPage();
	}
	
	private BankManagerPage setName(String name)
	{
		staticDropDown(customerDropDownLocator, name, "customerDropDownLocator");
		return new BankManagerPage();
				
	}
	
	private BankManagerPage setcurrency(String currency)
	{
		staticDropDown(currencyLocator, currency, "currencyLocator");
		return new BankManagerPage();
		
	}
	
	private BankManagerPage clickSubmitBtn()
	{
		click(submitLocator, "submitLocator");
		return new BankManagerPage();
		
	}
	
//------------------customer tab-----------------------// 
	
		private By searchCustomerstTabLocator = By.xpath("//button[@ng-class='btnClass3']");
		
	public BankManagerPage seachCustomerTab() {
		click(searchCustomerstTabLocator, "searchCustomerstTabLocator");
		return new BankManagerPage();
	}


	
	
	

}
