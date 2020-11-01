package advancedConcepts;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithDownloads {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/download.html");

		driver.findElement(By.linkText("Download Excel")).click();

		waitForDownload("testleaf.xlsx", "C:\\Users\\VIKASA\\Downloads");

	}

	public static void waitForDownload(String FileName, String path) throws InterruptedException {

		int num = 1;
		while (num < 10) {

			System.out.println(num);
			Thread.sleep(500);
			File file = new File(path);

			File[] lists = file.listFiles();

			for (File list : lists) {

				if (list.getName().equals(FileName)) {
					num = num + 10;
					System.out.println("file is Downloaded");
					break;

				}

			}

			num = num + 1;
		}
	}

}
