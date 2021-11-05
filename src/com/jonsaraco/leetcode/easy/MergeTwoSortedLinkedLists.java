package com.jonsaraco.leetcode.easy;

public class MergeTwoSortedLinkedLists {

    /**
     * Iterative solution
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.4 MB, less than 65.31% of Java online submissions for Merge Two Sorted Lists.
     */
    public ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        ListNode result = new ListNode();
        ListNode current = result;
        while (l1Current != null && l2Current != null) {
            if (l1Current.val < l2Current.val) {
                current.next = new ListNode(l1Current.val);
                l1Current = l1Current.next;
            } else {
                current.next = new ListNode(l2Current.val);
                l2Current = l2Current.next;
            }
            current = current.next;
        }
        if (l1Current == null) {
            current.next = l2Current;
        } else {
            current.next = l1Current;
        }
        return result.next;
    }

    /**
     * Recursive solution, copied from discussion board
     */
    public ListNode mergeTwoListsRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    private class ListNode {
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
}
