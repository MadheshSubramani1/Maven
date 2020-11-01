package FileReadingCocepts;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FileInputStreamExample {

	public static void main(String[] args) throws BiffException, IOException {


		FileInputStream fileInputStream = new FileInputStream("OutputStream.xls");
		Workbook workbook = Workbook.getWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		System.out.println("Row COunt is " + rowCount + " Column Count is " + columnCount);

		for (int i = 0; i < rowCount; i++) {

			for (int j = 0; j < columnCount; j++) {

				String value = sheet.getCell(j, i).getContents();
				System.out.println(value);
			}
		}

	}

}
