package pagepackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomCakePage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"menu-item-1653\"]/a/span")
	WebElement customCake;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_8\"]")
	WebElement datePick;
	
	@FindBy(xpath="//select[@class='flatpickr-monthDropdown-months']")
	WebElement month;
	
	@FindBy(xpath="//input[@class='numInput cur-year']")
	WebElement year;
	
	@FindBy(xpath="//span[@class='flatpickr-next-month']")
	WebElement nextArrow;
	
	@FindBy(xpath="//span[contains(@class,'flatpickr-day')]")
	List<WebElement> dates;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_11\"]/li[2]/label/span[1]/img")
	WebElement cakeSize;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_12-container\"]/div[1]/div/span[1]")
	WebElement uploadFile;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_15\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_15-last\"]")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_16\"]")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_17\"]")
	WebElement phoneNumber;
	
	@FindBy(xpath="//*[@id=\"wpforms-4092-field_19\"]")
	WebElement comments;
	
	@FindBy(name="wpforms[submit]")
	WebElement submit;
	
	public CustomCakePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCustomCakes() {
		customCake.click();
	}
	
	public void addCustomCakeDetails() throws InterruptedException, AWTException  {
		datePick.click();
		datePickMethod("April", "2027", "20");
		cakeSize.click();
		uploadFile.click();
		fileUpload("F:\\LUMINAR TASKS\\Basic Programs.docx");
		firstName.sendKeys("John");
		lastName.sendKeys("David");
		email.sendKeys("john@gmail.com");
		phoneNumber.sendKeys("7645879899");
		comments.sendKeys("Pink degrade on body, and white on top and edges");
		submit.click();
	}

	private void fileUpload(String filepath) throws AWTException {
		StringSelection str=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		
		Robot robo=new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		robo.delay(4000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		robo.delay(10000);
		
	}

	private void datePickMethod(String expMonth, String expYear, String expDate) {

	    Select s = new Select(month);

	    while (true) {

	        String currentMonth = s.getFirstSelectedOption().getText();

	        String currentYear = year.getAttribute("value");

	        if (currentMonth.equals(expMonth) && currentYear.equals(expYear)) {
	            break; 
	        }

	        nextArrow.click();
	    }

	    for (WebElement d : dates) {
	        if (d.getText().equals(expDate) && d.isEnabled()) {
	            d.click();
	            break;
	        }
	    }
	}



}