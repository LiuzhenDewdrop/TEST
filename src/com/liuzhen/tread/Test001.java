package com.liuzhen.tread;

import java.util.HashSet;
import java.util.Set;

/**
 * @class: Test001
 * @description: 
 * @author Liuzhen
 */
public class Test001 extends Thread {
	
	Thread t1 = new Thread();
	Thread t2 = new Thread();
	public static void main(String[] args) {
		Set<TestEntity> set = new HashSet<>();
		// create set
		TestEntity temp = null;
		for (int i = 0; i < 10; i++) {
			temp = new TestEntity();
			temp.setName("name" + i);
			set.add(temp);
		}
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
	//				TestEntity t = new TestEntity("1", "aaa");
					new Test001().test001(set, "1");
				}
			});
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
	//				TestEntity t = new TestEntity("1", "aaa");
					new Test001().test001(set, "2");
				}
			});
			t1.start();
			t2.start();
		System.out.println(1);
	}
	
	private void test(TestEntity testEntity, String id, String desc) {
		testEntity.setId(id);
		System.out.println("id:" + id + ",desc:" + desc);
	}
	
	private synchronized void test001(Set<TestEntity> set, String desc) {
		int i = 0;
		for (TestEntity testEntity : set) {
			if (testEntity.getId() == null) {
				testEntity.setDesc(desc);
				test(testEntity, i++ + "", desc);
			}
		}
	}
	
	
}
