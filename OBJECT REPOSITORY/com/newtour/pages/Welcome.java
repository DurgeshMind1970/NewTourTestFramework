package com.newtour.pages;

import org.openqa.selenium.support.PageFactory;

import com.newtour.genericfunctions.GenericFunctions;

public class Welcome {
	
	public static String pageTitle="Welcome: Mercury Tours";
	
	public Welcome() {
	PageFactory.initElements(GenericFunctions.driver, this);
	}
	
	

}
