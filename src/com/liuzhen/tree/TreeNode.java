package com.liuzhen.tree;

public class TreeNode {
	
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public static void main(String[] args){
		TreeNode node = new TreeNode();
		
		// node.leftChild = new TreeNode();
		
		// node.rightChild = new TreeNode();
		
		destroy(node);
		System.out.println(node);
		// 现在的node 是什么状况？
	}
	
	public static void destroy(TreeNode node){
		if(node == null){
			return;
		}
		destroy(node.leftChild);
		
		destroy(node.rightChild);
		
		node = null;
	}
}

