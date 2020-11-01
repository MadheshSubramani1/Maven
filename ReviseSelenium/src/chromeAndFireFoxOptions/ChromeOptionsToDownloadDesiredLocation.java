package chromeAndFireFoxOptions;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeOptionsToDownloadDesiredLocation {

	WebDriver driver;
	File folder;

	@BeforeMethod
	public void setup() {

		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		HashMap<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);

	}

	@Test
	public void fileToDownload() throws InterruptedException {

		driver.get("http://www.leafground.com/pages/download.html");
		driver.findElement(By.linkText("Download Excel")).click();

		waitToDownload("testleaf.xlsx");

		File[] listOfFiles = folder.listFiles();

		Assert.assertTrue(listOfFiles.length > 0, "Toatl File of this directory is >0");

		for (File file : listOfFiles) {

			Assert.assertTrue(file.length() > 0, "file length is >0");
		}

	}

	public void waitToDownload(String Filename) throws InterruptedException {

		int num = 1;
		while (num < 10) {

			Thread.sleep(500);

			for (File file : folder.listFiles()) {

				if (file.getName().equals(Filename)) {
					num = num + 10;
					System.out.println("Test Leaf EXCEl file is downloaded");
					break;
				}
			}
			num = num + 1;
		}
	}

	@AfterMethod
	public void teardown() {
		driver.quit();

		for (File file : folder.listFiles()) {

			file.delete();
			System.out.println("file is deleted");
		}
		folder.delete();
		System.out.println("folder also deleted");
	}

}
