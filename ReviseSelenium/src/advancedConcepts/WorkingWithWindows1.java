package advancedConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithWindows1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromeFolder\\chromedriver.exe");
		

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.linkText("Cookie Policy")).click();
		driver.findElement(By.linkText("Data Policy")).click();
		driver.findElement(By.linkText("Terms")).click();
	
		Set<String> allwindow=driver.getWindowHandles();
		
		
		List<String> list=new ArrayList<String>(allwindow);
		driver.switchTo().window(list.get(3));
		
		driver.findElement(By.xpath("//*[@id=\"u_0_c\"]/div/div[2]/div/div[1]/a")).click();
		//driver.close();

	}

}
