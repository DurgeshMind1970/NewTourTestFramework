package com.newtours.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;
import com.newtour.utilities.LogUtility;
import com.newtour.utilities.PropertyUtility;
import com.newtour.utilities.ReportUtility;
import com.newtour.utilities.XMLUtility;

public class Initializer extends GenericFunctions
{
	@Test
	public void initializerTest() 
	{
		try
		{
			//generate/update log file name in xml
			XMLUtility.f_createLogxml();
			
			// create log file by creating object of HSLog class
			LogUtility logutility=new LogUtility();
			
			LogUtility.f_writeResults("[ "+GenericFunctions.f_generateRandomNumber()+" ] -------------------------------------------Log file Created----------------------------------------------");
	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getLocalizedMessage();
		}
	}

}
