package advancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithTooltip {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/tooltip.html");
		
		WebElement tooltip=driver.findElement(By.id("age"));
		String title=tooltip.getAttribute("title");
		
		System.out.println(title);

		
	}

}
