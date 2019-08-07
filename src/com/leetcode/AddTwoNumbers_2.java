package com.leetcode;

/*
 * @class: AddTwoNumbers_2
 * @description: 两数相加
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author: L.zhen
 * @date: 2018/8/24 16:27
 */
public class AddTwoNumbers_2 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return null;
	}
	
	public static void main(String[] args) {
		ListNode q1 = new ListNode(2);
		q1.next = new ListNode(4);
		q1.next.next = new ListNode(3);
		ListNode q2 = new ListNode(5);
		q2.next = new ListNode(6);
//		q2.next.next = new ListNode(4);
		print(test001(q1, q2));
		print(test002(q1, q2));
		print(test003(q1, q2));
	}
	
	private static void print(ListNode l) {
		if (l == null) {
			System.out.println("null");
			return ;
		}
		ListNode temp = l;
		StringBuilder s = new StringBuilder();
		s.append(l.val);
		while (temp.next != null) {
			temp = temp.next;
			s.append(" -> ").append(temp.val);
		}
		System.out.println(s.toString());
	}
		
		static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	/*
	 * @title:  test001
	 * @description:	(70ms)
	 * @param l1
	 * @param l2
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/8/24 17:22
	 */
	private static ListNode test001(ListNode l1, ListNode l2) {
		ListNode a1 = l1;
		ListNode a2 = l2;
		int add = 0;
		ListNode result = new ListNode(0);
		ListNode next = result;
		while (a1 != null || a2 != null) {
			int sum = add;
			if (a1 != null) {
				sum += a1.val;
				a1 = a1.next;
			}
			if (a2 != null) {
				sum += a2.val;
				a2 = a2.next;
			}
			if (sum > 9) {
				add = 1;
				sum -= 10;
			} else {
				add = 0;
			}
			next = next.next = new ListNode(sum);
		}
		if (add > 0) {
			next.next = new ListNode(add);
		}
		return result.next;
	}
	
	/*
	 * @title:  test002
	 * @description:	(39ms)
	 * @param l1
	 * @param l2
	 * @return
	 * @author: L.zhen
	 * @date:   2018/8/24 17:22
	 */
	public static ListNode test002(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode a1 = l1, a2 = l2, next = result;
		int add = 0;
		while (a1 != null || a2 != null) {
			int v1 = a1 != null ? a1.val : 0;
			int v2 = a2 != null ? a2.val : 0;
			int sum = v1 + v2 + add;
			add = sum / 10;
			next = next.next = new ListNode(sum % 10);
			if (a1 != null) {
				a1 = a1.next;
			}
			if (a2 != null) {
				a2 = a2.next;
			}
		}
		if (add > 0) {
			next.next = new ListNode(add);
		}
		return result.next;
	}
	
	/*
	 * @title:  test003
	 * @description: (34ms)
	 * @param l1
	 * @param l2
	 * @return 
	 * @author: L.zhen
	 * @date:   2018/8/24 18:10
	 */
	public static ListNode test003(ListNode l1, ListNode l2) {
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		ListNode next = result;
		int add = (l1.val + l2.val) / 10;
		l1 = l1.next;
		l2 = l2.next;
		while (l1 != null || l2 != null) {
			
			int v1 = l1 != null ? l1.val : 0;
			int v2 = l2 != null ? l2.val : 0;
			int sum = v1 + v2 + add;
			add = sum / 10;
			next = next.next = new ListNode(sum % 10);
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (add > 0) {
			next.next = new ListNode(add);
		}
		return result;
	}
}
