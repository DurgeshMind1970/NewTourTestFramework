package com.newtours.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.newtour.genericfunctions.BusinessFunctions;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.pages.FlightFinder;
import com.newtour.utilities.LogUtility;
import com.newtour.utilities.VerifyResults;

public class TC4_FindaFlight extends GenericFunctions
{
	@Test
	public void tC4_FindaFlight() 
	{
		Hashtable<String, String> result=null;
		
		try{

			//login to the application with valid credentials
			TC2_LoginWithValidCredentials tc2_LoginWithValidCredentials=new TC2_LoginWithValidCredentials();
			tc2_LoginWithValidCredentials.tC2_loginWithValidCredentials();
			
			//step : Find a Flight
			GenericFunctions.StepID=GenericFunctions.f_stepGenerator(GenericFunctions.StepID);
			GenericFunctions.StepDescription="Find Flight";
			
			FlightFinder flightFinder=new FlightFinder();
			
			result = BusinessFunctions.f_flightFinder("roundtrip","2","New York", "Paris");
			VerifyResults.f_isPASS(result.get("status"), result.get("message"));
			
			
		}
		catch(Exception e)
		{
			VerifyResults.f_isPASS("FAIL", GenericFunctions.StepDescription);
			LogUtility.f_writeResults("FAIL"+", "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription+", Exception: "+e.getMessage());
		
			
		}
	}

}
