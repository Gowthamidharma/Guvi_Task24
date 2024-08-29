package test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import base.Projectspecficationmethod;
import pages.Homepage;
import pages.Signup;

public class TC_001SignupFunctionalityDemoblaze extends Projectspecficationmethod {	
	
	@BeforeTest
	
	public void readfilebeforetest() throws Exception {
		readpropfile("url");
		sheetname="signup";		
	}	
	
	
	
	@Test(priority=1, dataProvider = "getdata")
	public  void SignUpFunctionality(String username,String password,String ExpMsg) throws Exception  {
		
		
		Homepage hp =new Homepage(driver);
		Signup sp= new Signup(driver);
		hp.clicksiguphomepage();
		String ActMsg = sp.signUp(username, password);
		softassertion(ActMsg, ExpMsg);
		if(ActMsg.equalsIgnoreCase(ExpMsg)) {
			screenshot("Validating SignUp Functionality - Pass");
		} else {
			screenshot("Validating SignUp Functionality - Fail");
		}		
		
	}
	
	
	

}
