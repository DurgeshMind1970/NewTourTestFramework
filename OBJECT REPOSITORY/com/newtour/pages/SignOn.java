package com.newtour.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.VerifyResults;

public class SignOn {

	public static String pageTitle="Sign-on: Mercury Tours";
	
	public SignOn() {
	PageFactory.initElements(GenericFunctions.driver, this);
	}
	
	//all objects
	@FindBy(name="userName")
	static WebElement txt_Username;
	static String username_txt="Username";
	
	@FindBy(name="password")
	static WebElement txt_Password;
	static String password_txt="Password";
	
	@FindBy(name="login")
	static WebElement btn_Login;
	static String login_btn="Login";
	
	
	//functions for all objects
	
	public static void f_enterUsername(String username)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Username, username_txt, username);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_enterPassword(String password)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Password, password_txt, password);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_clickOnLogin()
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(btn_Login, login_btn);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
}
