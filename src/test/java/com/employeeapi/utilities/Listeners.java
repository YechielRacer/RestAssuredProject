package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {
		
		sparkReporter = new ExtentSparkReporter("./Reports/extentReport.html");
		
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Rest API Testing Report");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Project Name", "Employee Database API");
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "yechiel");
		
	}
		
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getName());
		test.log(Status.FAIL, "Test Case FAILED IS " + result.getThrowable());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());		
		test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		
	}


}
