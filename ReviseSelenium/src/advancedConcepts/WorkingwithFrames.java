package advancedConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingwithFrames {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/frame.html");
		
		WebElement frame1=driver.findElement(By.xpath("//*[@id=\"wrapframe\"]/iframe"));
		
		driver.switchTo().frame(frame1);
		
		WebElement clickButton=driver.findElement(By.id("Click"));
		clickButton.click();
		
		String Text=driver.findElement(By.id("Click")).getText();
		System.out.println(Text);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.id("Click1")).click();
		
		driver.switchTo().defaultContent();
		
		
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		
		int size=frames.size();
		System.out.println("Frames size= "+size);
		
		
	}

}
