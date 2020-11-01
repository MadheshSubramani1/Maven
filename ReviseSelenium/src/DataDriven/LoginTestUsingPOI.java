package DataDriven;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class LoginTestUsingPOI {

	public static void readExcelData() throws Exception {

		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\VIKASA\\eclipse-workspace\\ReviseSelenium\\src\\DataDriven\\Login data1.xlsx");

		Workbook workbook = new XSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		while (rowIterator.hasNext()) {

			Row rowValue = rowIterator.next();

			Iterator<Cell> columnIterator = rowValue.iterator();

			int i = 2;
			while (columnIterator.hasNext()) {

				if (i % 2 == 0) {
					Cell UserName = columnIterator.next();
					System.out.println("USername: " + UserName);
				} else {
					Cell Password = columnIterator.next();
					System.out.println("Password: " + Password);
				}
				i++;
			}

		}
	}

	public static void main(String[] args) throws Exception {

		readExcelData();
	}

}
