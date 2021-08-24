package com.company.leetcode.easy;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode startingRoot = new TreeNode(4,
                new TreeNode(2, new TreeNode(1, new TreeNode(), new TreeNode()), new TreeNode(3, new TreeNode(), new TreeNode())),
                new TreeNode(7, new TreeNode(6, new TreeNode(), new TreeNode()), new TreeNode(9, new TreeNode(), new TreeNode())));

        TreeNode invertedTree = invertTree(startingRoot);

        int i=2;
    }

    public static TreeNode invertTree(TreeNode root) {
        return root != null ? new TreeNode(root.val, invertTree(root.right), invertTree(root.left)) :
                root;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
