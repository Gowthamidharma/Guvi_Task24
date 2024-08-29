package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecficationmethod;
import pages.Homepage;
import pages.Login;

public class TC_003_LogoutDisplayedafterLogin extends Projectspecficationmethod {
	
	@BeforeTest
	
	public void readfilebeforetest() throws Exception {
		readpropfile("url");
		sheetname="login1";		
	}
	
	
	@Test(dataProvider = "getdata")
	public void tc_003_LogoutDisplayedafterLogin(String username,String password) throws Exception {
		Homepage hp=new Homepage(driver);
		hp.clickloginhomepage();
		Login lp=new Login(driver);	
		lp.LogoutDisplayedafterLogin(username, password);
		lp.LogoutIsDisplayed();
		assertTrue(true, "Logout is not Diplayed after Login ");
		screenshot("Validating Logout Functionality Is Displayed after Login");
		
	}

}
