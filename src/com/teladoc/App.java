package com.teladoc;

import java.text.MessageFormat;

import com.teladoc.validator.NumberValidator;
import com.teladoc.validator.StringToNumberValidator;

public class App {

	
	public static void main(String[] args) {
		String[][] testData = getTestData();
		
		for (int i = 0; i < testData.length; i++) {
			try {
				System.out.println(MessageFormat.format("->Numbers received :{0}  :{1}  ", testData[i][0], testData[i][1]));
				System.out.println(MessageFormat.format("->Result: {0}", addNumbers(testData[i][0], testData[i][1])));
			} catch (Exception e) {
				System.out.println(MessageFormat.format("!!--> Calculation Fail: {0}", e.getMessage()));
			}
		}

	}

	private static String[][] getTestData() {
		return new String[][] { { "10", "20" }, { "-11", "10" }, { "AA", "20" }, { "1.1", "2" }, { "1.1.1", "00" },
				{ "00.10", "1" }, { "1/2", "45" }, { "300", "4000" }, { "123456789012345", "0" }, { null, "10" },
				{ "", "40" }, { "0b101", "10" }, { "0b101", "0b01" },
				{ String.valueOf(Double.MAX_VALUE), String.valueOf(Double.MAX_VALUE) } };

	}

	/*
	 * Write a function that adds two strings, where each string represents an
	 * arbitrarily large non-negative number. addNumbers("123", "11") should return
	 * * * "134".
	 */
	public static String addNumbers(String str1, String str2) throws NumberFormatException {
		Double num1 = transformToNumber(str1);
		Double num2 = transformToNumber(str2);
		return String.valueOf(Double.sum(num1, num2));
	}

	/**
	 * Check whether the String represents a number. Accept Doubles numbers Check
	 * not null, not characters, right length
	 * 
	 * @param strNum
	 * @return the number represented by the String
	 */
	public static Double transformToNumber(String strNum) throws NumberFormatException {
		// Precond-1: valid String numbernumber
		validateStringToNumber(strNum);
		// Transform
		Double number = Double.parseDouble(strNum);
		// Precond-2: Positive numbers
		validateNumber(number);

		return number;

	}

	/**
	 * Validate the if the format of the String is valid for converting it to number
	 * 
	 * @param strNum
	 */
	public static void validateStringToNumber(String strNum) {
		if (!StringToNumberValidator.getInstance().test(strNum))
			throw new NumberFormatException("String provided is not a valid number");
	}

	public static void validateNumber(Double d) {
		if (!NumberValidator.getInstance().test(d))
			throw new NumberFormatException("Number received is not correct");
	}


}
