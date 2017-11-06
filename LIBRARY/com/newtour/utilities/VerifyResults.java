package com.newtour.utilities;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.ReportUtility.LOGSTATUS;

public class VerifyResults extends Assert 
{
	public static void f_isPASS(String actualResult, String message) throws Exception
	{	
		if (actualResult.equalsIgnoreCase("PASS")) 
		{
			//write in report
			ReportUtility.f_writeResult(LOGSTATUS.PASS, GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
			
			//write in log
			LogUtility.f_writeResults("PASS , "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
		}
		
		assertEquals("PASS", actualResult);
		
	}
	
	public static void f_softIsPass(String actualResult, String message) throws Exception
	{
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals("PASS", actualResult);
		
		if (actualResult.equalsIgnoreCase("PASS")) 
		{
			//write in report
			ReportUtility.f_writeResult(LOGSTATUS.PASS, GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
			
			//write in log
			LogUtility.f_writeResults("PASS , "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
		}
		else
		{
			//write in report
			ReportUtility.f_writeResult(LOGSTATUS.FAIL, GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
			
			//write in log
			LogUtility.f_writeResults("FAIL , "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
		}
		
	}
	
	
}
