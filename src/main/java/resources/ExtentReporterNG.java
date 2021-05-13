package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		//ExtentReports, ExtentSparkReporter
				String path=System.getProperty("user.dir")+"\\reports\\index.html";
				//extent spark reporter is a helper class which is helping the main class to create a report
				ExtentSparkReporter reporter = new ExtentSparkReporter(path); // creates a html file in the specified path
				reporter.config().setReportName("Web Automation Result");//report name
				reporter.config().setDocumentTitle("Test Results");//test results
				
				extent = new ExtentReports();//main class
				extent.attachReporter(reporter);
				extent.setSystemInfo("tester", "Pragya Kadariya");
				return extent;
	}

}
