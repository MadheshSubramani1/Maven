package APIAutomationUsingJava.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostMethodUsingjava {

	static int id;

	@Test(priority = 0)
	public static void postMethod() throws IOException {
		URL url = new URL("http://dummy.restapiexample.com/api/v1/create");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String jsonBody = "{\"name\":\"Madhesh Subramani\",\"salary\":\"12345467\",\"age\":\"23\"}";

		byte[] inputJson = jsonBody.getBytes();

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(inputJson);

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

		JSONObject jsonObject = new JSONObject(buffer.toString()); // json 20160212 jar or unirest maven dependency
		System.out.println(jsonObject.getString("status"));
		JSONObject jsonObject2 = new JSONObject(jsonObject.getJSONObject("data").toString());
		id = jsonObject2.getInt("id");
		System.out.println(id);
	}
}