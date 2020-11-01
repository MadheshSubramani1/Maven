package arulprasathFirstTutorial;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithAlerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Alert.html");

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/button")).click();

		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button")).click();

		Thread.sleep(2000);
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.dismiss();

		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/button")).click();

		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Madhesh Subramani");
		promptAlert.accept();

	}

}
