package com.leetcode;
/*
 * @class: GuessNumberHigherorLower_374
 * @description: 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例:
 * n = 10, 我选择 6.
 * 返回 6.
 *
 * @author: L.zhen
 * @date: 2018/8/30 18:28
 */
public class GuessNumberHigherorLower_374 {
	/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
	public int guessNumber(int n) {
		return 0;
	}
	static int guess(int num) {
		return num;
	}
	public static void main(String[] args) {
	
	}
	
	
	private static int test001(int n) {
		int min = 0;
		int max = n;
		int result = 2;
		while (result != 0) {
			int guessNum = (max - min) / 2 + min;
			result = guess(guessNum);
			if (result == 1) {
				min = guessNum;
			} else if (result == -1) {
				max = guessNum;
			} else {
				return guessNum;
			}
			if (max - min == 1) {
				if (guess(min) == 0) {
					return min;
				} else {
					return max;
				}
			}
		}
		return (max - min) / 2 + min;
	}
}
