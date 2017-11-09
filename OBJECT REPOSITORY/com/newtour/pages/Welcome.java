package com.newtour.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
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
	
	// all objects
	@FindBy(xpath="//a[text()='REGISTER']")
	static WebElement link_Register;
	static String register_Link="Register";
	
	@FindBy(linkText="SIGN-ON")
	static WebElement link_SignOn;
	static String signOn_Link="Sign On";
	
	
	//Function to click on the Register link
	public static void f_clickOnRegisterLink() throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(link_Register, register_Link);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_clickOnSignonLink() throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(link_SignOn,signOn_Link);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	

}
