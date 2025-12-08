package pagepackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	
	@FindBy(xpath="/html/body/div[2]/main/div/form/div/div[1]/div[3]/section[1]/footer/a")
	WebElement backToShop;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void cartPageScreenshot() throws IOException {
		File c=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(c,new File("./screenshot/screenshotPg.png"));
	}
	
	public void clickBackToShop() {
		backToShop.click();	}

}
