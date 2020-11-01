package testNGHierarchy;

import org.testng.annotations.Test;

public class TestNgHierachy1 extends TestNgHierarchy {
	@Test(priority = 1)
	public void TestCase1() {

		System.out.println("This is Test Case-1");
	}

	@Test(priority = 2)
	public void TestCase2() {

		System.out.println("This is Test Case-2");
	}
}
