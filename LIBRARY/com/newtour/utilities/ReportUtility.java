package com.newtour.utilities;

import java.io.IOException;

import org.omg.stub.java.rmi._Remote_Stub;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;

public class ReportUtility 
{
	public static ExtentHtmlReporter htmlreporter=null;
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	
	public static enum LOGSTATUS {PASS, FAIL, FATAL, WARN, ERROR, INFO, SKIP}
	
	
	/**
	 *  
	 * 
	 * 
	 */
	
	public static void f_writeResult(LOGSTATUS logstatus, String message)
	{
		//remaining
		switch(logstatus.toString().toUpperCase())
		{
			case "PASS":ReportUtility.test.log(Status.PASS, message);
						break;
			case "FAIL":ReportUtility.test.log(Status.FAIL, message);
						break;
			case "SKIP":ReportUtility.test.log(Status.SKIP, message);
						break;
			case "FATAL":ReportUtility.test.log(Status.FATAL, message);
						break;
			case "INFO":ReportUtility.test.log(Status.INFO, message);
						break;
			case "ERROR":ReportUtility.test.log(Status.ERROR, message);
						break;
			case "DEBUG":ReportUtility.test.log(Status.DEBUG, message);
						break;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("started...");
		
		htmlreporter=new ExtentHtmlReporter(PropertyUtility.f_readProperty(PROPERTY.REPORTS)+"\\newtoursreport.html");
		htmlreporter.setAppendExisting(true);
		htmlreporter.config().setDocumentTitle("New Tours Report");
		htmlreporter.config().setChartVisibilityOnOpen(true);
		htmlreporter.config().setReportName("New Tours Test Result");
		
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		
		test=report.createTest("MyTest23");
		
		test.log(Status.PASS, "This is passed");
		test.log(Status.PASS, "This is passed");
		test.log(Status.PASS, "This is passed");
		test.log(Status.PASS, "This is passed");
		test.log(Status.FAIL, "This is failed");
		
		test.addScreenCaptureFromPath("D:\\MediaFiles\\status\\HLC_TC46-GrantStudentAccessNotDisplayed.png");
		
		report.flush();
		
		System.out.println("ended...");
		
	}
	
	
}
