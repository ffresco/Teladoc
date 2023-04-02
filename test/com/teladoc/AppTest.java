package com.teladoc;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {
	
	

	@Test
	public void test_int_ok() {
		assertEquals(App.addNumbers("1","2"), "3.0");
	}

	@Test
	public void test_double_ok() {
		assertEquals(App.addNumbers("1.1","2.1"), "3.2");
	}

	@Test(expected = NumberFormatException.class)
	public void test_characters() {
		assertEquals(App.addNumbers("A1","2"), "3.0");
	}

	@Test(expected = NumberFormatException.class)
	public void test_null() {
		assertEquals(App.addNumbers(null,"2"), "3.0");
	}

	@Test(expected = NumberFormatException.class)
	public void test_empty() {
		assertEquals(App.addNumbers("","2"), "3.0");
	}

	@Test(expected = NumberFormatException.class)
	public void test_negative() {
		assertEquals(App.addNumbers("-1","2"), "3.0");
	}

}
