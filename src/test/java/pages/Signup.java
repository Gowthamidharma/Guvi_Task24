package pages;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Projectspecficationmethod;

public class Signup extends Projectspecficationmethod {
	
	 	@FindBy(id = "sign-username")
	    WebElement Username;

	    @FindBy(id = "sign-password")
	    WebElement Password;

	    @FindBy(xpath="//button[text()='Sign up']")
	    WebElement buttonSignUp;

	    @FindBy(xpath = "(//button[contains(text(),'Close')])[2]")
	    WebElement buttonClose;

	    @FindBy(xpath = "(//span[text()='×'])[2]")
	    WebElement buttonX;
	
	public Signup(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public String signUp(String username, String password) throws Exception {
	     
			type(Username, username); 
	        type(Password, password);
	        clickOn(buttonSignUp);
	        alertwait();
	        String actMSg= getalertmessage();
	        acceptalert();
	        return actMSg;
	           
	        
	}
	
	public Signup validatesignup(String result,String message) throws Exception {
		
		//alertwait();
		if(result.equalsIgnoreCase("valid1")) { 
			String actualtext = getalertmessage();
			System.out.println(actualtext);			
			//screenshot("Signup_Validation");
			
			hardassertion(actualtext, message);		
			
		
		}else if (result.equalsIgnoreCase("valid2")){
			String actualtext = getalertmessage();
			System.out.println(actualtext);
			//screenshot("Signup_Validation");
			hardassertion(actualtext, message);		
			
			
		}else if (result.equalsIgnoreCase("valid3")) {
			String actualtext = getalertmessage();
			System.out.println(actualtext);
			//screenshot("Signup_Validation");
			hardassertion(actualtext, message);
			
			
			
		} /*
			 * else if (result.equalsIgnoreCase("invalid1")) { String actualtext =
			 * getalertmessage(); System.out.println(actualtext);
			 * assertion(actualtext,message); screenshot("Signup_Validation");
			 * 
			 * }else if (result.equalsIgnoreCase("invalid2")) { String actualtext =
			 * getalertmessage(); System.out.println(actualtext);
			 * assertion(actualtext,message); screenshot("Signup_Validation");
			 * 
			 * }
			 */else if (result.equalsIgnoreCase("invalid3")) {
			String actualtext = getalertmessage();
			System.out.println(actualtext);
			//screenshot("Signup_Validation");
			hardassertion(actualtext, message);	
			
			
		} else {
			System.out.println("End of siginup_validation");
		}
		
		return this;		
		
	}

	public Signup closeSignUpPage(){
	        clickOn(buttonClose);
	        return this;	        
	}
	
	

	 public Signup closeSignUpPageUsingX(){
	        clickOn(buttonX);
	        return this;
	        
	 }
	
	
}
