package com.newtours.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.newtour.genericfunctions.BusinessFunctions;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.genericfunctions.GenericFunctions.EXPORTEDDATASHEET;
import com.newtour.pages.SignOn;
import com.newtour.pages.Welcome;
import com.newtour.utilities.ExcelUtility;
import com.newtour.utilities.LogUtility;
import com.newtour.utilities.VerifyResults;

public class TC2_LoginWithValidCredentials 
{
	Hashtable<String, String> result=null;
	
	@Test
	public void TC2_loginWithValidCredentials() 
	{
		String username="";
		String password="";
		
		try{
			//Step 1: launch application
			GenericFunctions.StepID="StepID 0";
			GenericFunctions.StepDescription="Launch Application";
			
			result=GenericFunctions.f_launchApp("chrome");
			
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
			
			//step 2: Click on the SignOn
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Sign On link";
			
			Welcome welcome= new Welcome();
			
			Welcome.f_clickOnSignonLink();
			
			//step3: Verify that Sign On page is displayed
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Verify that Sign On page is displayed";
			
			result=GenericFunctions.f_verifyPage(SignOn.pageTitle);
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
			
			//step4: Verify login functionality with valid credentials
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Verify login functionality with valid credentials";
			
			result=BusinessFunctions.f_login();
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
		
		}
		catch(Exception e)
		{
			VerifyResults.f_isPASS(result.get("status"), result.get("actualResult"));
			LogUtility.f_writeResults(result.get("status")+", "+GenericFunctions.StepID+": "+result.get("message")+", Exception: "+e.getLocalizedMessage());
	
		}
		
		
	}
}
