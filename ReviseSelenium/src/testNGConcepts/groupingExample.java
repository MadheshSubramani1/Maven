package testNGConcepts;

import org.testng.annotations.Test;

public class groupingExample {

	@Test(groups = { "sanity" })
	public void test1() {

		System.out.println("This is test-1 ");
	}

	@Test(groups = { "sanity", "regression" })
	public void test2() {

		System.out.println("This is test-2");
	}

	@Test(groups = { "regression" })
	public void test3() {

		System.out.println("This is test-3");
	}

}
