package Package;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRun {


	public static void main(String[] args) {

		TestNG testNG = new TestNG();

		List<String> suitePath = new ArrayList<String>();

		if (suitePath.add(System.getProperty("user.dir") + "\\TestNG.xml"))
			;
		// if
		// (suitePath.add("C:\\Users\\VIKASA\\git\\Maven\\com.Madhesh.mavenProject\\TestNG.xml"));

		else if (suitePath.add("./classes/Package/TestRun.class"))

		testNG.setTestSuites(suitePath);


		testNG.run();

	}

}
