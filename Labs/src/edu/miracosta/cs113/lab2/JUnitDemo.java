package edu.miracosta.cs113.lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitDemo {
	int array1[] = {4, 0, 32, 8, 10};
	boolean expected[] = {true, false, true, true, false};
	

	@Test
	void testPowerOfTwo() {
		assertEquals(expected[0], powerOfTwo.isPowerOfTwo(array1[0]));
		assertEquals(expected[1], powerOfTwo.isPowerOfTwo(array1[1]));
		assertEquals(expected[2], powerOfTwo.isPowerOfTwo(array1[2]));
		assertEquals(expected[3], powerOfTwo.isPowerOfTwo(array1[3]));
		assertEquals(expected[4], powerOfTwo.isPowerOfTwo(array1[4]));
		
	}

}
