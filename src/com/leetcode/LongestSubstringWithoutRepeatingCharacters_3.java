package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: LongestSubstringWithoutRepeatingCharacters_3
 * @description: 无重复字符的最长子串
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 无重复字符的最长子串是 "b"，其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "wke"，其长度为 3。
 * 请注意，答案必须是一个子串，"pwke" 是一个子序列 而不是子串。
 * @author: L.zhen
 * @date: 2018/9/3 10:35
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {
	public int lengthOfLongestSubstring(String s) {
		return 0;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test002("dvdf"), 3);
		LeetCodeUtil.test(test002("bbbbb"), 1);
		LeetCodeUtil.test(test002("pwwkew"), 3);
	}
	
	/*
	 * @title:  test001
	 * @description: 从自身某位置向前回溯查找
	 * @param s
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 11:15
	 */
	private static int test001(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 1;
		int nowLength = 1;
		for (int i = 1; i < s.length(); i++) {
			boolean has = false;
			for (int j = i - 1; j >= i - nowLength; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					has = true;
					if (nowLength > max) {
						max = nowLength;
					}
					nowLength = i - j;
					break;
				}
			}
			if (!has) {
				nowLength++;
			}
		}
		return nowLength > max ? nowLength : max;
	}
	
	/**
	 * @title:  test002
	 * @description: 存放char上次出现的位置
	 * @param s
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/9/3 11:16
	 */
	private static int test002(String s) {
		int ans = 0;
		int[] arr = new int[128];
		for (int i = 0, j = 0; i < s.length(); i++) {
			j =  Math.max(arr[s.charAt(i)], j);
			ans = Math.max(ans, i - j + 1);
			arr[s.charAt(i)] = i + 1;
		}
		return ans;
	}
}
