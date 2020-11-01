package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestClass {

	public static void CreateStatusColumn(String paths, String SheetName, String ColumnName) throws IOException {

		/*
		 * Xls_Reader reader = new Xls_Reader(
		 * "C:\\Users\\VIKASA\\eclipse-workspace\\ReviseSelenium\\src\\DataDriven\\Login data1.xlsx"
		 * );
		 * 
		 * 
		 * reader.addColumn("Sheet1", "Status");
		 */

		File path = new File(paths);

		FileInputStream fileInputStream = new FileInputStream(path);

		Workbook workbook = new HSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(SheetName);

		Row row = sheet.getRow(0);
		System.out.println(row.getLastCellNum());

		Cell cell = row.createCell(row.getLastCellNum());

		cell.setCellValue(ColumnName);

		FileOutputStream fileOutputStream = new FileOutputStream(path);

		workbook.write(fileOutputStream);
		fileOutputStream.close();


	}

	public static void setCellData(String sheetName, String colName, int rowNum, String data, String paths)
			throws IOException {

		File path = new File(paths);

		FileInputStream fileInputStream = new FileInputStream(path);

		Workbook workbook = new HSSFWorkbook(fileInputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(0);
		int colmnNum = 0;
		for (int i = 0; i < row.getLastCellNum(); i++) {

			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {

				colmnNum = i;
			}

		}
		row = sheet.getRow(rowNum);
		Cell cell = row.createCell(colmnNum);

		cell.setCellValue(data);

		FileOutputStream fileOutputStream = new FileOutputStream(path);
		workbook.write(fileOutputStream);
		fileInputStream.close();
	}
}