package com.master.link;

import lombok.Data;

/**
 * @class: Node
 * @description: 
 * @author: L.zhen
 * @date: 2020/3/23 1:33
 */
@Data
public class SingleNode {
	private int data;
	private SingleNode next;
	
	public SingleNode(int data, SingleNode next) {
		this.data = data;
		this.next = next;
	}
}
