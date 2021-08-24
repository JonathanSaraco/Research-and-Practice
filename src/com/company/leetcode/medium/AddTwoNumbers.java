package com.company.leetcode.medium;

/**
 * Results:
 *
 * Runtime: 2 ms, faster than 60.56% of Java online submissions for Add Two Numbers.
 * Memory Usage: 39.4 MB, less than 38.05% of Java online submissions for Add Two Numbers.
 */

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9)))))));
        ListNode l2 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9))));

        ListNode sum = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        return sumDigits(sum, l1, l2);
    }

    private static ListNode sumDigits(ListNode sum, ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return sum.val == 0 ? null : sum;
        }
        int sumOfValues = l1 == null ? 0 : l1.val;
        sumOfValues += l2 == null ? 0 : l2.val;
        sumOfValues += sum.val;
        int carryOverValue = 0;
        carryOverValue += sum.next == null ? 0 : sum.next.val;
        carryOverValue += sumOfValues >= 10 ? 1 : 0;
        ListNode carryOverNode = new ListNode(carryOverValue);
        sum.val = sumOfValues % 10;
        sum.next = carryOverNode;
        return new ListNode(sum.val, sumDigits(carryOverNode, l1 == null ? null : l1.next, l2 == null ? null : l2.next));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
