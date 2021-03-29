package com.liuzhen.app.util;

import java.math.BigDecimal;

/**
 * @class: BigDecimalUtils
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/22 14:26
 */
public class BigDecimalUtils {
	
	public static BigDecimal add(BigDecimal... a) {
		if (a == null || a.length == 0) {
			return null;
		}
		BigDecimal result = BigDecimal.ZERO;
		for (BigDecimal temp : a) {
			if (temp == null) {
				return null;
			}
			result = result.add(temp);
		}
		return result;
	}
	
	public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
		if (a == null || b == null) {
			return null;
		}
		return a.multiply(b);
	}
}
