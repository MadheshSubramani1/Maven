package APIAutomationUsingJava.net;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GetPostPutDeleteUsingUnirest {

	static int id;

	public static void getMethod() throws UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest.get("http://dummy.restapiexample.com/api/v1/employees").asJson();

		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());
		System.out.println(jsonResponse.getBody());
	}

	public static void PostMethod() throws UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest.post("http://dummy.restapiexample.com/api/v1/create")
				.header("Content-Type", "application/json")
				.body("	{\"name\":\"Madhesh Subramani\",\"salary\":\"500\",\"age\":\"24\"}").asJson();

		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());
		System.out.println(jsonResponse.getBody());

		JSONObject jsonObject = jsonResponse.getBody().getObject();

		JSONObject dataObject = new JSONObject(jsonObject.getJSONObject("data").toString());

		id = dataObject.getInt("id");
		System.out.println(id);
	}

	public static void putMethod() throws UnirestException {

		String url = "http://dummy.restapiexample.com/api/v1/update/" + id;
		System.out.println("put URL " + url);
		HttpResponse<JsonNode> jsonResponse = Unirest.put(url).header("Content-Type", "application/json")
				.body("	{\"name\":\"Madheshbramani\",\"salary\":\"12000\",\"age\":\"24\"}").asJson();

		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());
		System.out.println(jsonResponse.getBody());

	}

	public static void deleteMethod() throws UnirestException {

		String url = "	http://dummy.restapiexample.com/api/v1/delete/" + id;
		System.out.println("Delete URL " + url);
		HttpResponse<JsonNode> jsonResponse = Unirest.delete(url).header("Content-Type", "application/json").asJson();

		System.out.println(jsonResponse.getStatus());
		System.out.println(jsonResponse.getStatusText());
		System.out.println(jsonResponse.getBody());

	}

	public static void main(String[] args) throws UnirestException {

		getMethod();
		PostMethod();
		putMethod();
		deleteMethod();

	}

}
