package pagepackage;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-option-1580-2\"]/div/label")
	WebElement selectSize;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1590-0\"]")
	WebElement selectMenu;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1588\"]")
	WebElement selectFlavour;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1591\"]")
	WebElement cakeColor;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1592\"]")
	WebElement cakeWriting;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1583-0\"]")
	WebElement addComment;
	
	@FindBy(xpath="//*[@id=\"yith-wapo-1594-0\"]")
	WebElement disclaimer;
	
	@FindBy(name="add-to-cart")
	WebElement addToCart;
	
	
	public ProductDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductDetails() throws IOException {
		selectSize.click();
		selectMenu.click();
		
		Select flavour=new Select(selectFlavour);
		flavour.selectByVisibleText("Vanilla strawberry");
		
		Select cakecolor=new Select(cakeColor);
		cakecolor.selectByValue("0");
		
		Select cakewriting=new Select(cakeWriting);
		cakewriting.selectByValue("1");
		
		addComment.sendKeys("Pink degrade on body, and white on top and edges");
		
		disclaimer.click();
		
		addToCart.click();
		
	}
	
	
}
