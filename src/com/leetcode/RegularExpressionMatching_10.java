package com.leetcode;
/*
 * @class: RegularExpressionMatching_10
 * @description: 正则表达式匹配
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * @author: L.zhen
 * @date: 2018/8/24 18:25
 */
public class RegularExpressionMatching_10 {
	
	public boolean isMatch(String s, String p) {
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(test001("abc", "a*b"));				// t
		System.out.println(test002("bbcacbabbcbaaccabc", "b*a*a*.c*bb*b*.*.*"));				// t
		System.out.println(test001("bbabacccbcbbcaaab", "a*b*a*a*c*aa*c*bc*"));				// f
		System.out.println(test001("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"));				// t
		System.out.println(test001("", "."));				// f
		System.out.println(test001("aaa", "a*b*"));		// t
		System.out.println(test001("aaa", "a*b*c*"));		// t
		System.out.println(test001("aaa", "a*a"));		// t
		System.out.println(test001("aaa", "ab*a*c*a"));	// t
		System.out.println(test001("ab", ".*c"));			// f
		System.out.println(test001("ab", ".*c*"));		// t
		System.out.println(test001("ccbbacbcbcab", ".b*b*.*c*"));		// t
		System.out.println(test001("bcaccbbacbcbcab", "b*.c*..*.b*b*.*c*"));		// t
		System.out.println(test001("ab", ".*.*"));		// t
		System.out.println(test001("ab", ".*c"));			// f
		System.out.println(test001("abcdc", ".*c"));		// t
		System.out.println(test001("abcdc", ".*c.*"));	// t
		System.out.println(test001("cab", ".*c"));		// f
		System.out.println(test001("cabc", ".*c"));		// t
		System.out.println(test001("abcdcddcddccd", ".*c.*d"));		// t
		System.out.println(test001("abcdc", ".*."));		// t
		System.out.println(test001("abcdc", ".*.c"));		// t
	}
	
	public static boolean test001(String s, String p) {
		char[] sc = s.toCharArray();
		char[] pcTemp = p.toCharArray();
		// 干掉连续的*，合并成一个*
		int pcLength = 0;
		for (int i = 0; i < pcTemp.length; i++) {
			if (i< pcTemp.length - 3
					&& (pcTemp[i] == 46 || pcTemp[i + 2] == 46 || pcTemp[i] == pcTemp[i + 2]) && pcTemp[i + 1] == 42
					&& pcTemp[i + 3] == 42) {
				boolean dot = pcTemp[i] == 46 || pcTemp[i + 2] == 46;
				int a = i + 5;
				while (a < pcTemp.length && pcTemp[a] == 42) {
					if (pcTemp[a - 1] == 46) {
						dot = true;
					}
					if (dot || pcTemp[a - 1] == pcTemp[i]) {
						a += 2;
					} else {
						break;
					}
				}
				i = a - 3;
				if (dot) {
					pcTemp[i] = 46;
				}
			}
			pcTemp[pcLength++] = pcTemp[i];
		}
		char[] pc = new char[pcLength];
		System.arraycopy(pcTemp, 0, pc, 0, pcLength);
		return check(sc, pc);
	}
	
	/*
	 * @title:  check
	 * @description: 递归方法，对于*做0至无穷次的尝试
	 * @param sc
	 * @param pc
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/8/30 11:13
	 */
	private static boolean check(char[] sc, char[] pc) {
		int index = 0;
		for (int i = 0; i < pc.length; i++) {
			if (i < pc.length - 1 && pc[i + 1] == 42) {
				char[] newsc = new char[sc.length - index];
				System.arraycopy(sc, index, newsc, 0, sc.length - index);
				for (int j = 0; j <= newsc.length; j++) {
					int remainLength = pc.length - i - 2;
					char[] newpc = new char[j + remainLength];
					for (int k = 0; k < j; k++) {
						newpc[k] = pc[i];
					}
					System.arraycopy(pc, i + 2, newpc, j, remainLength);
					if (check(newsc, newpc)) {
						return true;
					}
				}
			} else {
				if (index >= sc.length || pc[i] != sc[index++] && pc[i] != 46) {
					return false;
				}
			}
		}
		return index == sc.length;
	}
	
	/*
	 * @title:  test002
	 * @description: 标志位方法。最后一位作为可否*匹配的标记。数组中每一个元素都是对应位置是否“可能”匹配上
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean test002(String s, String p) {
		boolean[] match = new boolean[s.length() + 1];
		match[s.length()] = true;
		for(int i = p.length() - 1; i >=0; i--){
			if(p.charAt(i) == '*'){
				//如果是星号，从后往前匹配
				for(int j = s.length() - 1; j >= 0; j--){
					match[j] = match[j] || (match[j + 1] && (p.charAt(i - 1) == '.'
							|| (p.charAt(i - 1) == s.charAt(j))));
				}
				//记得把i多减1，因为星号是和其前面的字符匹配使用
				i--;
				
			}else{
				//如果不是星号，从前往后匹配
				for(int j = 0; j < s.length(); j++){
					match[j] = match[j + 1] && (p.charAt(i) == '.' || (p.charAt(i) == s.charAt(j)));
				}
				//只要试过了pattern中最后一个字符，就要把match【s。length（）】置为false
				match[s.length()] = false;
			}
		}
		return match[0];
	}
}
