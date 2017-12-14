package com.newtour.genericfunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.newtour.genericfunctions.GenericFunctions.EXPORTEDDATASHEET;
import com.newtour.genericfunctions.GenericFunctions.TESTDATASHEET;
import com.newtour.pages.EditProfile;
import com.newtour.pages.FlightFinder;
import com.newtour.pages.Register;
import com.newtour.pages.SelectFlight;
import com.newtour.pages.SignOn;
import com.newtour.pages.Welcome;
import com.newtour.utilities.ExcelUtility;

public class BusinessFunctions {
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	
	public static Hashtable<String, String> f_enterRegistrationInformation() throws FileNotFoundException, IOException, Exception
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		Hashtable<String, String> result=null;
		String fname,lname,phone,email,address,city,postalcode,state, country,username,password, status, actualResult, exception;
		
		String ExpectedPageName="";
		
		//
		String code=GenericFunctions.f_generateRandomNumber();
		
		//import data from test data file
		String[] data=ExcelUtility.f_readMultipleTestData(TESTDATASHEET.Register, 1, 11);
		
		fname=data[0]+code;
		lname=data[1]+code;
		phone=data[2].split("-")[1];
		email=data[3];
		address=data[4];
		city=data[5];
		postalcode=data[6].split("-")[1];
		state=data[7];
		country=data[8];
		username=data[9]+code;
		password=data[10]+code;
		
		System.out.println("imported data successfully");
		
		Register register=new Register();
		
		//enter first name
		Register.f_enterFirstname(fname);
		
		//enter last name
		Register.f_enterLastname(lname);
		
		//enter phone number
		Register.f_enterPhone(phone);
		
		//enter email
		Register.f_enterEmail(email);
		
		//enter address
		Register.f_enterAddress(address);
		
		//enter city
		Register.f_enterCity(city);
		
		//enter postal code
		Register.f_enterPostalcode(postalcode);
		
		//select country
		Register.f_selectCountry(country);
		
		//enter state
		Register.f_enterState(state);
		
		//enter user name
		Register.f_enterUsername(username);
		
		//enter password
		Register.f_enterPassword(password);
		
		//enter confirm password
		Register.f_enterConfirmPassword(password);

		//click on the Submit button
		Register.f_clickSubmit();

		
		if(GenericFunctions.driver.findElement(By.xpath("//font[contains(text(),'Thank you for registering')]")).isDisplayed())
		{
			status="PASS";
			actualResult= "Entered data successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
			
			//export data to exported data sheet
			String[] userlogindata={username, password};
			String[] userregisterdata={fname,lname,phone,email,address,city,postalcode,state, country,username};
			
			ExcelUtility.f_writeExportedData(TESTDATASHEET.Login, 1, userlogindata);
			ExcelUtility.f_writeExportedData(TESTDATASHEET.Register, 1, userregisterdata);
			
			
		}
		else
		{
			status="FAIL";
			actualResult= "Not entered data successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
		}
		
		return _output;
	}
	
	/**----------------------------------------------------------------------------------------------
	 * 
	 * 
	 *-----------------------------------------------------------------------------------------------
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws Exception */
	
	public static Hashtable<String, String> f_login() throws FileNotFoundException, IOException, Exception
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		Hashtable<String, String> result=null;
		String username,password, status, actualResult, exception;
		
		//import data from exported data file
		username=ExcelUtility.f_readExportedData(EXPORTEDDATASHEET.Login, 1, 0);
		password=ExcelUtility.f_readExportedData(EXPORTEDDATASHEET.Login, 1, 1);
		
		//create object to initialize 
		SignOn signon = new SignOn();
		
		//enter username
		SignOn.f_enterUsername(username);
		
		//enter password
		SignOn.f_enterPassword(password);
		
		//click login
		SignOn.f_clickOnLogin();
		
		//GenericFunctions.wait.until(ExpectedConditions.titleIs(FlightFinder.pageTitle));
		
		result=GenericFunctions.f_verifyPage(FlightFinder.pageTitle);
		
		if(result.get("status").equalsIgnoreCase("PASS"))
		{
			status="PASS";
			actualResult= "Logged in successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
			
		}
		else
		{
			status="FAIL";
			actualResult= "Not logged in successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
		}
		
		
		return _output;
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	
	public static Hashtable<String, String> f_enterProfileInformation() throws FileNotFoundException, IOException, Exception
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		Hashtable<String, String> result=null;
		String fname,lname,phone,email,address,city,postalcode,state, country, status, actualResult, exception;
		
		String ExpectedPageName="";
		
		//
		String code=GenericFunctions.f_generateRandomNumber();
		
		//import data from test data file
		String[] data=ExcelUtility.f_readMultipleExportedData(EXPORTEDDATASHEET.Register, 1, 10);
		
		fname=data[0]+code;
		lname=data[1]+code;
		phone=data[2].split("-")[1];
		email=data[3];
		address=data[4];
		city=data[5];
		postalcode=data[6].split("-")[1];
		state=data[7];
		country=data[8];
		
		
		System.out.println("imported data successfully");
		
		EditProfile editProfile=new EditProfile();
		
		//enter first name
		EditProfile.f_enterFirstname(fname);
		
		//enter last name
		EditProfile.f_enterLastname(lname);
		
		//enter phone number
		EditProfile.f_enterPhone(phone);
		
		//enter email
		EditProfile.f_enterEmail(email);
		
		//enter address
		EditProfile.f_enterAddress(address);
		
		//enter city
		EditProfile.f_enterCity(city);
		
		//enter postal code
		EditProfile.f_enterPostalcode(postalcode);
		
		//select country
		EditProfile.f_selectCountry(country);
		
		//enter state
		EditProfile.f_enterState(state);
		
		//click on the Submit button
		EditProfile.f_clickSubmit();

		
		if(GenericFunctions.f_verifyPage(Welcome.pageTitle).get("status").equalsIgnoreCase("PASS"))
		{
			status="PASS";
			actualResult= "Profile data saved successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
			
		}
		else
		{
			status="FAIL";
			actualResult= "Profile data not saved successfully";
			
			_output.put("status", status);
			_output.put("message", actualResult);
		}
		
		return _output;
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	
	public static Hashtable<String, String> f_flightFinder(String trip, String passengerCount, String departingFrom, String arrivalAt ) throws FileNotFoundException, IOException, Exception
	{
		Hashtable<String, String> _output=new Hashtable<String, String>();
		Hashtable<String, String> result=null;
		
		FlightFinder finder= new FlightFinder();
		
		//select type
		FlightFinder.f_selectTripType(trip);
		
		//select passengers
		FlightFinder.f_selectPassengerCount(passengerCount);
		
		//select Departing from
		FlightFinder.f_selectDepartingFrom(departingFrom);
		
		//select arriving in
		FlightFinder.f_selectArrivingPort(arrivalAt);
		
		//click on continue
		FlightFinder.f_clickOnContinue();
		
		// check if Select Flight page is displayed
		if (GenericFunctions.driver.getTitle().equalsIgnoreCase(SelectFlight.pageTitle)) 
		{
			_output.put("status", "PASS");
			_output.put("message", "Select Flight page is displayed");
		}
		else
		{
			_output.put("status", "PASS");
			_output.put("message", "Select Flight page is NOT displayed");
		}
		
		return _output;
		
	}

}
