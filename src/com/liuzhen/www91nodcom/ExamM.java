package com.liuzhen.www91nodcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @class: ExamM
 * @description: 幸运数
 * 如果一个数各个数位上的数字之和是质数，并且各个数位上的数字的平方和也是质数，则称它为幸运数。
 * 例如：120是幸运数，因为120的数字之和为3，平方和为5，均为质数，所以120是一个幸运数字。
 * 给定x，y，求x，y之间（ 包含x，y，即闭区间[x,y]）有多少个幸运数。
 * Input
 * 第1行：一个数T，表示后面用作输入测试的数的数量。（1 <= T <= 10000)
 * 第2 - T + 1行：每行2个数，X, Y中间用空格分割。(1 <= X <= Y <= 10^18)
 * Output
 * 输出共T行，对应区间中幸运数的数量。
 * Input示例
 * 2
 * 1 20
 * 120 130
 * Output示例
 * 4
 * 1
 * @author: Liuzhen
 */
public class ExamM {
	
	private static BigInteger area = BigInteger.ZERO;
	private static BigInteger[] lucky = new BigInteger[10000000];
	private static int luckyIndex = 0;
	private static int[] prime = new int[1377];
	private static int primeIndex = 1;
	private static int primeArea = 2;
	
	public static void main(String[] args) throws IOException {
		prime[0] = 2;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(reader.readLine());
		long start = System.currentTimeMillis();
		for (int i = 0; i < length; i++) {
			dealTwoNums(reader.readLine());
		}
		System.out.println(System.currentTimeMillis() - start);
	}
	
	private static void dealTwoNums(String line) {
		String[] sArr = line.split(" ");
		BigInteger max = new BigInteger(sArr[1]);
		if (max.compareTo(area) > 0) {
			enlargeLucky(max);
		}
		BigInteger min = new BigInteger(sArr[0]);
		int count = 0;
		int start = 0;
		if (luckyIndex > 0) {
			for (int i = 0; i < luckyIndex; i++) {
				// todo
				if (min.compareTo(lucky[i]) >= 0) {
					start = i;
				}
				if (max.compareTo(lucky[i]) <= 0 || i == luckyIndex - 1) {
					count = i - start + 1;
					break;
				}
			}
		}
		System.out.println(count);
	}
	
	private static void enlargeLucky(BigInteger b) {
		while (area.compareTo(b) != 0) {
			area = area.add(BigInteger.ONE);
			if (judgeLucky(area)) {
				lucky[luckyIndex++] = area;
			}
		}
	}
	
	private static boolean judgeLucky(BigInteger b) {
		int sum = 0;
		int sqrSum = 0;
		while (b.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] barr = b.divideAndRemainder(BigInteger.TEN);
			b = barr[0];
			int n = barr[1].intValue();
			sum += n;
			sqrSum += n * n;
		}
		return judgePrime(sum) && judgePrime(sqrSum);
	}
	
	private static boolean judgePrime(int a) {
		if (a > primeArea) {
			enlargePrime(a);
		}
		return isExistPrime(a);
	}
	
	private static void enlargePrime(int a) {
		for (int i = primeArea + 1; i <= a; i++) {
			if (isPrime(i)) {
				prime[primeIndex++] = i;
			}
		}
		primeArea = a;
	}
	
	private static boolean isPrime(int a) {
		int half = (int) Math.sqrt(a);
		for (int i = 0; i < primeIndex ; i++) {
			if (a % prime[i] == 0) {
				return false;
			}
			if (half <= prime[i]) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isExistPrime(int a) {
		for (int i = 0; i < primeIndex; i++) {
			if(prime[i] == a) {
				return true;
			} else if (prime[i] > a) {
				return false;
			}
		}
		return false;
	}
}
