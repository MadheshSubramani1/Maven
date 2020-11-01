package Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class sample {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest extentTest;
	
	@BeforeTest
	public void extentSetUp() {
	
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/extentReport.html",true);
		
		
		
	}

	@BeforeMethod
	public void setUP() {

		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");
		
	}

	@Test
	public void VerifyPageTitle() {
		
		extentTest=extent.startTest("Verify Page Title");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");

	}

	@AfterMethod
	public void dearDown(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			 
		 extentTest.log(LogStatus.FAIL, "Test case Failed is "+result.getName());
		 extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}
		
		else if  (result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case passed is "+result.getName());
		}
		driver.quit();
		extent.endTest(extentTest);
		
	}
	@AfterSuite
	public void endSuite()
	{
		extent.flush();
		extent.close();
		
	}
}
