package basepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {

    public WebDriver driver;
    public ExtentSparkReporter reporter;
    public ExtentReports extent;
    public ExtentTest test;

    String baseUrl = "https://letsbake.ca/";

    @BeforeTest
    public void extentReport() {

        reporter = new ExtentSparkReporter("./Reports/MyReport.html");
        reporter.config().setDocumentTitle("LetsBake Automation Report");
        reporter.config().setReportName("Functional Testing");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Tester Name", "Sreelakshmi");
        extent.setSystemInfo("Browser", "Chrome");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }
    
    @Test
	public void titleVerification() {
		test=extent.createTest("Let's Bake Title Verification");
		String actTitle=driver.getTitle();
		String expTitle="Lets Bake - Cakes and Sweets for Special Moments!";
		Assert.assertEquals(expTitle, actTitle);
	}
	
	public void LetsBakeLogoTest() {
		test=extent.createTest("Let's Bake Logo Verification");
		boolean b=driver.findElement(By.xpath("//*[@id=\"logo\"]/img")).isDisplayed();
		Assert.assertTrue(b);
		
	}

    @AfterMethod
    public void resultCheck(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, "Reason: " + result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
        extent.flush();
    }
}
