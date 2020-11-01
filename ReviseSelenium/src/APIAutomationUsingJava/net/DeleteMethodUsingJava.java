package APIAutomationUsingJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class DeleteMethodUsingJava extends PutMethodUsingJava {

	@Test(priority = 2)
	public static void DeleteMethos() throws IOException {
		int createdId = PostMethodUsingjava.id;
		String strURl = "http://dummy.restapiexample.com/api/v1/delete/" + createdId;

		System.out.println("Delete Method URL " + strURl);
		URL url = new URL(strURl);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("DELETE");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

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
