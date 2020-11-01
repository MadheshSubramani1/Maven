package advancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingWithSelectable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/selectable.html");

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='selectable']/li"));

		Actions actions = new Actions(driver);

		/*
		 * actions.keyDown(Keys.CONTROL) .click(list.get(0)) .click(list.get(1))
		 * .click(list.get(2)).build().perform();
		 */

		actions.clickAndHold(list.get(0))
		.clickAndHold(list.get(1))
		.clickAndHold(list.get(2)).build().perform();

	}

}
