package com.newtour.utilities;

import java.io.IOException;
import java.util.Properties;

import com.newtour.genericfunctions.GenericFunctions.PROPERTY;

public class PropertyUtility 
{
	public static String f_readProperty(PROPERTY propertyName) throws IOException
	{
		PropertyUtility propertyUtility=new PropertyUtility();
		return propertyUtility.f_propertyvalue(propertyName);
	}

	private String f_propertyvalue(PROPERTY propertyName) throws IOException {
		Properties property=new Properties();
		property.load(getClass().getClassLoader().getResourceAsStream("Config.properties"));
		return property.getProperty(propertyName.toString());
	}

	public static void main(String[] args) throws IOException
	{
		System.out.println(PropertyUtility.f_readProperty(PROPERTY.EXPORTEDDATA));
	}
}
