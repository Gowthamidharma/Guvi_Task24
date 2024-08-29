package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.Projectspecficationmethod;



public class Listener  extends Projectspecficationmethod implements ITestListener{
	
	 static ExtentTest test;
	 ExtentReports extent = ExtentReportdemoblaze.receiveReport();

	@Override
	public void onTestStart(ITestResult result) {
	
		
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		String filepath = null;
		try {
			filepath = screenshot(result.getMethod().getMethodName());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test skipped");
	}


	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
