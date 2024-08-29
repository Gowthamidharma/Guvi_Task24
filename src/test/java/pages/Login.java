package pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.Projectspecficationmethod;


public class Login  extends Projectspecficationmethod{
	
	@FindBy(id = "loginusername")
    WebElement Username;

    @FindBy(id = "loginpassword")
    WebElement Password;

    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement buttonLogin;

    @FindBy(xpath = "(//button[contains(text(),'Close')])[3]")
    WebElement buttonClose;
    
    @FindBy(xpath =  "//a[@id='nameofuser']")
    WebElement validatloginele;
    
    @FindBy(id="logout2")
    WebElement logout;
    
    
	
	public Login(WebDriver driver) {
		//this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	 	

	public String login(String username, String password,String xpath) {		 	
			
	        type(Username, username);
	        type(Password, password);
	        clickOn(buttonLogin);
	        String ActMsg= driver.findElement(By.xpath(""+xpath+"")).getText();						 
	        return ActMsg;
	       
	}	
	
	public void LogoutDisplayedafterLogin(String username, String password) {
		
		 	type(Username, username);
	        type(Password, password);
	        clickOn(buttonLogin);
	        
	}
	
	public boolean LogoutIsDisplayed() {
		return logout.isDisplayed();
	}
	
	public String InvalidLogInFields(String username,String password) {
		    type(Username, username);
	        type(Password, password);
	        clickOn(buttonLogin);
	        alertwait();
	        String actMsg = getalertmessage();
	        acceptalert();
	        return actMsg;
		
	}
		
	

}

