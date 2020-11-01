package advancedConcepts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.OlderWindowsVersionEphemeralPortDetector;

public class WorkingWithWindows {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");
		
		String mainWindow=driver.getWindowHandle();
		
		WebElement HomePage=driver.findElement(By.xpath("//*[text()='Open Home Page']"));
		
		HomePage.click();
		
		Set<String> allWindow=driver.getWindowHandles();
		
		for (String string : allWindow) {
			
			driver.switchTo().window(string);
		}
		
		WebElement image=driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[4]/a"));
		image.click();
		driver.close();
		
		driver.switchTo().window(mainWindow);
		
		WebElement multipleWindow=driver.findElement(By.
				xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		
		multipleWindow.click();
		
		Set<String> allWindows=driver.getWindowHandles();
		
		int size=allWindows.size();
		System.out.println("windows Size "+size);
		
		for (String window : allWindows) {
			
			if(!window.equals(mainWindow)) {
				
				driver.switchTo().window(window);
				driver.close();
			}
			
		}
		
		driver.quit();
		
	}

}
