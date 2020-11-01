package waitingConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTextChange {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/TextChange.html");

		WebElement Button = driver.findElement(By.id("btn"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(Button, "Click ME!"));

		Button.click();

		String Text = driver.switchTo().alert().getText();
		System.out.println(Text);

		if (Text.equals("Click ME!")) {
			System.out.println("Successfuly Verified the Text");
		}

		driver.switchTo().alert().accept();
		driver.close();

	}

}
