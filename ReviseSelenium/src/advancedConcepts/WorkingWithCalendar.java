package advancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithCalendar {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Calendar.html");

		WebElement calendar = driver.findElement(By.id("datepicker"));

		// calendar.sendKeys("08/06/2020");

		calendar.click();

		WebElement date = driver.findElement(By.xpath("//a[text()='10']"));
		date.click();

	}

}
