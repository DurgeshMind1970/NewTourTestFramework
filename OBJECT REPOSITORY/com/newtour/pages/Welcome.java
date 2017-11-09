package com.newtour.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.VerifyResults;

public class Welcome {
	
	public static String pageTitle="Welcome: Mercury Tours";
	
	public Welcome() {
	PageFactory.initElements(GenericFunctions.driver, this);
	}
	
	@FindBy(xpath="//a[text()='REGISTER']")
	WebElement link_Register;
	String register_Link="Register";
	
	
	
	//Function to click on the Register link
	public void f_clickOnRegisterLink() throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(link_Register, register_Link);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
		//return result;
	}
	
	
	
	

}
