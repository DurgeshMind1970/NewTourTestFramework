package com.newtours.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.newtour.genericfunctions.BusinessFunctions;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.pages.EditProfile;
import com.newtour.pages.FlightFinder;
import com.newtour.pages.SignOn;
import com.newtour.pages.Welcome;
import com.newtour.utilities.LogUtility;
import com.newtour.utilities.VerifyResults;


public class TC3_ProfileEdit extends GenericFunctions {
	
	
	@Test
	public void tC3_ProfileEdit() 
	{
		Hashtable<String, String> result=null;
		
		try{

			//login to the application with valid credentials
			TC2_LoginWithValidCredentials tc2_LoginWithValidCredentials=new TC2_LoginWithValidCredentials();
			tc2_LoginWithValidCredentials.tC2_loginWithValidCredentials();
			
			//step : click on Profile link
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Profile link";
			
			FlightFinder flightFinder=new FlightFinder();
			
			FlightFinder.f_clickOnProfileLink();
			
			//Step : verify that Edit Profile page is displayed
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Verify that Edit Profile page is displayed";
			
			result=GenericFunctions.f_verifyPage(EditProfile.pageTitle);
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
			
			//step : enter all the data on the edit profile page
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Enter all the data on the edit profile page and click on the Submit button";
			
			result=BusinessFunctions.f_enterProfileInformation();
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
			
			// click on the sign off button
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Sign Off link";
			
			Welcome welcome= new Welcome();
			
			Welcome.f_clickOnSignoffLink();
			
			//step 2: Click on the SignOn
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Sign On link";
			
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
			
			//step : click on Profile link
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Click on the Profile link";
			
			FlightFinder.f_clickOnProfileLink();
			
			//Step : verify that Edit Profile page is displayed
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Verify that Edit Profile page is displayed";
			
			result=GenericFunctions.f_verifyPage(EditProfile.pageTitle);
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	
			//step: verify if edited profile is displayed
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Verify if edited profile is displayed";
			
			//we will check only firest name and last name
			if(EditProfile.f_getFirstname().equals("") && EditProfile.f_getLastname().equals(""))
			{
				VerifyResults.f_isPASS("FAIL", "Edited Information is not displayed");
				
			}
			else
			{
				VerifyResults.f_isPASS("PASS", "Edited Information is displayed");
			}
		
		}
		catch(Exception e){
			VerifyResults.f_isPASS("FAIL", GenericFunctions.StepDescription);
			LogUtility.f_writeResults("FAIL"+", "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription+", Exception: "+e.getMessage());
		}
		
		
	}

}
