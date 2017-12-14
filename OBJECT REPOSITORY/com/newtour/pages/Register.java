package com.newtour.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.VerifyResults;

public class Register 
{
	public static String pageTitle="Register: Mercury Tours";
	
	public Register() {
	PageFactory.initElements(GenericFunctions.driver, this);	
	}
	
	//object on the page
	@FindBy(xpath="//input[@name='firstName']")
	static WebElement txt_FName;
	static String fName_txt="FirstName";
	
	@FindBy(xpath="//input[@name='lastName']")
	static WebElement txt_LName;
	static String lName_txt="LastName";
	
	@FindBy(xpath="//input[@name='phone']")
	static WebElement txt_Phone;
	static String phone_txt="Phone";
	
	@FindBy(xpath="//input[@id='userName']")
	static WebElement txt_Email;
	static String email_txt="Email";
	
	@FindBy(xpath="//input[@name='address1']")
	static WebElement txt_Address;
	static String address_txt="Address";
	
	@FindBy(xpath="//input[@name='city']")
	static WebElement txt_City;
	static String city_txt="City";
	
	@FindBy(xpath="//input[@name='state']")
	static WebElement txt_State;
	static String state_txt="State";
	
	@FindBy(xpath="//input[@name='postalCode']")
	static WebElement txt_Pcode;
	static String pCode_txt="Postal Code";
	
	@FindBy(xpath="//select[@name='country']")
	static WebElement select_Country;
	static String country_select="Country dropdown";
	
	@FindBy(xpath="//input[@id='email']")
	static WebElement txt_Username;
	static String userName_txt="Username";
	
	@FindBy(xpath="//input[@name='password']")
	static WebElement txt_Password;
	static String password_txt="Password";
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	static WebElement txt_CPassword;
	static String cpassword_txt="Confirm Password";
	
	@FindBy(xpath="//input[@name='register']")
	static WebElement btn_Submit;
	static String submit_btn="Submit";
	
	
	//function for all of the webelements
	
	public static void f_enterFirstname(String fname) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_FName, fName_txt, fname);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static  void f_enterLastname(String lname) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_LName, lName_txt, lname);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterPhone(String phone) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Phone, phone_txt, phone);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterEmail(String email) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Email, email_txt, email);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterAddress(String address) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Address, address_txt, address);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterCity(String city) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_City, city_txt, city);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterPostalcode(String postalcode) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Pcode, pCode_txt, postalcode);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterState(String state) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_State, state_txt, state);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_selectCountry(String countryname) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_Country, country_select, countryname);
		VerifyResults.f_softIsPass(result.get("status"), result.get("message"));
	}
	
	public static void f_enterUsername(String username) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Username, userName_txt, username);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_enterPassword(String password) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_Password, password_txt, password);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_enterConfirmPassword(String cpassword) throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_enterText(txt_CPassword, cpassword_txt, cpassword);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_clickSubmit() throws Exception
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(btn_Submit, submit_btn);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
}
