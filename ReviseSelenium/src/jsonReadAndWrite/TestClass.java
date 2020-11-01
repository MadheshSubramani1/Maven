package jsonReadAndWrite;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestClass {

	public static void main(String[] args) throws IOException, ParseException {

		/*
		 * JSONObject jsonObject = new JSONObject();
		 * 
		 * jsonObject.put("Name", "Madhesh Subramani"); jsonObject.put("Age", 24);
		 * 
		 * JSONArray array = new JSONArray();
		 * 
		 * array.add("Sports Knowledge"); array.add("Computer Knowledge");
		 * 
		 * jsonObject.put("Special Qualities", array);
		 * 
		 * FileWriter fileWriter = new FileWriter("jsonWriter.json");
		 * 
		 * fileWriter.write(jsonObject.toJSONString());
		 * 
		 * fileWriter.close();
		 */

		FileReader fileReader = new FileReader("jsonWriter.json");
		JSONParser jsonParser = new JSONParser();

		Object object = jsonParser.parse(fileReader);

		JSONObject jsonObject = (JSONObject) object;

		String name = (String) jsonObject.get("Name");

		Long age = (Long) jsonObject.get("Age");

		JSONArray array = (JSONArray) jsonObject.get("Special Qualities");
		
		Iterator iterator=array.iterator();
		
		while(iterator.hasNext()) {
			
			System.out.println("Special Qualities: " + iterator.next());	
		}

		
		System.out.println("NAme: " + name);
		System.out.println("Age: " + age);

	}

}
