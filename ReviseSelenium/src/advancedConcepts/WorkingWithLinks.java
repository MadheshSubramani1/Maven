package advancedConcepts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithLinks {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/Link.html");

		// Go to Home Page
		WebElement homePage = driver.findElement(By.linkText("Go to Home Page"));

		homePage.click();

		driver.navigate().back();

		// Find where am supposed to go without clicking me?
		WebElement whereAmILink = driver.findElement(By.partialLinkText("Find where am s"));
		String whereLink = whereAmILink.getAttribute("href");
		System.out.println(whereLink);

		// Verify am I broken?

		/*
		 * URL url = new URL("http://www.leafground.com/pages/error.html");
		 * HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		 * 
		 * connection.setRequestMethod("GET"); int statusCode =
		 * connection.getResponseCode(); System.out.println("Status code broken Link " +
		 * statusCode);
		 */

		WebElement brokednLink = driver.findElement(By.linkText("Verify am I broken?"));
		brokednLink.click();

		String title = driver.getTitle();

		if (title.contains("404")) {
			System.out.println("This is Broken Link");
		}

		driver.navigate().back();

		// How many links are available in this page?

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));

		int size = totalLinks.size();
		System.out.println(size);

	}

}
