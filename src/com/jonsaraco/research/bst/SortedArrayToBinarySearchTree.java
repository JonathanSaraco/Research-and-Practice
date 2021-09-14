package com.jonsaraco.research.bst;

public class SortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode bst = sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = sortedArrayToBST(nums, leftIndex, middleIndex - 1);
        node.right = sortedArrayToBST(nums, middleIndex + 1, rightIndex);
        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
