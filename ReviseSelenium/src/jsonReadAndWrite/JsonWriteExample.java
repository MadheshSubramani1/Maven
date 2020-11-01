package jsonReadAndWrite;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonWriteExample {

	public static void main(String[] args) throws IOException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name", "Madhesh Subramani");
		jsonObject.put("Age", 1);

		JSONArray array = new JSONArray();

		array.add("Quick Learner");
		array.add("Good Communication Skill");

		jsonObject.put("Special Qualities", array);

		FileWriter fileWriter = new FileWriter("MyDetails.json");

		fileWriter.write(jsonObject.toJSONString());
		fileWriter.close();

	}

}
