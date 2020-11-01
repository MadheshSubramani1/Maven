package FileWritingConcepts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedWritter {

	public static void main(String[] args) throws IOException {

		String Location = "BufferedWriter.txt";
		String content = "Selenium is a portable framework for testing web Application";
		FileWriter fileWriter = new FileWriter(Location);

		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		bufferedWriter.write(content);
		bufferedWriter.close();

	}

}
