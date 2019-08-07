package com.leetcode;
/*
 * @class: PoorPigs_458
 * @description: 可怜的小猪
 * 有1000只水桶，其中有且只有一桶装的含有毒药，其余装的都是水。它们从外观看起来都一样。如果小猪喝了毒药，它会在15分钟内死去。
 * 问题来了，如果需要你在一小时内，弄清楚哪只水桶含有毒药，你最少需要多少只猪？
 * 回答这个问题，并为下列的进阶问题编写一个通用算法。
 * 进阶:
 * 假设有 n 只水桶，猪饮水中毒后会在 m 分钟内死亡，你需要多少猪（x）就能在 p 分钟内找出“有毒”水桶？n只水桶里有且仅有一只有毒的桶。
 * @author: L.zhen
 * @date: 2018/8/31 18:22
 */
public class PoorPigs_458 {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(test001(1000, 15, 60));
	}
	
	private static int test001(int buckets, int minutesToDie, int minutesToTest) {
		int round = minutesToTest / minutesToDie + 1;
		int result = 0;
		int temp = 1;
		while (temp < buckets) {
			temp *= round;
			result++;
		}
		return result;
	}
}
