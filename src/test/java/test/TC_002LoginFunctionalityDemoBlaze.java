package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.Projectspecficationmethod;
import pages.Homepage;
import pages.Login;


public class TC_002LoginFunctionalityDemoBlaze extends Projectspecficationmethod {
	
	@BeforeTest
	
	public void readfilebeforetest() throws Exception {
		readpropfile("url");
		sheetname="login";		
	}
	
	@Test(dataProvider = "getdata")
	public  void LoginFunctionality(String username,String password,String xpath,String ExpMsg) throws Exception {
	
		
		Homepage hp=new Homepage(driver);
		Login lp=new Login(driver);		
        hp.clickloginhomepage();		
	    String ActMsg= lp.login(username,password,xpath);
	    softassertion(ActMsg, ExpMsg);
	    if (ActMsg.equalsIgnoreCase(ExpMsg)) {
	    		screenshot("Validating Login Functionality - Pass");
	    	
	    	} else if (xpath.equalsIgnoreCase("invalid")) {
	    		String Actmsg=getalertmessage();
	    		softassertion(Actmsg, ExpMsg);
	    		screenshot("Validating  Negative Scenario  of Login Functionality with Alert Message - Pass");	
	    	} else {
	    		screenshot("Validating Login Functionality - Fail");
	    	}	    	
		
	}
	
	

}
