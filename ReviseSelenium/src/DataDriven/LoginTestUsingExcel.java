package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTestUsingExcel {

	static WebDriver driver;

	@BeforeTest
	public static void launchTheBrowser() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public static String[][] getExcelData() throws BiffException, IOException {

		FileInputStream inputStream = new FileInputStream(
				"C:\\Users\\VIKASA\\eclipse-workspace\\ReviseSelenium\\src\\DataDriven\\Login data.xls");

		Workbook workbook = Workbook.getWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String[][] excelData = new String[rowCount - 1][columnCount];

		for (int i = 1; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				excelData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return excelData;
	}

	@DataProvider(name = "loginData")
	public static String[][] logindata() throws BiffException, IOException {
		String[][] data = getExcelData();
		return data;
	}

	@Test(dataProvider = "loginData")
	public static void CRM_LOGIN(String uname, String pwd) {

		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);

		driver.findElement(By.id("btnLogin")).click();
	}

	@AfterTest
	public static void tearDown() {
		driver.quit();
	}
}