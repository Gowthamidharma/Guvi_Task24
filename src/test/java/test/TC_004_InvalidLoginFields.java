package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Projectspecficationmethod;
import pages.Homepage;
import pages.Login;

public class TC_004_InvalidLoginFields extends Projectspecficationmethod {
	
	@BeforeTest
	
	public void readfilebeforetest() throws Exception {
		readpropfile("url");
		sheetname="login2";		
	}
	
	@Test(dataProvider = "getdata")
	public void tc_004_InvalidLoginFields(String username,String password, String ExpMsg ) throws IOException {
		Homepage hp=new Homepage(driver);
		hp.clickloginhomepage();
		Login lp=new Login(driver);	
		String ActMsg = lp.InvalidLogInFields(username, password);
		softassertion(ActMsg, ExpMsg);
		if(ActMsg.equalsIgnoreCase(ExpMsg)) {
			screenshot("Validating Invalid Fields of Login Functionality - Pass ");
			} else {
			screenshot("Validating Invalid Fields of Login Functionality - Fail ");	
			}
	}

}

