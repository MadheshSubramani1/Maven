package chromeAndFireFoxOptions;

import java.io.File;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirfoxOptionToDownloadsesiredLocation {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setUp() {

		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", folder.getAbsolutePath());
		// 0- it will download in desktop, 1- it will download in downloads folder//
		// 2- it will download in another folder
		profile.setPreference("browser.download.folderList", 2);

		// text/plain,application/pdf- These all are called as MIME types
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/plain,application/pdf,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true);


		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);

		driver = new FirefoxDriver(options);

	}

	@Test
	public void fileToDownload() throws InterruptedException {

		driver.get("http://www.leafground.com/pages/download.html");
		driver.findElement(By.linkText("Download Excel")).click();
		waitToDownload("testleaf.xlsx");
		File[] listOfFiles = folder.listFiles();
		Assert.assertTrue(listOfFiles.length > 0);

		for (File file : folder.listFiles()) {
			Assert.assertTrue(file.length() > 0);
		}

	}

	public void waitToDownload(String fileName) throws InterruptedException {

		int num = 1;
		while (num < 10) {

			Thread.sleep(500);
			for (File file : folder.listFiles()) {

				if (file.getName().equals(fileName)) {
					num = num + 10;
					System.out.println(" File is Downloaded ");
					break;
				}
			}
			num = num + 1;
		}
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

		for (File file : folder.listFiles()) {

			file.delete();
			System.out.println("file is deleted");
		}
		folder.delete();
		System.out.println("folder is deleted");

	}

}
