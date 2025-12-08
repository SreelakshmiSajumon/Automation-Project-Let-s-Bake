package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="login")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"menu-item-20\"]/a")
	WebElement home;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	 public void setvalues (String uname,String pwd)

	    {
		    username.clear();
	    	username.sendKeys(uname); 
	    	password.clear();
	    	password.sendKeys(pwd);
	            
	    }
	 
	    public void clickLoginBtn()

	    {
	    	 loginBtn.click();	                
	    }
	    
	    public void clickHome()

	    {
	    	home.click();
	                
	    }
}
