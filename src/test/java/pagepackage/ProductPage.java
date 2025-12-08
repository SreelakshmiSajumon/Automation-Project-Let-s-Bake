package pagepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id=\"ajax-content-wrap\"]/div[1]/div/div[1]/div/div[2]/form/select")
	WebElement dropDown;
	
	@FindBy(xpath="/html/body/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/ul/li[1]/div[2]/a")
	WebElement clickProduct;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDropDown() {
		Select sel=new Select(dropDown);
		sel.selectByValue("price");
	}
	
	public void clickProduct() {
		clickProduct.click();
	}
}
