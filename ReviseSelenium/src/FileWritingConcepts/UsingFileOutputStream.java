package FileWritingConcepts;

import java.io.FileOutputStream;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class UsingFileOutputStream {

	public static void main(String[] args) throws Exception {

		UsingExcel();
		UsingTxt();

	}

	public static void UsingExcel() throws Exception {

		String Location = "OutputStream.xls";

		FileOutputStream fileOutputStream = new FileOutputStream(Location);

		WritableWorkbook workbook = Workbook.createWorkbook(fileOutputStream);
		WritableSheet wsh = workbook.createSheet("Mysheet1", 1);

		Number number = new Number(0, 1, 902131);

		Label label = new Label(0, 3, "I wrote the STring Value");

		wsh.addCell(number);
		wsh.addCell(label);

		workbook.write();
		workbook.close();

	}

	public static void UsingTxt() throws Exception {

		String Location = "Outputstream.txt";
		String content = "Softwre Test Engineer";

		FileOutputStream fileOutputStream = new FileOutputStream(Location);
		byte[] bytes = content.getBytes();
		fileOutputStream.write(bytes);
		fileOutputStream.close();

	}

}
