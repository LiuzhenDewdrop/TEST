package com.master.queue;

import lombok.Data;

/**
 * @class: Queue
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/23 0:49
 */
@Data
public class Queue {
	
	private int size = 10;
	private int[] q = null;
	private int front, rear = 0;
	
	public Queue(int... size) {
		if (size != null) {
			this.size = size[0];
		}
		this.q = new int[this.size];
	}
	
	public void push(int a) {
		if ((rear +1) % size == front) {
			System.out.print("满了,size=" + size + ",front=" + front + ",rear=" + rear + ",queue=");
			print();
			return;
		}
		q[rear++] = a;
		rear %= size;
	}
	
	public boolean empty() {
		return front == rear;
	}
	
	public int pop() {
		if (empty()) {
			System.out.println("empty");
			return -1;
		}
		int a = q[front++];
		front %= size;
		return a;
	}
	
	public void print() {
		if (front == rear) {
			System.out.println("[]");
		}
		System.out.print("[");
		int start = front;
		do {
			if (front != start) {
				System.out.print(",");
			}
			System.out.print(q[start++]);
			start = start % size;
		} while (start != rear);
		System.out.println("]");
	}
	
}
