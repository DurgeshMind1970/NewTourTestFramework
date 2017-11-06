package com.newtours.testcases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.newtour.utilities.ReportUtility;
import com.newtour.utilities.ReportUtility.LOGSTATUS;

public class TC002 
{
	
	@Test
	public void TC002_jgavcgavc()
	{
		System.out.println("Started 2");
		Assert.assertEquals(true, false);
		ReportUtility.f_writeResult(LOGSTATUS.FAIL, "failed");
	}

}
