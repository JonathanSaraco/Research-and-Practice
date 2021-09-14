package com.jonsaraco.leetcode.medium;

public class SortedLinkedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode bst = sortedListToBST(head);
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return sortedListToBST(head, null);
    }

    /**
     * Uses fast and slow traversal. Slow will be at the middle of the sorted linked list.
     */
    private static TreeNode sortedListToBST(ListNode head, ListNode tail) {
        ListNode slow = head, fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode newNode = new TreeNode(slow.val);
        newNode.left = sortedListToBST(head, slow);
        newNode.right = sortedListToBST(slow.next, tail);
        return newNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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