package arulprasathFirstTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class workingWithDropDowns {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Dropdown.html");

		WebElement dropDown1 = driver.findElement(By.xpath("//*[@id=\"dropdown1\"]"));

		Select select = new Select(dropDown1);

		select.selectByIndex(1);
		Thread.sleep(1000);

		select.selectByValue("2");

		Thread.sleep(1000);

		select.selectByVisibleText("UFT/QTP");

		// get the drop down firstSelected options

		WebElement dropDownOptions = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));

		Select select1 = new Select(dropDownOptions);

		String firstSelectedOption = select1.getFirstSelectedOption().getText();
		System.out.println("First Selected Option is " + firstSelectedOption);

		// get the drop down options
		List<WebElement> options = select1.getOptions();
		int size = options.size();
		System.out.println("dropDown size =" + size);

		for (WebElement element : options) {

			System.out.println(element.getText());
		}

		// select the drop down value using sendKeys
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select")).sendKeys("Loadrunner");

	}

}
