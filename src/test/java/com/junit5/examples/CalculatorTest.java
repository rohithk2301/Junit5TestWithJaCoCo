package com.junit5.examples;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


class CalculatorTest {
	
	Calculator c ;
	
	@BeforeAll
	static void init() {
		System.out.println("BeforeAll init() method called");
	}
	
	@BeforeEach
	void initEach() {
		c = new Calculator();
		System.out.println("BeforeEach init() method called");
	}
	
	@RepeatedTest(value = 3)
	@DisplayName("Test to add the Numbers")
	void testAdd() {
		assertEquals(4, c.add(2,2));
	}
	
	@Nested
	class SubstractTest {
		@Test
		@DisplayName("Test to Substract the +ve Numbers")
		void testSubstractPositiveNum() {
			assertAll(()->assertEquals(5, c.substract(10, 5)),
					()->assertEquals(9, c.substract(20, 11)));
		}
		
		@Test
		@DisplayName("Test to Substract the -ve Numbers")
		void testSubstractNegativeNum() {
			assertAll(()->assertEquals(-6, c.substract(49, 55)),
					()->assertEquals(-1, c.substract(4, 5)));
		}
	}
	
	
	@Test
	@DisplayName("Test to find out the power of a number")
	void testPow() {
		assertEquals(16, c.pow(4, 2));

	}
	
	@AfterEach
	void tearEach() {
		System.out.println("AfterEach tear() method called");
	}
	
	@AfterAll
	static void tearAll() {
		System.out.println("AfterAll tear() method called");
	}

}
