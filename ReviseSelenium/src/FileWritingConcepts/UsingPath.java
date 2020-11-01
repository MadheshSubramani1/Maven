package FileWritingConcepts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingPath {

	public static void main(String[] args) throws IOException {

		String Location = "PathWriter.txt";
		String content = "Selenium is a portable framework for testing web Application";

		Path path = Paths.get(Location);

		Files.write(path, content.getBytes());
	}

}
