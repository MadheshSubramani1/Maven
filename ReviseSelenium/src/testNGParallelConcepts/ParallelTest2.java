package testNGParallelConcepts;

import org.testng.annotations.Test;

public class ParallelTest2 {

	@Test
	public void testCaseThree() {

		System.out.println("This is Third Test Case " + Thread.currentThread().getId());

	}
}
