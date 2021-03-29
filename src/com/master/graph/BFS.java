package com.master.graph;

import com.master.link.SingleNode;
import com.master.queue.Queue;

/**
 * @class: BFS
 * @description: 采用面向过程方式
 * @author: L.zhen
 * @date: 2020/3/23 1:14
 */
public class BFS {
	
	int[] vexList = null;
	SingleNode[] adjList = null;
	boolean[] visited = null;
	
	public void init() {
		
		/*
		 * 顶点     顶点的邻接
		 *  0        2 1 5
		 *  1        0 2
		 *  2        0 1 3 4
		 *  3        5 4 2
		 *  4        3 2
		 *  5        3 0
		 */
		
		vexList = new int[6];
		for (int i = 0; i < 6; i++) {
			vexList[i] = i;
		}
		
		adjList = new SingleNode[vexList.length];
		adjList[0] = new SingleNode(2, new SingleNode(1, new SingleNode(5, null)));
		adjList[1] = new SingleNode(0, new SingleNode(2, null));
		adjList[2] = new SingleNode(0, new SingleNode(1, new SingleNode(3, new SingleNode(4, null))));
		adjList[3] = new SingleNode(5, new SingleNode(4, new SingleNode(2, null)));
		adjList[4] = new SingleNode(3, new SingleNode(2, null));
		adjList[5] = new SingleNode(3, new SingleNode(0, null));
		
		visited = new boolean[vexList.length];
	}
	
	public void search(int start) {
		if (start >= vexList.length || start < 0) {
			System.out.println("开始位置错误");
			return;
		}
		Queue q = new Queue(vexList.length + 10);
		int begin = start;
		do {
			if (!visited[begin]) {
				visited[begin] = true;
				System.out.println("visit: " + begin);
				q.push(begin);
				while (!q.empty()) {
					int a = q.pop();
					SingleNode s = adjList[a];
					while (s != null) {
						if (!visited[s.getData()]) {
							visited[s.getData()] = true;
							System.out.println("visit: " + s.getData());
							q.push(s.getData());
						}
						s = s.getNext();
					}
					
				}
			}
			begin = ++begin % vexList.length;
		} while (begin != start);
		
	}
	
	public static void main(String[] args) {
		BFS bfs = new BFS();
		bfs.init();
		bfs.search(0);
		
	}
}
