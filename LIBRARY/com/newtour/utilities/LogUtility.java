package com.newtour.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogUtility 
{
	public static Logger logger=null;
	
	public LogUtility() throws Exception 
	{
		logger=Logger.getLogger("LogUtility");
		System.setProperty("currentdate", XMLUtility.f_readLogXML());//"2017010101"
		PropertyConfigurator.configure(getClass().getClassLoader().getResourceAsStream("log4j.properties"));
	}
	
	public static void f_writeResults(String message)
	{
			logger.info(message);
	}
	
	public static void main(String[] a) throws Exception 
	{
		LogUtility _logUtility=new LogUtility();
		LogUtility.f_writeResults("Test suit has started");
		System.out.println("done");
	}
}
