package com.personal.pages;

import org.openqa.selenium.By;

public class BankManagerPage extends Page{


	
	
	private By AddCustomerTabLocator = By.xpath("//button[@ng-click='addCust()']");
	private By openAccountTabLocator= By.xpath("//button[@ng-class='btnClass2']");
	private By searchCustomerstTabLocator = By.xpath("//button[@ng-class='btnClass3']");
	
	private By firstNameLocator = By.cssSelector("input[placeholder='First Name']");
	private By lastNameLocator= By.cssSelector("input[placeholder='Last Name']");
	private By pincodeLocator = By.cssSelector("input[placeholder='Post Code']");
	private By addCustomerBtnLocator = By.xpath("//button[@type='submit']");



	public CustomerPage enterAddCustomersTab() {
		
		click(AddCustomerTabLocator, "AddCustomerTabLocator");
		return new CustomerPage();           // WHY I AM UNABLE TO USE THIS
		
	}
	
	public CustomerPage openAccountUnderBankManagerLogin() {
		click(openAccountTabLocator, "openAccountTabLocator", 5, "visibilityOfElementLocated");
		return new CustomerPage();
	}
	
	public CustomerPage seachCustomersUnderBankManagerLogin() {
		click(searchCustomerstTabLocator, "searchCustomerstTabLocator");
		return new CustomerPage();
	}
	
	public CustomerPage addCustomer(String firstName, String lastName, String pincode) {
		setFirstName(firstName);
		setLastName(lastName);
		setPincode(pincode);
		addCustomerBtn();
		
		alert("accept"); 
		return new CustomerPage();
	}
	
	private CustomerPage setFirstName(String firstName)
	{
		type(firstNameLocator,firstName,"firstNameLocator",4, "elementToBeClickable" );
		return new CustomerPage();
		
	}
		
	private CustomerPage setLastName(String lastName)
	{
		type(lastNameLocator,lastName,"lastNameLocator");
		return new CustomerPage();
				
	}
	
	private CustomerPage setPincode(String pincode)
	{
		type(pincodeLocator,pincode,"pincodeLocator");
		return new CustomerPage();
	}
	
	private CustomerPage addCustomerBtn()
	{
		click(addCustomerBtnLocator, "addCustomerBtnLocator");
		return new CustomerPage();
		
	}
	
	

}
