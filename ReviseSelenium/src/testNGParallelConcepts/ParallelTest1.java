package testNGParallelConcepts;

import org.testng.annotations.Test;

public class ParallelTest1 {

	@Test
	public void testCaseTwo() {

		System.out.println("This is Second Test Case " + Thread.currentThread().getId());

}
}