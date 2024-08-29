package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportdemoblaze  {
	
		
		public static ExtentReports receiveReport() {
			
			String extentreport="C:\\Users\\Lishanth\\eclipse-workspace\\demoblaze\\ExtentReportDemoBlaze.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(extentreport);
			reporter.config().setReportName("DemoBlazeReport");			
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);			
			return extent;	
			
		}
		

}
