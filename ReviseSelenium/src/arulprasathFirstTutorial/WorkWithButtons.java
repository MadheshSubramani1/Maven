package arulprasathFirstTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithButtons {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// get the position of the button
		driver.get("http://www.leafground.com/pages/Button.html");

		Point position = driver.findElement(By.id("position")).getLocation();

		int xPosition = position.getX();
		int yPosition = position.getY();

		System.out.println("X position is " + xPosition + " y position is " + yPosition);

		// Find a button color

		String color = driver.findElement(By.xpath("//button[text()='What color am I?']"))
				.getCssValue("background-color");
		System.out.println("Button color is " + color);

		// find a height and width of button
		WebElement buttonSize = driver.findElement(By.id("size"));

		int height = buttonSize.getSize().getHeight();
		int width = buttonSize.getSize().getWidth();

		System.out.println("Button height is " + height + " and width is " + width);
		
		//going to Home Page

		driver.findElement(By.id("home")).click();

		driver.close();
	}

}
