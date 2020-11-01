package chromeAndFireFoxOptions;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsToDownloadThePDFDemo {


	public static void main(String[] args) throws InterruptedException {

		HashMap<String, Object> pref = new HashMap<String, Object>();

		pref.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
		pref.put("plugins.always_open_pdf_externally", true);
		pref.put("download.default_directory", "C:\\Users\\VIKASA\\Desktop\\sample");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", pref);

		WebDriver driver = new ChromeDriver(options);

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download PDF")).click();

	}

}
