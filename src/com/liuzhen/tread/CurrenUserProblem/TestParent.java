package com.liuzhen.tread.CurrenUserProblem;

import com.liuzhen.node.Node;

/**
 * @class: TestParent
 * @description: 
 * @author: Liuzhen
 */
public class TestParent {
	
	private Node node;
	
	public Node getNode() {
		if (node == null) {
			node = new Node(123);
		}
		return node;
	}
	
	public void setNode(Node d) {
		this.node = d;
	}
}
