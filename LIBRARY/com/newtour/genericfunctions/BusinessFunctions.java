package com.newtour.genericfunctions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import com.newtour.genericfunctions.GenericFunctions.TESTDATASHEET;
import com.newtour.pages.Register;
import com.newtour.utilities.ExcelUtility;

public class BusinessFunctions {
	
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

		
		if(GenericFunctions.f_verifyPage("").get("status").equalsIgnoreCase("PASS"))
		{
			status="PASS";
			actualResult= "Entered data successfully and "+ExpectedPageName+ " is displayed.";
			
			_output.put("status", status);
			_output.put("message", actualResult);
			
		}
		else
		{
			status="FAIL";
			actualResult= "Not entered data successfully and "+ExpectedPageName+ " is displayed.";
			
			_output.put("status", status);
			_output.put("message", actualResult);
		}
		
		return _output;
	}

}
