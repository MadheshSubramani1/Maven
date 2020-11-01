package advancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithImages {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Image.html");

		WebElement image = driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/img"));

		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println("this is broken Image");
		}
		else {
			System.out.println("this is not a broken Image");
		}
		driver.close();
	}

}
