package com.newtour.pages;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.VerifyResults;

public class FlightFinder {

	public static String pageTitle="Find a Flight: Mercury Tours:";
	
	public FlightFinder() 
	{
		PageFactory.initElements(GenericFunctions.driver, this);
	}
	
	
	// all objects
	
	@FindBy(xpath="//a[text()='PROFILE']")
	static WebElement link_profile;
	static String profile_link="PROFILE";
	
	@FindBy(name="passCount")
	static WebElement select_passengers;
	public static String passanger_select="Passengers";
	
	@FindBy(name="fromPort")
	static WebElement select_depart;
	public static String depart_select="DepartFrom";
	
	@FindBy(name="fromMonth")
	static WebElement select_departingOnMonth;
	public static String departingOnMonth_select="Departing On Month";
	
	@FindBy(name="fromDay")
	static WebElement select_departingOnDay;
	public static String departingOnDay_select="Departing On Day";
	
	@FindBy(name="toPort")
	static WebElement select_arriving;
	public static String arriving_select="Arriving port";
	
	@FindBy(name="toMonth")
	static WebElement select_returningOnMonth;
	public static String returningOnMonth_select="Returning On Month";
	
	@FindBy(name="toDay")
	static WebElement select_returningOnDay;
	public static String returningOnDay_select="Returning On Day";
	
	@FindBy(name="tripType")
	static List<WebElement> radio_tripType;
	public static String tripType_radio="TripType";
	
	@FindBy(name="servClass")
	static List<WebElement> radio_serviceClass;
	public static String serviceClass_radio="Service Class";
	
	@FindBy(name="airline")
	static WebElement select_airline;
	public static String airline_select="Airline";

	@FindBy(name="findFlights")
	static WebElement btn_continue;
	public static String continue_btn="Continue";
	

	//functions for all object
	
	public static void f_clickOnProfileLink()
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(link_profile, profile_link);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectPassengerCount(String count)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_passengers, passanger_select, count);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectDepartingFrom(String location)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_depart, depart_select, location);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectDepartingMonth(String monthname)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_departingOnMonth, departingOnMonth_select, monthname);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectDepartingDay(String day)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_departingOnDay, departingOnDay_select, day);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectArrivingPort(String location)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_arriving, arriving_select, location);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}

	public static void f_selectArrivingMonth(String monthname)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_returningOnMonth, returningOnMonth_select, monthname);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectArrivingDay(String day)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_returningOnDay, returningOnDay_select, day);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectAirlin(String airline)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectFromDropdown(select_airline, airline_select, airline);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectTripType(String value)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectRadioButton(radio_tripType, tripType_radio, value);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_selectServiceClass(String value)
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_selectRadioButton(radio_serviceClass, serviceClass_radio, value);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
	
	public static void f_clickOnContinue()
	{
		Hashtable<String, String> result=null;
		result=GenericFunctions.f_click(btn_continue, continue_btn);
		VerifyResults.f_isPASS(result.get("status"), result.get("message"));
	}
}
