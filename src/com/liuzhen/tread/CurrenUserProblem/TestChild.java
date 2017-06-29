package com.liuzhen.tread.CurrenUserProblem;
/**
 * @class: TestChild
 * @description: 
 * @author: Liuzhen
 */
public class TestChild extends TestParent{
	private static TestChild t = new TestChild();
	private TestChild(){
	}
	public static TestChild getTestChild() {
		if (t == null) {
			t = new TestChild();
		}
		return t;
	}
}
