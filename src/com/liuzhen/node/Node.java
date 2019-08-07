package com.liuzhen.node;
/**
 * @class: Element
 * @description: 
 * @author: Liuzhen
 */
public class Node {
	public int value;
	public Node next;
	
	public Node(int value) {
		this.value = value;
	}
	
	public static Node reverse(Node head) {
		Node pre = null;
		Node next = null;
		
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void print(Node start) {
		do {
			System.out.println(start.value);
			start = start.next;
		} while (start != null);
	}
}
