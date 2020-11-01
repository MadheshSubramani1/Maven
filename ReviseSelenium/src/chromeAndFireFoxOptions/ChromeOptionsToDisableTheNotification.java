package chromeAndFireFoxOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsToDisableTheNotification {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.facebook.com");

		driver.findElement(By.id("email")).sendKeys("9042167769");

		driver.findElement(By.id("pass")).sendKeys("9042167769Madhesh");

		driver.findElement(By.id("loginbutton")).click();
	}

}
