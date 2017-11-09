package com.newtours.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.newtour.genericfunctions.BusinessFunctions;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.pages.Register;
import com.newtour.pages.Welcome;
import com.newtour.utilities.LogUtility;
import com.newtour.utilities.VerifyResults;

public class TC1_RegisterToTheSite 
{
	Hashtable<String, String> result=null;
	
	@Test
	public void tC1_RegisterToTheSite() 
	{
		
		try 
		{
			//Step 1: launch application
			GenericFunctions.StepID="StepID 0";
			GenericFunctions.StepDescription="Launch Application";
			
			result=GenericFunctions.f_launchApp("chrome");
			
			VerifyResults.f_isPASS(result.get("status"), result.get("actualResult"));
			
			//step2: Click on the Register Link
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Register link";
			
			Welcome welcome=new Welcome();
			welcome.f_clickOnRegisterLink();
			
			//Step3: Enter all mandatory data on the Registration page
			
				//Verify that Registeration page is displayed
				GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
				GenericFunctions.StepDescription="Verify that Registration page is displayed";
				result=GenericFunctions.f_verifyPage(Register.pageTitle);
				VerifyResults.f_isPASS(result.get("status"), result.get("actualResult"));
				
				
				//Enter all data on the registration page
				GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
				GenericFunctions.StepDescription="Enter all information on the Registration page";
				result=BusinessFunctions.f_enterRegistrationInformation();
				VerifyResults.f_isPASS(result.get("status"), result.get("actualResult"));
				
				
				
			
			
			
		} 
		catch (Exception e) 
		{
			VerifyResults.f_isPASS(result.get("status"), result.get("actualResult"));
			LogUtility.f_writeResults(result.get("status")+", "+GenericFunctions.StepID+": "+result.get("actualResult")+", Exception: "+e.getLocalizedMessage());
		}
		
		
		
		
		
	}

}
