package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Projectspecficationmethod;

public class Homepage  extends Projectspecficationmethod {
	
	@FindBy(id="signin2")
	WebElement homepagesigin;
	
	@FindBy(id="login2")
	WebElement homepagelogin;
	
	

	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public  Homepage clicksiguphomepage() {
		
		clickOn(homepagesigin);
		return this;
		
	}
	
	public  Homepage clickloginhomepage() {
		
		clickOn(homepagelogin);
		return this;
		
	}

	
	
	
}
