package arulprasathFirstTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithCheckBoxes {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/checkbox.html");

		WebElement java = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div[1]/input"));

		java.click();

		WebElement selenium = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/input"));
		
		boolean isSeleniumSelected = selenium.isSelected();
		System.out.println("Selenium is selected " + isSeleniumSelected);
		
		WebElement firstCheckBox=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[1]/input"));
		
		if(firstCheckBox.isSelected());
		firstCheckBox.click();
		
		WebElement secondCheckBox=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div[2]/input"));
		
		if (secondCheckBox.isSelected()) {
			secondCheckBox.click();
		}
	}

}
