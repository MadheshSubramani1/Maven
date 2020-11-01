package advancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAutoComplete {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/autoComplete.html");

		WebElement textBox = driver.findElement(By.id("tags"));
		textBox.sendKeys("r");

		Thread.sleep(3000);

		List<WebElement> lists = driver.findElements(By.cssSelector("#ui-id-1>li"));

		for (WebElement list : lists) {

			System.out.println(list.getText());
			
			if (list.getText().equals("Rest API")) {

				list.click();
			break;
			}
		}

	}

}
