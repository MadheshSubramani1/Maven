package waitingConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntilAlertToBePresent {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/alertappear.html");
		WebElement Alertbutton = driver.findElement(By.id("alert"));
		Alertbutton.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());

		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.close();

	}

}
