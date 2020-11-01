package advancedConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithTables {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");

		// Get the count of number of columns

		List<WebElement> columns = driver.findElements(By.tagName("th"));
		int columnsize = columns.size();
		System.out.println("column Size :" + columnsize);

		// Get the count of number of rows

		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		int rowsize = rows.size();
		System.out.println("Row Size :" + rowsize);

		// Get the progress value of 'Learn to interact with Elements'

		String progressValueofLearn = driver
				.findElement(By.xpath("//td[text()='Learn to interact with Elements']//following::td[1]")).getText();

		System.out.println("Learn to interact with Elements progress value :" + progressValueofLearn);

		// Check the vital task for the least completed progress.

		List<WebElement> allprogress = driver.findElements(By.xpath("//td[2]"));

		List<Integer> progressValue = new ArrayList<Integer>();

		for (WebElement webElement : allprogress) {

			String progress = webElement.getText().replace("%", "");

			progressValue.add(Integer.parseInt(progress));
		}
		System.out.println("progress value is " + progressValue);

		int smallValue = Collections.min(progressValue);
		System.out.println("smallValue is " + smallValue);

		String convertedToString = Integer.toString(smallValue);

		String xpath = "//td[text()='" + convertedToString + "%']//following::td[1]/input";
		System.out.println(xpath);

		WebElement leastprogress = driver.findElement(By.xpath(xpath));
		leastprogress.click();

	}

}
