package com.liuzhen.node.reverse;

import com.liuzhen.node.Node;

/**
 * @class: NodeReverse
 * @description: 
 * @author: Liuzhen
 */
public class NodeReverse {
	public static void main(String[] args) {
		Node d1 = new Node(1);
		Node d2 = new Node(2);
		Node d3 = new Node(3);
		d1.next = d2;
		d2.next = d3;
		Node.print(d1);
		d3.reverse(d1);
		Node.print(d3);
	}
}
