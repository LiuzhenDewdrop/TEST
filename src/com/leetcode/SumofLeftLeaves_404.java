package com.leetcode;

/*
 * @class: SumofLeftLeaves_404
 * @description: 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @author: L.zhen
 * @date: 2018/8/30 16:41
 */
public class SumofLeftLeaves_404 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		return 0;
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(8);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(test001(root));
	}
	
	public static int test001(TreeNode root) {
		return root == null ? 0 : (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0) + test001(root.left) + test001(root.right);
	}
	
	public static int test002(TreeNode root) {
		return (root == null || root.left == null || root.left.left != null || root.left.right != null ? 0 : root.left.val) + test002(root.left) + test002(root.right);
	}
}
