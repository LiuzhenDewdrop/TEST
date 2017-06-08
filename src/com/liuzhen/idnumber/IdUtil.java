package com.liuzhen.idnumber;

public class IdUtil {

	private static final int[] coefficients = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
	private static final char[] references = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
	public boolean validate(String id) {
		if (id!= null && id.length() == 18) {
			int sum = 0;
			for (int i = 0; i < id.length()-1; i++) {
				sum += Integer.parseInt(String.valueOf(id.charAt(i)))*coefficients[i];
			}
			return references[sum%11] ==id.charAt(17);
		}
		return false;
	}
}
