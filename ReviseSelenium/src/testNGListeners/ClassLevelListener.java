package testNGListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNGListeners.TestNGListeners.class)

public class ClassLevelListener {

	@Test
	public void testcase1() {

		System.out.println("This is First test Case");

	}

	@Test
	public void testcase2() {

		System.out.println("This is Second test case");
		Assert.assertTrue(false);
	}
}
