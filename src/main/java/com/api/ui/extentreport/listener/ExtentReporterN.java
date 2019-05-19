package com.api.ui.extentreport.listener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter{//IReporter Log skips, passes, fail (It is the interface)
	private ExtentReports extent;//ExtentReports is a class it is private so the outside world to see this(like polymorphism)

	//XML will contain all the class also known as Suites//Array Concept that holds 3 arguments 
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites,
			String outputDirectory) {
	//xml is parent class(Packages) //Isuite has child class(login page suite) //string output directory variable gives pass/fail/skip

		//OutputDirectory is the status is the Pass/Skipped/Failed///File.Separator distinguishes from one another//
		//Created an object for ExtentReports//File Separator
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Jose.html", true);//extent.html is the name of the file//True: Only when it runs a test
		
	//	Obtains a keyvalue that cannot be duplicate and then it will map it to one location or extended code.
		
		//Suite : Suites = Conditional operator something is equal to true do this if it equals to false than do that.
		for(ISuite suite : suites) {//suite is parent //suites is child
			Map<String, ISuiteResult>result = suite.getResults();
			//Map is an interface in JAVA which allows you to view a key and value format ex: User name: jose 
		
		//for loop (interface that represents the whole suite run which is represented at R )
		for(ISuiteResult r : result.values()) {//contains the values of the map interface
			ITestContext context =r.getTestContext();//Context is an object to get the whole suite result r
		
		//context is the representation of the whole suite pass/ skip/ fail
		buildTestNodes(context.getPassedTests(), LogStatus.PASS);
		buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
		buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
		
	}
}
//flush will check the result and add it to the external report 
extent.flush();
//Closes the report for me
extent.close();

}
//Creating Private class //3 parameters and 2 results //IresultMap built in function to map test results 
//Parent Class//Status//Both parent test and child test
private void buildTestNodes(IResultMap tests, LogStatus status){
	ExtentTest test;
	//Results are greater than 0 
	if (tests.size()>0) {//size will get actual of the string
		for (ITestResult result : tests.getAllResults()) {
			//returns the method(What is the method) and method name(ex. Homepage login)  
			test = extent.startTest(result.getMethod().getMethodName());
			//How long it took
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			
			//Going through all of the results and organize the passes, skipped, failed along with time
			for(String group : result.getMethod().getGroups())
				//
				test.assignCategory(group);
			//To generated it is null
			if(result.getThrowable() !=null) {
				//Login an error
				test.log(status,result.getThrowable());
				//If not 
			}else {//to string is converting the status to string
				test.log(status, "Test" + status,toString().toLowerCase() + "ed");
			}
			
			extent.endTest(test);//ends the whole test 
			//that is held in reference value
		}
		}
	
		}
//Privatizing and recording the time and date that it was running
private Date getTime(long millis) {
		Calendar calender = Calendar.getInstance();//calender represents the instance default time zone
		calender.setTimeInMillis(millis);//set time in milli seconds and calender current time 
		return calender.getTime();
				
				
					
				
				
				
				
				
				

}
}