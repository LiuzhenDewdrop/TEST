package com.liuzhen.algorithm;

// 有n个人围成一圈，顺序排号。
// 从第一个人开始报数(从1到3报数),凡报到3的人退出圈子。
// 问最后留下的是原来第几号的那位。
public class CountNum {

	public void getCountNum(int n) {
		boolean[] b = new boolean[n];
		int left = n;					// 剩下的人
		int countNum = 0;				// 当前报的数
		int index = 0;					// 下标
		while (left > 1) {
			if (!b[index] 				// 如果在圈里
				&& ++countNum == 3) {	// 报数
					countNum = 0;
					b[index] = true;	// 踢出圈
					left--;
			}
			if (++index == n) {			// 一圈了
				index = 0;
			}
		}
		for (int i = 0; i < b.length; i++) {
			if (!b[i]) {
				System.out.println("剩下了第" + (i + 1) + "个人");
			}
		}
	}
	
	public static void main(String[] args) {
		CountNum cn = new CountNum();
		cn.getCountNum(10);
	}
}
