package POMTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class LodinTestCase {

	static WebDriver driver;

	@Test
	public static void loginTest() {

		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");


		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.txtUsername.sendKeys("Admin");
		LoginPageObjects.txtPassword.sendKeys("admin123");
		LoginPageObjects.btnLogin.click();

		/*
		 * PageFactory.initElements(driver, LoginPageObjects.class);
		 * LoginPageObjects.userName.sendKeys("Admin");
		 * LoginPageObjects.password.sendKeys("admin123");
		 * LoginPageObjects.loginButton.click();
		 */

		/*
		 * LoginPageObjects.UserName(driver).sendKeys("Admin");
		 * LoginPageObjects.Password(driver).sendKeys("admin123");
		 * LoginPageObjects.LoginButton(driver).click();
		 */

	}
}
