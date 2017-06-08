package com.liuzhen.algorithm.basesort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

	private void heap(int[] a) {
		buildHeap(a);
		for (int i = a.length - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeap(a, i, 0);
		}
	}
	
	/**
	 * 创建heap
	 * 1、数组构成二叉树
	 * 2、父节点数值 > 子节点数值
	 * 以index为节点的例子:
	 * 				0
	 * 				/\
	 * 			   1  2
	 * 			  /\ /\
	 * 			 3 4 5 6
	 * 			/\ /
	 * 		   7 8 9
	 * 若某节点index为k,则其左子index为2k + 1,右子index为2k + 2
	 */
	private void buildHeap(int[] a) {
		for (int i = a.length/2; i >= 0; i--) {
			maxHeap(a, a.length, i);
		}
	}
	
	private void maxHeap(int[] a, int size, int index) {
		int left = index * 2 + 1;						// 左子
		int right = index * 2 + 2;						// 右子
		int largest = index;							// 存放最大值index
		if (left < size && a[left] > a[index]) {
			largest = left;
		}
		if (right < size && a[right] > a[largest]) {
			largest = right;
		}
		if (index != largest) {
			int temp = a[index];
			a[index] = a[largest];
			a[largest] = temp;
			maxHeap(a, size, largest);					// 如果产生过交换,还要继续向下查树,以便符合规则
		}
	}
	
	public static void main(String[] args) {
		int[] a = {45, 46, 87, 32, 12, 44, 99, 1, 10};
		HeapSort t = new HeapSort();
		t.heap(a);
		System.out.println(Arrays.toString(a));
	}
}
