package arulprasathFirstTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithTextkBox {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.silentoutput", "true");
		
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		//Enter the Email address
		
		driver.findElement(By.id("email")).sendKeys("madhesh123@gmail.com");
		
		//Append the text with existing text
		
		driver.findElement(By.xpath
				("//*[@id=\"contentblock\"]/section/div[2]/div/div/input")).sendKeys(" Text");
		
		//get the textbox value
		
		String value=driver.findElement(By.name("username")).getAttribute("value");
		
		System.out.println(value);
		
		//clear the Text
		
		driver.findElement(By.xpath("//*[@value='Clear me!!']")).clear();
		
		//verify the element is enabled or not
		boolean status=driver.findElement(By.xpath
				("//*[@id=\"contentblock\"]/section/div[5]/div/div/input")).isEnabled();
		
		System.out.println("Text field status is "+ status);
	}

}
