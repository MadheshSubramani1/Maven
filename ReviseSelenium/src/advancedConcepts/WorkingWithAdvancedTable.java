package advancedConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAdvancedTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/sorttable.html");

		// beforeSorting -1

		List<WebElement> allNames1 = driver.findElements(By.xpath("//td[2]"));
		List<String> names1 = new ArrayList<String>();

		for (WebElement webElement : allNames1) {

			String text = webElement.getText();
			names1.add(text);

		}
		System.out.println("Before Sorting " + names1);
		Collections.sort(names1);
		System.out.println("After Sorting " + names1);

		WebElement nameHeader = driver.findElement(By.xpath("//th[text()='Name']"));
		nameHeader.click();

		// After Default Sorting -2

		List<WebElement> allNames2 = driver.findElements(By.xpath("//td[2]"));
		List<String> names2 = new ArrayList<String>();

		for (WebElement webElement : allNames2) {

			String text = webElement.getText();
			names2.add(text);

		}

		System.out.println("table sorting" + names2);

		if (names1.equals(names2)) {

			System.out.println("both List are equals");
		}
	}
}
