package Package;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRun {


	public static void main(String[] args) {

		TestNG testNG = new TestNG();

		List<String> suitePath = new ArrayList<String>();

		// suitePath.add(System.getProperty("user.dir") + "\\TestNG.xml");

		suitePath.add("src/test/java/TestNG.xml");

		testNG.setTestSuites(suitePath);


		testNG.run();

	}

}
