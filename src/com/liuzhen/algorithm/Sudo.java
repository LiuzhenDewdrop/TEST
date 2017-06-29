package com.liuzhen.algorithm;

import java.util.Arrays;

/**
 * @class: Sudo
 * @description: 数独
 * @author: Liuzhen
 */
public class Sudo {
	
	public static void main(String[] args) {
		int[][] arr =  {{0,0,0,2,0,0,0,7,6},
						{0,0,6,0,0,3,8,5,0},
						{0,0,7,9,8,0,3,0,2},
						{2,0,0,0,0,0,5,0,0},
						{8,0,3,0,0,0,0,0,0},
						{0,0,0,0,7,0,0,0,0},
						{0,5,0,0,0,0,0,9,0},
						{7,6,2,0,0,0,0,0,1},
						{0,0,0,0,2,8,0,0,0}};
		place(arr, 0);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	private static boolean place(int[][] arr, int cur) {
		int y = cur / 9;
		int x = cur % 9;
		if (arr[y][x] != 0) {
			return ++cur == 81 || place(arr, cur);
		} else {
			for (int i = 1; i < 10; i++) {
				if (check(y, x, i, arr)) {
					arr[y][x] = i;
					if (++cur == 81 || place(arr, cur)) {
						return true;
					}
					cur --;
					arr[y][x] = 0;
				}
			}
			return false;
		}
	}
	
	private static boolean check(int y, int x, int num, int[][] arr){
		for (int i = 0; i < arr[y].length; i++){
			if (num == arr[y][i]){
				return false;
			}
		}
		for (int i = 0; i < arr.length; i++){
			if (num == arr[i][x]){
				return false;
			}
		}
		int lty = y / 3 * 3;
		int ltx = x / 3 * 3;
		for(int i = lty; i < lty + 3; i++){
			for (int j = ltx; j < ltx + 3; j++){
				if (arr[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}
}
