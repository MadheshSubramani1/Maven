package FileWritingConcepts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class UsingPrintWriter {

	public static void main(String[] args) throws FileNotFoundException {

		FileOutputStream fileOutputStream = new FileOutputStream("printWriter.txt");

		PrintWriter printWriter = new PrintWriter(fileOutputStream);

		printWriter.println("Hi");
		printWriter.println("THis is Subramani from santhanur");
		printWriter.close();
	}

}
