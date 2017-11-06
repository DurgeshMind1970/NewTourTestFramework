package com.newtour.utilities;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.newtour.genericfunctions.GenericFunctions.PROPERTY;

public class SuiteListener implements ISuiteListener
{

	@Override
	public void onStart(ISuite suite) 
	{
		System.out.println("Suite Name: "+suite.getName() );
		//System.out.println("Total test cases in suite:" + suite.getName() + " are :"+ suite.getXmlSuite().getTests().size());
		try {
			ReportUtility.htmlreporter=new ExtentHtmlReporter(PropertyUtility.f_readProperty(PROPERTY.REPORTS)+"\\NewToursTestResult.html");
			ReportUtility.htmlreporter.setAppendExisting(true);
			ReportUtility.htmlreporter.config().setDocumentTitle("New Tours Test Result");
			ReportUtility.htmlreporter.config().setChartVisibilityOnOpen(true);
			ReportUtility.htmlreporter.config().setReportName("New Tours Test Result");
			ReportUtility.report=new ExtentReports();
			ReportUtility.report.attachReporter(ReportUtility.htmlreporter);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) 
	{
		
	}

}
