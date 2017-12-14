package com.newtour.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;
import com.newtour.utilities.ReportUtility.LOGSTATUS;
import com.thoughtworks.selenium.webdriven.commands.CaptureScreenshotToString;

public class TestListener implements ITestListener 
{

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("OnTestStart");
		
		String execute=result.getTestContext().getCurrentXmlTest().getParameter("Execute");
			
		//extent report
		ReportUtility.test= ReportUtility.report.createTest(result.getName());
		
		//log4j
		try {
			LogUtility logutility= new LogUtility();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(execute.equalsIgnoreCase("YES"))
			{
				//write in report
				ReportUtility.f_writeResult(LOGSTATUS.INFO, "Started Test Case: "+ result.getName());
				
				//write in log
				LogUtility.f_writeResults("["+  GenericFunctions.f_generateRandomNumber() + "] Started Test Case: "+result.getName());
				
			}
			else
			{
				throw new SkipException(result.getName());
			}
		} 
		

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		//write in report
		ReportUtility.f_writeResult(LOGSTATUS.FAIL, GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
		
		//write in log
		LogUtility.f_writeResults("FAIL , "+GenericFunctions.StepID+": "+GenericFunctions.StepDescription);
		
		//take screenshot
		CaptureScreenshot.f_takeScreenshot(result);
		
		//attach screenshot in the report
		try
		{
			String imagePath=System.getProperty("user.dir")+"\\SCREENSHOTS\\"+result.getName()+GenericFunctions.StepID+".png";
			ReportUtility.test.addScreenCaptureFromPath(imagePath);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{	
		//System.out.println("Test Skipped: "+result.getName());
		
		//write in report
		ReportUtility.f_writeResult(LOGSTATUS.SKIP, "SKIPPED TEST CASE: "+result.getName());
		
		//write in log
		LogUtility.f_writeResults("["+  GenericFunctions.f_generateRandomNumber() + "] SKIPPED TESTCASE: "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		//System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		ReportUtility.f_writeResult(LOGSTATUS.INFO, "Test Case Completed");
		ReportUtility.report.flush();
		
		LogUtility.f_writeResults("["+GenericFunctions.f_generateRandomNumber()+"] "+"Test Case Completed");
	}

}
