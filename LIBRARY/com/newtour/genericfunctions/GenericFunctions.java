package com.newtour.genericfunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtour.pages.Welcome;
import com.newtour.utilities.PropertyUtility;
import com.newtour.utilities.ReportUtility;

public class GenericFunctions 
{
	public static WebDriver driver=null;
	public static enum PROPERTY { URL, TESTDATA,EXPORTEDDATA,SCREENSHOTS,LOGS, REPORTS, CONFIGURATION, XMLLOG }
	//public static enum GLOGSTATUS { PASS, FAIL, INFO, WARN, ERROR, FATAL }
	//public static enum LOCATOR { Id, Name, ClassName, TagName, CssSelector, Xpath, LinkText, PartialLinkText }
	public static enum BROWSERCODE { FF, Ch, IE}
	public static enum TESTDATASHEET{Login,Register,Profile,FindFlight,SelectFlight, Passengers}
	public static enum EXPORTEDDATASHEET{Login,Register,Profile,FindFlight,SelectFlight, Passengers}
	public static String StepID="";
	public static String StepDescription="";
	
	
	public static String URL="";
	public static WebDriverWait wait=null;
	public static String status="";
	public static String actualResult="";
	public static String exception="";
	
	public static boolean result;
	
	/*---------------------------------------------------------------------------------------------------
	 * Function name: launchApp
	 * Parameters: total 3 parameters
	 * 				1) type-enum, name-PROPERTY, purpose- level of application whether it is HSTM level or Org level
	 * 				2) type- String, name- BrowserCode, purpose- which browser to use	 
	 * 				3) type- String, name- ExpectedPageTitle, purpose- to check if correct application is launched
	 * Created By: Durgesh Imade, Mindtree
	 * Created On: 11 October 2017 
	 *----------------------------------------------------------------------------------------------------*/
	
	//@BeforeTest
	@org.testng.annotations.Parameters("browser")
	public static void f_launchApp(String browser) 
	{
		try
		{
			// Read required test data
			URL=PropertyUtility.f_readProperty(PROPERTY.URL);
			
			//step1: open browser
			StepID="StepID 0";
			StepDescription="Open Browser: "+browser;
			
			switch(browser.toLowerCase())
			{
				case "firefox":
								driver=new FirefoxDriver();
								break;

				case "chrome":
								System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\DRIVERS\\chromedriver.exe");
								driver=new ChromeDriver();
								break;
				case "ie":
								System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\DRIVERS\\chromedriver.exe");
								driver=new InternetExplorerDriver();
								break;
				
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			status="PASS";
			actualResult= browser+" Browser has been opened successfully";
			exception="NA";
			
			//------------write this in to the log-----------------//
			
			//step1: open application
			StepID=f_stepGenerator(StepID);
			StepDescription="Open Application: "+URL;
			
			driver.get(URL);
			
			//verify if application is launched successfully or not
			if(Welcome.pageTitle.equalsIgnoreCase(driver.getTitle()))
			{
				status="PASS";
				actualResult= browser+" Browser has been opened successfully";
				exception="NA";
			}
			else
			{
				status="FAIL";
				actualResult= browser+" Browser has not been opened successfully";
				exception="NA";
				
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	//@AfterTest
	public static void f_closeApp()
	{
		
				driver.close();
				/*ReportUtility._report.endTest();
				LogOperations.f_writeLog("Application has been closed");*/
				
				
			//ExtentReportUtility._test.log(LogStatus.INFO, "Application has been closed");
			
			
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	public static Hashtable<String, String> f_enterText(WebElement Element, String ElementName ,String Value)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		try
		{
			if(Element.isDisplayed() && Element.isEnabled())
			{
				Element.sendKeys(Value);
				status="PASS";
				actualResult="Entered value: "+Value+" in the "+ElementName;
				exception="NA";
				
				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(),actualResult);
				//ExtentReportUtility._test.log(LogStatus.PASS, _actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
				//return true;
			}
			else
			{
				status="FAIL";
				actualResult="Could not Enter value: "+Value+" in the "+ElementName;
				exception="NA";
				
				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
			}
		}
		catch(Exception e)
		{
			status="FAIL";
			actualResult="Could not Enter value: "+Value+" in the "+ElementName;
			exception= e.getLocalizedMessage();
			
			_output.put("status", status);
			_output.put("message", actualResult);
			_output.put("exception", exception);
			
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
			//Assert.assertEquals("PAAS", status);
			return _output;

		}
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	public static Hashtable<String, String> f_click(WebElement Element, String ElementName)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		try
		{
			if(Element.isDisplayed() && Element.isEnabled())
			{
				Element.click();;
				status="PASS";
				actualResult="Successfully clicked on the "+ElementName;
				exception="NA";

				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), actualResult);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, _actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
			}
			else
			{
				status="FAIL";
				actualResult="Could not clicked on the "+ElementName;
				exception="NA";
				
				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
			}
		}
		catch(Exception e)
		{
			status="FAIL";
			actualResult="Could not clicked on the "+ElementName;
			exception= e.getLocalizedMessage();
			
			_output.put("status", status);
			_output.put("message", actualResult);
			_output.put("exception", exception);
			
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
			//Assert.assertEquals("PAAS", status);
			return _output;

		}
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	public static Hashtable<String, String> f_verifyPage(String ExpectedPageName)
	{
		String ActualPageName="";
		Hashtable<String, String> _output=new Hashtable<String, String>();
		
		try
		{
			ActualPageName=GenericFunctions.driver.getTitle();
			
			if(ExpectedPageName.equalsIgnoreCase(ActualPageName))
			{
				//Assert.assertEquals(ExpectedPageName, ActualPageName);
				status="PASS";
				actualResult= ExpectedPageName+ " is displayed.";
				exception="NA";
				
				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), actualResult);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, _actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
			}
			else
			{
				//Assert.assertEquals(ExpectedPageName, ActualPageName);
				status="FAIL";
				actualResult= ExpectedPageName+ " is not displayed instead "+ActualPageName+" page is displayed";
				exception="NA";

				_output.put("status", status);
				_output.put("message", actualResult);
				_output.put("exception", exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
				//Assert.assertEquals("PAAS", status);
				return _output;
			}
			
		}
		catch(Exception e)
		{
			status="FAIL";
			actualResult= ExpectedPageName+ " is not displayed instead";
			exception=e.getLocalizedMessage();
			
			_output.put("status", status);
			_output.put("message", actualResult);
			_output.put("exception", exception);
			
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+", "+_output.get("message")+",  Exception any:"+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+actualResult);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+_actualResult);
			//Assert.assertEquals("PAAS", status);
			return _output;

		}
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	public static Hashtable<String, String> f_verifyDynamicLink(String linkName)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		String status="";
		String message="";
		String exception ="";
		try
		{
			WebElement link=GenericFunctions.driver.findElement(By.linkText(linkName));
			
			if(link.isDisplayed())
			{
				status="PASS";
				message=linkName +" is displayed on the page";
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), message);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, message);
			}
			else
			{
				status="FAIL";
				message=linkName +" is not displayed on the page";
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
			}
			
		}
		catch(Exception e)
		{
			status="FAIL";
			message=linkName +" is not displayed on the page";
			exception=e.getLocalizedMessage();
			
			_output.put("status",status);
			_output.put("message",message);
			_output.put("exception",exception);
			
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
		}
		
		return _output;
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	public static Hashtable<String, String> f_clickOnDynamicLink(String linkName)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		
		try
		{
			WebElement link=GenericFunctions.driver.findElement(By.linkText(linkName));
			
			if(link.isDisplayed() && link.isEnabled())
			{
				link.click();
				status="PASS";
				actualResult="Clicked on "+linkName;
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",actualResult);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), message);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, message);
			}
			else
			{
				status="FAIL";
				actualResult="Could not click on the link "+linkName;
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",actualResult);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
			}
			
		}
		catch(Exception e)
		{
			status="FAIL";
			actualResult="Could not click on the link "+linkName;
			exception=e.getLocalizedMessage();
			
			_output.put("status",status);
			_output.put("message",actualResult);
			_output.put("exception",exception);
		
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
		}
		
		return _output;
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	public static String f_generateRandomNumber()
	{
		DateFormat _dateformat=new SimpleDateFormat("yyyyMMddhhmmss");
		return _dateformat.format(new Date()).toString();
		
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	public static String f_stepGenerator(String StepID)
	{
		int _stepid=Integer.parseInt(StepID.split(" ")[1]);
		_stepid++;
		return "StepID "+_stepid;
	}
	
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	public static Hashtable<String, String> f_verifyDynamicElement(WebElement element, String elementName)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		String status="";
		String message="";
		String exception ="";
		try
		{
			
			if(element.isDisplayed())
			{
				status="PASS";
				message=elementName +" is displayed on the page";
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), message);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, message);
			}
			else
			{
				status="FAIL";
				message=elementName +" is not displayed on the page";
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
			}
			
		}
		catch(Exception e)
		{
			status="FAIL";
			message=elementName +" is not displayed on the page";
			exception=e.getLocalizedMessage();
			
			_output.put("status",status);
			_output.put("message",message);
			_output.put("exception",exception);
			
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
		}
		
		return _output;
	}
	
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	public static Hashtable<String, String> f_selectFromDropdown(WebElement element, String elementname, String value)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		String status="";
		String message="";
		String exception ="";
		try
		{
			if(element.isDisplayed() && element.isEnabled())
			{
				Select _drpdown=new Select(element);
				_drpdown.selectByVisibleText(value);
				
				status="PASS";
				message="Selected: '"+value+"' in the dropdown "+elementname;
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.PASS.toString(), message);
				
				//ExtentReportUtility._test.log(LogStatus.PASS, message);
			}
			else
			{
				status="FAIL";
				message="Could not Select: '"+value+"' in the dropdown "+elementname;
				exception="NA";
				
				_output.put("status",status);
				_output.put("message",message);
				_output.put("exception",exception);
				
				//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
				//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
				
				//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
			}
			
		}
		catch(Exception e)
		{
			status="FAIL";
			message="Could not select '"+value+"' in the dropdown "+elementname;
			exception=e.getLocalizedMessage();
			
			_output.put("status",status);
			_output.put("message",message);
			_output.put("exception",exception);
		
			//LogOperations.f_writeLog(GenericOperations.StepID +" "+_output.get("status")+" "+GenericOperations.StepDescription+" "+_output.get("message")+" "+_output.get("exception"));
			//ReportUtility.f_writeLog(LOGSTATUS.FAIL.toString(), "FAIL: "+message);
			
			//ExtentReportUtility._test.log(LogStatus.FAIL, "FAIL: "+message);
		}
		
		return _output;
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------*/
	
	public static Hashtable<String, String> f_javascriptExecutor(String script, WebElement element, String message)
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		
		try
		{
			((JavascriptExecutor)GenericFunctions.driver).executeScript(script, element);
			
			_output.put("status", "PASS");
			_output.put("message", message+": successfull");
			_output.put("exception", "NA");
			
		}
		catch(Exception e)
		{
			_output.put("status", "FAIL");
			_output.put("message", message+": not successfull");
			_output.put("exception", e.getLocalizedMessage());
		}
		
		return _output;
	}
	

}