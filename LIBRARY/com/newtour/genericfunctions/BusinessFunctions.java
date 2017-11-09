package com.newtour.genericfunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;

import com.newtour.genericfunctions.GenericFunctions.EXPORTEDDATASHEET;
import com.newtour.genericfunctions.GenericFunctions.TESTDATASHEET;
import com.newtour.pages.FlightFinder;
import com.newtour.pages.Register;
import com.newtour.pages.SignOn;
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
			String[] userdata={username, password};
			ExcelUtility.f_writeExportedData(TESTDATASHEET.Login, 1, userdata);
			
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
		
		//enter username
		SignOn.f_enterUsername(username);
		
		//enter password
		SignOn.f_enterPassword(password);
		
		//enter login
		SignOn.f_clickOnLogin();
		
		if(FlightFinder.pageTitle.equalsIgnoreCase(GenericFunctions.driver.getTitle()))
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

}
