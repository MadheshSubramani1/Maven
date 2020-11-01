package FileWritingConcepts;

import java.io.FileWriter;
import java.io.IOException;

public class UsingFileWritter {

	public static void main(String[] args) throws IOException {

		FileWriter fileWriter = new FileWriter("FileWriter.txt");

		fileWriter.write("Lomborgini");

		fileWriter.close();
	}

}
