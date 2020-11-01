package testNGParallelConcepts;

import org.testng.annotations.Test;

public class ParallelMethod {

	@Test
	public void testCaseOne() {

		System.out.println("This is First Test Case " + Thread.currentThread().getId());

	}

	@Test
	public void testCaseSecond() {

		System.out.println("This is second Test Case " + Thread.currentThread().getId());

	}

}
