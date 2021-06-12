package com.personal.base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

class subClass extends BaseClass{ // keep it default
	
	
	
	WebElement locator(By byEle, String locatorName, String action, String data, String nameOfCondition, int waitPeriod) {
		
		
		WebElement element = null;
		
		try {			
			
		
			
			if(nameOfCondition==null) {
				
			// here it is checking if locator present on page or not, when no condition is applied
			element=driver.findElement(byEle);
			return element;
			
			}
			
			else
			{
				
				element=conditionName(action, data, nameOfCondition, waitPeriod, byEle, locatorName);
				 return element;
			}
			
			

		}
		

		
		 catch (Exception e) { 
			
			 
			if(failmsg(byEle,locatorName, action, data, e.toString())==true)
			{return element;}
			
			else
			{
				return null;
			}
		
		 }
		
		
		
		
		
		
		
		
		
	}
	
	
	
	void passMsg( String locatorName, String action, String data, String nameOfCondition, int waitPeriod)  
	{
		
		
		
	if(nameOfCondition==null)
	{
		switch (action) {
		
			case "click":
			{
				// **** DON'T WRITE driver.getTitle(), in case there is a alert box. you will get error on driver.getTitle()
				 logger.debug("locator(" +locatorName+ ") clicked successfully");
				 test.log(Status.INFO, "locator(" +locatorName+ ") clicked successfully");
				 break;
			}
			
			case "type":
			{
				logger.debug("locator(" +locatorName+ ") filled with value '"+ data+"' successfully");
				test.log(Status.INFO, "locator(" +locatorName+ ") filled with value '"+ data+"' successfully");
				 break;
			}
			
			case "alert":
			{
				logger.debug(" Action("+ data +") successfully taken on Alert, present on page");
				test.log(Status.INFO, " Action("+ data +") successfully taken on alert, present on page ");
				
				 break;
			}
			
			case "staticDropDown":
			{
				// **** DON'T WRITE driver.getTitle(), in case there is a alert box. you will get error on driver.getTitle()
				
				logger.debug("option(" +data+ ") selected successfully on dropdown("+locatorName+")");
				test.log(Status.INFO, "option(" +data+ ") selected successfully on dropdown("+locatorName+")");
				 break;
			}
			
			case "hardassert":
			{
				logger.info("ASSERT :- locator(" +locatorName+ ") is present on page");
				test.log(Status.PASS, "ASSERT :- locator(" +locatorName+ ") is present on page");
				break;
			}
			
			case "softassert":
			{
				logger.info("VERIFY :- locator(" +locatorName+ ") is present on page");
				test.log(Status.INFO, "VERIFY :- locator(" +locatorName+ ") is present on page");
				break;
			}
	
			default:{
				
				// empty as of now
				break;
				}
		}
		
	}
	
	
	
	
	else
		{
		

		switch (action) {
		
			case "click":
			{
				// **** DON'T WRITE driver.getTitle(), in case there is a alert box. you will get error on driver.getTitle()
				logger.debug(nameOfCondition+" timeout for locator(" +locatorName+ ") set to "+ waitPeriod+" seconds. locator(" +locatorName+ ") clicked successfully");
				test.log(Status.INFO, nameOfCondition +" timeout for locator(" +locatorName+ ") set to "+ waitPeriod+" seconds. locator(" +locatorName+ ") clicked successfully");
				
				 break;
			}
			
			case "type":
			{
				logger.debug("locator(" +locatorName+ ") filled with value '"+ data+"' successfully");
				test.log(Status.INFO, "locator(" +locatorName+ ") filled with value '"+ data+"' successfully");
				 break;
			}
			
			case "alert":
			{
				logger.debug(" Action("+ data +") successfully taken on Alert, present on page");
				test.log(Status.INFO, " Action("+ data +") successfully taken on alert, present on page ");
				
				 break;
			}
			
			case "staticDropDown":
			{
				// **** DON'T WRITE driver.getTitle(), in case there is a alert box. you will get error on driver.getTitle()
				
				logger.debug("option(" +data+ ") selected successfully on dropdown("+locatorName+")");
				test.log(Status.INFO, "option(" +data+ ") selected successfully on dropdown("+locatorName+")");
				 break;
			}
	
			default:{
				
				// empty as of now
				break;
				}
		}
		
		
		
		
		
		
		
		}
	}
	
	
	Boolean failmsg(By byEle, String locatorName, String action, String data, String exception)  // keep it private
	{
		
		
		
		// just use NoSuchElement not NoSuchElementException or NoSuchElementError
		
	
		if(action.toLowerCase().equals("hardassert") && (exception.contains("NoSuchElement") || exception.contains("InvalidSelector")))
		{

			logger.error("ASSERT :- locator(" +locatorName+ ") [ "+byEle+" ] is NOT present on page.\n \n Error msg is :-   "+ exception);
			 Assert.fail("ASSERT :- locator(" +locatorName+ ") [ "+byEle+" ] is NOT present on page.\n \n Error msg is :-   "+ exception);
			
		}
		
		else if(action.toLowerCase().equals("softassert") && (exception.contains("NoSuchElement") || exception.contains("InvalidSelector")))
		{

			logger.error("VERIFY :- locator(" +locatorName+ ") [ "+byEle+" ]is NOT present on page.\n \n Error msg is :-   "+ exception);
			 test.log(Status.ERROR,"VERIFY :- locator(" +locatorName+ ") [ \"+byEle+\" ]is NOT present on page.\n \n Error msg is :-   "+ exception);
			 return false;
		}
		
		
		
		
	else if(action.equals("click") && (exception.contains("NoSuchElement") || exception.contains("InvalidSelector")))
		{

			 logger.error("locator(" +locatorName+ ")  [ "+byEle+" ] can't be clicked as it's NOT present on page."
			 		+ "\n \n Error msg is :-   "+ exception);
			 
			 Assert.fail("locator(" +locatorName+ ")  [ "+byEle+" ] can't be clicked as it's NOT present on page."
			 		+ "\n \n Error msg is :-   "+ exception);
		}
		
		else if(action.equals("type") && (exception.contains("NoSuchElement") || exception.contains("InvalidSelector")))
		{
			logger.error("locator(" +locatorName+ ")  [ "+byEle+" ]can't filled with value '"+ data+"' as locator is NOT present on page."
			 		+ "\n \n Error msg is :-   "+ exception);
			 Assert.fail("locator(" +locatorName+ ") [ "+byEle+" ] can't filled with value '"+ data+"' as locator is NOT present on page."
			 		+ "\n \n Error msg is :-   "+ exception);
		
		}
		
		else if(action.equals("alert") && exception.contains("NoAlertPresent"))
		{

			logger.error(" Action("+ data +") can't be successfully taken on Alert, as Alert is NOT present on page."
					+ "\n \n Error msg is :-   "+ exception);
			
			Assert.fail(" Action("+ data +") can't be successfully taken on Alert, as Alert is NOT present on page."
					+ "\n \n Error msg is :-   "+ exception);
		
		}
		
		else if(action.equals("staticDropDown") && exception.contains("NoSuchElementException"))
		{

			logger.error("option(" +data+ ") is NOT selected on dropdown("+locatorName+")  [ "+byEle+" ]. Either dropdown("+locatorName+") or option(" +data+ ") is NOT present on page."
					+ "\n \n Error msg is :-   "+ exception);
			
			Assert.fail("option(" +data+ ") is NOT selected on dropdown("+locatorName+") [ "+byEle+" ]. Either dropdown("+locatorName+") or option(" +data+ ") is NOT present on page."
					+ "\n \n Error msg is :-   "+ exception);
		
		}
		
		
		return true;
	}


	
	
	// i have to keep it separate , cause i can't place it anywhere else

	void checkDropDown(Select s, String selectOption, String key) {
		
		List<WebElement> op  = s.getOptions();
		List<String> newList = new ArrayList<String>();
		
		 for(int i =0; i<op.size() ; i++){
			 newList.add(op.get(i).getText());
	      }
		
		
		if( ! (newList.contains(selectOption)))
				{
					
			logger.error("option(" +selectOption+ ") is NOT selected on dropdown("+key+"). Either dropdown("+key+") or option(" +selectOption+ ") is NOT present on page.");
			Assert.fail("option(" +selectOption+ ") is NOT selected on dropdown("+key+"). Either dropdown("+key+") or option(" +selectOption+ ") is NOT present on page.");
				}
		
	}
	
	
	WebElement conditionName(String action, String data, String nameOfCondition, int waitPeriod, By byEle, String locatorName)
	{
		
		
		try {
		WebDriverWait d = new WebDriverWait(driver, waitPeriod);
	
		switch (nameOfCondition) {
		
		case "elementToBeClickable": {
			
			return d.until(ExpectedConditions.elementToBeClickable(byEle));
			
			
		}
		
		case "visibilityOfElementLocated": {
			
			return d.until(ExpectedConditions.visibilityOfElementLocated(byEle));
			
		}
		
		case "presenceOfElementLocated": {
			return d.until(ExpectedConditions.presenceOfElementLocated(byEle));
			
		}
		
		
		default:{
			logger.error(" user provided wrong condition ["+nameOfCondition+"] ."
					+ "\n Following conditions are acceptable :- \n \t 1.elementToBeClickable \n \t 2.presenceOfElementLocated \n \t 3.visibilityOfElementLocated");
			
			Assert.fail(" user provided wrong condition ["+nameOfCondition+"] .\n Following conditions are acceptable :- "
					+ "\n \t 1.elementToBeClickable \n \t 2.presenceOfElementLocated \n \t 3.visibilityOfElementLocated");
			
			break;}
		
		
		}
		}
		
		catch (TimeoutException e) { 
			
			switch (action) {
			case "click":
			{
				logger.error("locator(" +locatorName+ ") ["+byEle+"] can't be clicked as locator is either NOT present on page or ("+waitPeriod+" second) waitperiod of conditon("+nameOfCondition+") timed out "
				 		+ "\n \n Error msg is :-   "+ e.getMessage());
				 
				 Assert.fail("locator(" +locatorName+ ") ["+byEle+"] can't be clicked as locator is either NOT present on page or ("+waitPeriod+" second) waitperiod of conditon("+nameOfCondition+") timed out "
					 		+ "\n \n Error msg is :-   "+ e.getMessage());
				break;
			}

			case "type":
			{
				logger.error("locator(" +locatorName+ ") ["+byEle+"] can't be filled with data("+data+") as locator is either NOT present on page or ("+waitPeriod+" second) waitperiod of conditon("+nameOfCondition+") timed out "
				 		+ "\n \n Error msg is :-   "+ e.getMessage());
				 
				Assert.fail("locator(" +locatorName+ ") ["+byEle+"] can't be filled with data("+data+") as locator is either NOT present on page or ("+waitPeriod+" second) waitperiod of conditon("+nameOfCondition+") timed out "
				 		+ "\n \n Error msg is :-   "+ e.getMessage());
				break;
			}
			default:
				break;
			}
			
			 
			
				
			}
		return null;

	}
		
		
		
	
		
	
	
	
	

	
	
	
}
