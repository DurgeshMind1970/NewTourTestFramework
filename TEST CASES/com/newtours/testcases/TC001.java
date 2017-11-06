package com.newtours.testcases;

import org.testng.annotations.Test;

import com.newtour.genericfunctions.GenericFunctions;
import com.newtour.utilities.ReportUtility;
import com.newtour.utilities.VerifyResults;
import com.newtour.utilities.ReportUtility.LOGSTATUS;

public class TC001 extends GenericFunctions
{
	@Test
	public void TC001_abc() {
		System.out.println("TC001_registerToNewTourSite() ");
		

		try {
			VerifyResults.f_softIsPass("PASS", "TC001 --------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			VerifyResults.f_softIsPass("FAIL", "TC001 --------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//VerifyResults.f_softIsPass("PASS", "");
	}

}
