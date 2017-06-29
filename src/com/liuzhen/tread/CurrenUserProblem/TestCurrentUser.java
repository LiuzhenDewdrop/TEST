package com.liuzhen.tread.CurrenUserProblem;

import com.liuzhen.node.Node;

/**
 * @class: TestCurrentUser
 * @description: 
 * @author: Liuzhen
 */
public class TestCurrentUser {
	
	public static void main(String[] args) {
		TestChild tc = TestChild.getTestChild();
		new Thread(() -> tc.setNode(new Node(555))).start();
		new Thread(() -> System.out.println(tc.getNode().value)).start();
	}
}
