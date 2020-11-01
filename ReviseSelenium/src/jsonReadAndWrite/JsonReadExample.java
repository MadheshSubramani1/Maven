package jsonReadAndWrite;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReadExample {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader fileReader = new FileReader("MyDetails.json");
		JSONParser jsonParser = new JSONParser();

		Object object = jsonParser.parse(fileReader);
		JSONObject jsonObject = (JSONObject) object;

		String name = (String) jsonObject.get("Name");
		Long age = (Long) jsonObject.get("Age");
		JSONArray SpecialQualities = (JSONArray) jsonObject.get("Special Qualities");

		Iterator iterator = SpecialQualities.iterator();

		while (iterator.hasNext()) {
			System.out.println("Special Qualities: " + iterator.next());
		}

		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		// System.out.println("Special Qualities: " + SpecialQualities);

	}

}
