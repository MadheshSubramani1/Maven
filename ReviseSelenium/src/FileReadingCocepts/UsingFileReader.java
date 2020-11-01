package FileReadingCocepts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UsingFileReader {

	public static void main(String[] args) throws IOException {

		String location = "FileReaderExample.txt";
		FileReader fileReader = new FileReader(location);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// StringBuffer buffer = new StringBuffer();
		String content;
		while ((content = bufferedReader.readLine()) != null) {
			System.out.println(content);

			//buffer.append(content + "\n");
		}

		// System.out.println(buffer);
	}
}
