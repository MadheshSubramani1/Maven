package testNGConcepts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationEaxmple {

	@Test
	@Parameters({ "Name" })
	public void getName(String name) {

		System.out.println("My Name is " + name);
	}

	@Test
	@Parameters({ "UserName", "Password" })
	public void getUsernameAndPassword(String username, String password) {

		System.out.println("My UserName is " + username + " My password is " + password);
	}

}
