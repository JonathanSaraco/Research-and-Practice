package com.jonsaraco.research.bst;

public class SortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        IntegerTreeNode bst = sortedArrayToBST(nums);
    }

    public static IntegerTreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static IntegerTreeNode sortedArrayToBST(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        IntegerTreeNode node = new IntegerTreeNode(nums[middleIndex]);
        node.left = sortedArrayToBST(nums, leftIndex, middleIndex - 1);
        node.right = sortedArrayToBST(nums, middleIndex + 1, rightIndex);
        return node;
    }

    static class IntegerTreeNode {
        int val;
        IntegerTreeNode left;
        IntegerTreeNode right;

        IntegerTreeNode() {
        }

        IntegerTreeNode(int val) {
            this.val = val;
        }

        IntegerTreeNode(int val, IntegerTreeNode left, IntegerTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
