package com.newtour.utilities;

import java.io.File;



import org.apache.commons.io.FileUtils;
//import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.ReportUtility.LOGSTATUS;

public class CaptureScreenshot extends GenericFunctions
{
	public static void f_takeScreenshot(ITestResult result)
	{
			/*TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			 try 
			 {
					FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"\\SCREENSHOTS\\"+result.getName()+GenericFunctions.StepID+".png"));
			 } 
			 catch (Exception e) 
			 {
					LogUtility.f_writeResults(GenericFunctions.StepID +" "+GenericFunctions.StepDescription+", "+",  Exception any:"+e.getMessage());
					ReportUtility.f_writeResult(LOGSTATUS.FAIL, "FAIL: "+GenericFunctions.StepDescription+", "+",  Exception any:"+e.getMessage());
			 }*/
			 
			 
	}
	

}
