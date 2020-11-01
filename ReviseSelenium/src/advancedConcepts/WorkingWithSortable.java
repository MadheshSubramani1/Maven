package advancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingWithSortable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/sortable.html");

		List<WebElement> Elements = driver.findElements(By.cssSelector("#sortable>li"));

		Actions actions = new Actions(driver);
		WebElement source = Elements.get(6);
		WebElement target = Elements.get(0);

		// actions.dragAndDrop(source, target).build().perform();
		actions.clickAndHold(source).moveToElement(target).release(target).build().perform();
	}

}
