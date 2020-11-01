package arulprasathFirstTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithRadioButttons {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/radio.html");
		
		driver.findElement(By.id("yes")).click();
		
		boolean Unchecked=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[2]/input")).isSelected();
		
		boolean checked=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/label[3]/input")).isSelected();
		
		System.out.println("Un checked staus is "+Unchecked);
		System.out.println("Checked status is "+checked);
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/input[1]")).click();

	}

}
