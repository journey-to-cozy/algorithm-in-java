package com.algorithm.tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {

	private static final String spliter = ",";
	private static final String NN = "X";

	public static void main(String[] args) {
		Codec ser = new Codec();
		Codec deser = new Codec();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode rightTreeNode = new TreeNode(3);
		root.right = rightTreeNode;
		rightTreeNode.left = new TreeNode(4);
		rightTreeNode.right = new TreeNode(5);

		String treeString = ser.serialize(root);
		System.out.println(treeString);
		TreeNode ans = deser.deserialize(treeString);
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null)
			sb.append(NN).append(spliter);
		else {
			sb.append(root.val).append(spliter);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(spliter)));

		return buildTree(nodes);
	}

	private TreeNode buildTree(Deque<String> nodes) {
		String val = nodes.remove();
		if (val.equals(NN))
			return null;

		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = buildTree(nodes);
		node.right = buildTree(nodes);

		return node;
	}
}
