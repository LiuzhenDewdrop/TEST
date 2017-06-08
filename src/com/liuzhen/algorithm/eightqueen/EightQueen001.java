package com.liuzhen.algorithm.eightqueen;

/*
 * @class: EightQueen001
 * @description: 八皇后问题(二维数组一般解法)
 * @author L.zhen
 * @create 2016-12-26 11:34
 */
public class EightQueen001 {
	
	public EightQueen001(int width) {
		this.width = width;
		table = new int[width][width];
	}
	
	int width;
	int[][] table = null;
	int count = 0;
	
	/**
	 * @title:  place
	 * @description: 放置棋子
	 * @param a
	 * @author: L.zhen
	 * @date:   2016-12-26 17:28
	 */
	public void place(int a) {
		if (a == width) {
			System.out.println(++count);
			print();
			return;
		}
		for (int i = 0; i < width; i++) {
			if (table[a][i] != 1 && placable(a, i)) {
				table[a][i] = 1;
				place(a + 1);
				table[a][i] = 0;
			}
		}
	}
	
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
	
	/**
	 * @title:  print
	 * @description: 打印输出
	 * @author: L.zhen
	 * @date:   2016-12-26 17:29
	 */
	public void print() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		EightQueen001 e = new EightQueen001(8);
		e.place(0);
	}
}