package com.personal.testcases;

import org.testng.annotations.Test;

import com.personal.base.BaseClass;
import com.personal.pages.BankManagerPage;
import com.personal.pages.HomePage;
import com.personal.utilities.ExcelRead;

public class AddCustomerTest extends BaseClass {

	
	
	
	@Test(description = "BANK MANAGER LOGIN - login as bank manager and checking availability of ADD CUSTOMER TAB on screen")
	public void loginAsmanagerTest() {

		  
		
		HomePage homePage = new HomePage();
		homePage.enterBankManagerLoginPage()
		.enterAddCustomersTab();           // this is called FLUID SYNTAX

		checkPageTitle("Protractor practice website - Banking App","softAssert");
		
		

	}
	
	@Test(dataProviderClass = ExcelRead.class, dataProvider = "excelData", dependsOnMethods = { "loginAsmanagerTest" }, description = "BANK MANAGER LOGIN > ADD CUSTOMER TAB - adding multiple customers",groups={"openAccountMethodPrerequisites"})
	public void addMultipleCustomerTest(String firstName, String lastName, String pincode){
		
		
		
		BankManagerPage bankManagerPage= new BankManagerPage();
		bankManagerPage.addCustomer(firstName, lastName, pincode);
		
		 
		
	}
	


}
