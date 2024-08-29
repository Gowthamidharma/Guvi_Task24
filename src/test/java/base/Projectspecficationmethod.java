package base;


import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;



import utils.utility;

public class Projectspecficationmethod extends utility {
	
	
	
	@BeforeSuite
	public void StartTest() {
		System.out.println("Automate DemoBlaze Critical Functionalities Started Sucessfully");
	}
	
	@BeforeMethod
	public void naivigateurl() throws Exception {
		geturl(readpropfile("url"));
		
	}
	
	@Parameters("browser")
	@BeforeMethod 
	public void launchingbrowser(String browser) {
		launchbrowser(browser);
	}	
	
	
	@AfterMethod
	public void close() {
		closebrowser();
	}
	
	@AfterSuite
	public void EndTest() {
		System.out.println("Automate DemoBlaze Critical Functionalities Completed Sucessfully");
	}
	
	@DataProvider (name="getdata")
	public String[][] getdata() throws Exception {
		
		String[][] data= readexcel(sheetname);
		return data;
		
	}

}
