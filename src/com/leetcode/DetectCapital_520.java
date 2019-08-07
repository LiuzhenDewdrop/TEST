package com.leetcode;

import com.leetcode.util.LeetCodeUtil;

/*
 * @class: DetectCapital_520
 * @description: 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * 示例 1:
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * @author: L.zhen
 * @date: 2018/9/3 17:46
 */
public class DetectCapital_520 {
	public boolean detectCapitalUse(String word) {
		return false;
	}
	
	public static void main(String[] args) {
		LeetCodeUtil.test(test001("USA"), true);
		LeetCodeUtil.test(test001("FlaG"), false);
	}
	
	private static boolean test001(String word) {
		if (word == null || word.length() < 2) {
			return true;
		}
		boolean first = word.charAt(0) > 'Z';
		boolean second = word.charAt(1) > 'Z';
		if (first && !second) {
			return false;
		}
		for (int i = 2; i < word.length(); i++) {
			if (second != word.charAt(i) > 'Z') {
				return false;
			}
		}
		return true;
	}
}
