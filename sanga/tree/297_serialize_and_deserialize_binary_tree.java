package src.sanga.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진 트리를 배열로 직렬화하고, 반대로 역직렬화하는 기능을 구현하라.
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
class Codec {
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

    public String serialize(TreeNode root) {
        if(root ==null) return NN + spliter;
        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.val + spliter + leftSerialized + rightSerialized;
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(spliter)));
        return deserializeHelper(nodesLeft);
    }

    private TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String valueForNode = nodesLeft.poll();
        if(valueForNode.equals(NN)) return null;

        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);

        return newNode;
    }

}