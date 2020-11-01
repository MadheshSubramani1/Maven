package chromeAndFireFoxOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FireFoxOptionsToDownloadPdf {

	public static void main(String[] args) {

		// WebDriverManager.firefoxdriver().setup();

		FirefoxProfile profile = new FirefoxProfile();

		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");

		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);

		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		WebDriver driver = new FirefoxDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download Text")).click();

	}

}
