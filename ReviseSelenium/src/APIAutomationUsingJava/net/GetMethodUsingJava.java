package APIAutomationUsingJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class GetMethodUsingJava {

	@Test
	public void getMethod() throws IOException {

		URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		System.out.println("Response Code " + responseCode);

		String responseMessage = connection.getResponseMessage();
		System.out.println("Response Message " + responseMessage);

		InputStream inputStream = connection.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// System.out.println("1 st Method" + (char) bufferedReader.read());
		// read method will read the first character only
		// defaultly it will return the ascii value

		String value;
		StringBuffer buffer = new StringBuffer();
		while ((value = bufferedReader.readLine()) != null) {
			buffer.append(value);

		}

		System.out.println(buffer);

	}

}
