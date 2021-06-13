package com.personal.testcases;

import org.testng.annotations.Test;
import com.personal.base.BaseClass;
import com.personal.pages.BankManagerPage;
import com.personal.utilities.ExcelRead;

public class OpenAccountTest extends BaseClass{

	
	
	@Test(dataProviderClass = ExcelRead.class, dataProvider = "excelData", description = "BANK MANAGER LOGIN > OPEN CUSTOMER TAB - opening multiple customers account", groups={"CustomerLoginMethodPrerequisites"}, dependsOnGroups={"openAccountMethodPrerequisites"})
	public void openAccountMethod(String name, String currency) throws InterruptedException
	{
		
		
		BankManagerPage bankManagerPage= new BankManagerPage();
		bankManagerPage.openAccount(name, currency);

	}
	
	
}
