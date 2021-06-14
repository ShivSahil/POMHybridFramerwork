package com.personal.testcases;

import org.testng.annotations.Test;

import com.personal.base.BaseClass;
import com.personal.pages.Page;

public class CustomerLoginTest extends BaseClass {

	

	
	@Test(description = "CUSTOMER LOGIN - login as customer", dependsOnGroups={"CustomerLoginMethodPrerequisites"})
	public void customerLoginMethod() throws InterruptedException {

		Page page = new Page();
		page.goToHomePage()
		.enterCustomerLoginPage()     // this is a fluid syntax
		.loginAsCustomer("Shiv Sahil")
		.logoutAsCustomer()
		.loginAsCustomer("No Cust")
		.logoutAsCustomer();

		
		// HELP WITH ASSERTIONS
		
	}
	
	
	
}
