package advancedConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingWithDrogAndDrop {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/drop.html");
		
		
		WebElement dragElement=driver.findElement(By.id("draggable"));
		
		WebElement dropElement=driver.findElement(By.id("droppable"));
		
		Actions actions=new Actions(driver);
		
		//actions.clickAndHold(dragElement).moveToElement(dropElement).release().build().perform();
		
		actions.dragAndDrop(dragElement, dropElement).build().perform();

	}

}
