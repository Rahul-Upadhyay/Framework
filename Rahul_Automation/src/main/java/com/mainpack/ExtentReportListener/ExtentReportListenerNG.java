package com.mainpack.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;

public abstract class ExtentReportListenerNG implements IReporter {

	
	//After creating a listener class, we need to add a listener in testng.xml file
	
	
	private ExtentReports extent;
	
	
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String OutputDirectory) {
		
		
		extent = ExtentReports(OutputDirectory + File.separator + "Extent.html", true);
		
		for(ISuite suite : suites)
		{
			Map<String, ISuiteResult> result = suite.getResults();
				
			for(ISuiteResult r : result.values())
			{
				ITestContext context = r.getTestContext();
				
				buildTestNodes(context.getPassedTests(),LogStatus.PASS);
				buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
			}
		}	
			extent.flush();
			extent.close();
	}
		
	private ExtentReports ExtentReports(String string, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		// TODO Auto-generated method stub
		ExtentTest test;
			
			if(tests.size()>0)
			{
				for(ITestResult result : tests.getAllResults())
				{
					test = extent.startTest(result.getMethod().getMethodName());
					test.setStartedTime(getTime(result.getEndMillis()));
					
						for(String group : result.getMethod().getGroups())
							{
									test.assignCategory(group);
							}
								
						if(result.getThrowable() != null)
						{
							test.log(status, "Test" + status.toString().toLowerCase() + "ed");
						}
					extent.endTest(test);
				}
			}
      	} 

	private Date getTime(long Millis) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(Millis);
		return calendar.getTime();
	}

}