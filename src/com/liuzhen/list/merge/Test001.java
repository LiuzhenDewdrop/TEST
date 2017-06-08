package com.liuzhen.list.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * @class: Test001
 * @description: 
 * @author Liuzhen
 */
public class Test001 {
	
	public static void main(String[] args) {
		List<TestBean> list =  create();
		System.out.println("输入：");
		print(list);
		quickSort(list, 0, list.size() - 1);
		System.out.println("快排结果：");
		print(list);
		mergeElements(list);
		System.out.println("合并结果：");
		print(list);
	}
	
	/**
	 * @title:  create
	 * @description: 创建入参list
	 * @return 
	 * @author: Liuzhen
	 * @date:   2017-5-9 9:28
	 */
	private static List<TestBean> create() {
		List<TestBean> list = new ArrayList<>();
		for (int i = 10; i < 15; i++) {
			list.add(new TestBean(i< 2 ? i + 1 : i, i + 1));
		}
		for (int i = 0; i < 5; i++) {
			list.add(new TestBean(i< 2 ? i + 1 : i, i + 1));
		}
		list.add(new TestBean(3, 5));
		return list;
	}
	
	/**
	 * @title:  quickSort
	 * @description: 快排
	 * @param list
	 * @param low
	 * @param high
	 * @author: Liuzhen
	 * @date:   2017-5-9 9:29
	 */
	private static void quickSort(List<TestBean> list, int low, int high) {
		if (low < high) {
			int start = low;							// 本次排序的数组头
			int end = high;								// 本次排序的数组尾
			int mid = list.get(low).getKey();			// 参考点
			TestBean t = list.get(low);
			while (low < high) {
				while (low < high && mid <= list.get(high).getKey()) {	// 右侧比参考点大的不交换
					high--;
				}
				list.set(low, list.get(high));			// 右侧比参考点小的左移
				while (low < high && list.get(low).getKey() <= mid) {	// 左侧比参考点小的不交换
					low++;
				}
				list.set(high, list.get(low));			// 左侧比参考点大的右移
			}
			list.set(low, t);							// 参考点数据安置
			quickSort(list, start, low - 1);		// 参考点左侧数组排序
			quickSort(list, low + 1, end);			// 参考点右侧数组排序
		}
	}
	
	/**
	 * @title:  mergeElements
	 * @description: 合并同key元素
	 * @param list
	 * @author: Liuzhen
	 * @date:   2017-5-9 9:29
	 */
	private static void mergeElements(List<TestBean> list) {
		if (list == null) {
			return;
		}
		TestBean temp = new TestBean();
		for (int i = 0; i <list.size(); i++) {
			TestBean t = list.get(i);
			if (temp.getKey() == t.getKey()) {
				temp.setValue(temp.getValue() + t.getValue());
				list.remove(i--);
			} else {
				temp = list.get(i);
			}
		}
	}
	
	/**
	 * @title:  print
	 * @description: 打印
	 * @param list
	 * @author: Liuzhen
	 * @date:   2017-5-9 9:38
	 */
	private static void print(List<TestBean> list) {
		for (TestBean testBean : list) {
			System.out.println("对象地址:" + testBean.toString() + " ,key:" + testBean.getKey() + " ,value:" + testBean.getValue());
		}
	}
}
