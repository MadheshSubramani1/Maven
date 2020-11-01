package testNGParallelConcepts;

import org.testng.annotations.Test;

public class Parallelclass1 {

	@Test
	public void testCaseOne() {

		System.out.println("This is First Test Case " + Thread.currentThread().getId());

	}
}
