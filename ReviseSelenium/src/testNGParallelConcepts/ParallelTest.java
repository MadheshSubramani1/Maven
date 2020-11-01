package testNGParallelConcepts;

import org.testng.annotations.Test;

public class ParallelTest {

	@Test
	public void testCaseOne() {

		System.out.println("This is First Test Case " + Thread.currentThread().getId());

	}




}
