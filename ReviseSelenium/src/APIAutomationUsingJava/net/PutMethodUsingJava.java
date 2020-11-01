package APIAutomationUsingJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class PutMethodUsingJava extends PostMethodUsingjava {

	@Test(priority = 1)
	public static void PutMethos() throws IOException {
		int createdId = PostMethodUsingjava.id;
		String strURl = "http://dummy.restapiexample.com/api/v1/update/" + createdId;

		System.out.println("put Method URL " + strURl);
		URL url = new URL(strURl);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String body = "{\"name\":\"Madhesh Subramani\",\"salary\":\"12000\",\"age\":\"23\"}";
		byte[] inputjson = body.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputjson);

		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		String responseMessage = connection.getResponseMessage();

		System.out.println(responseMessage);

		InputStream inputStream = connection.getInputStream();

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str;
		StringBuffer buffer = new StringBuffer();
		while ((str = bufferedReader.readLine()) != null) {

			buffer.append(str);
		}

		System.out.println(buffer);
	}
}