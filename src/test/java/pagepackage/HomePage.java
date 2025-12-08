package pagepackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"sgpb-popup-dialog-main-div-wrapper\"]/div/img")
	WebElement closePopup;
	
	@FindBy(xpath="//*[@id=\"logo\"]/img")
	WebElement logo;
	
	@FindBy(xpath="//*[@id=\"menu-item-24\"]/a")
	WebElement signinBtn;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div/div/div[3]/div[2]/div/div/div/div[3]/div[1]/div/a")
	WebElement collections;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void closePopupIfPresent() {
	    try {
	    	closePopup.click();
	    } catch (Exception e) {
	    }
	}


	    public void clickSigninBtn()

	    {
	    	closePopupIfPresent();
	    	signinBtn.click();            
	    }
	    
	    public void titleVerification() {
	    	String expectedTitle="Lets Bake - Cakes and Sweets for Special Moments!";
	    	String actualTitle=driver.getTitle();
	    	Assert.assertEquals(actualTitle, expectedTitle, "Title verification failed!");
	    	System.out.println("Title Verified Successfully: " + actualTitle);
	    	
	    }
	    
	    public void logoVerification() {
	        boolean logoVerify = logo.isDisplayed();
	        Assert.assertTrue(logoVerify);
	        System.out.println("Logo is displayed successfully.");
	    }

	    
	    public void clickCollections() throws InterruptedException {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 2000);");  
	        collections.click();
	    }   

}
