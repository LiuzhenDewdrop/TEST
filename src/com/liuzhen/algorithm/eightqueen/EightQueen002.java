package com.liuzhen.algorithm.eightqueen;

/*
 * @class: EightQueen002
 * @description: 八皇后问题(二维数组墙壁解法)
 * @author L.zhen
 * @create 2016-12-26 17:27
 */

public class EightQueen002 {
	
	public EightQueen002(int width) {
		this.width = width;
		table = new int[width + 2][width + 2];
	}
	
	int width;
	int count = 0;
	int[][] table = null;
	
	/**
	 * @title:  placable
	 * @description: 判断某位置是否能够放置
	 * @param a
	 * @param b
	 * @return:
	 * @author: L.zhen
	 * @date:   2016-12-26 17:29
	 */
	public boolean placable(int a, int b) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (table[i][j] == 1 && (i ==a || j == b || a - i == b - j || a - i + b - j == 0)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
