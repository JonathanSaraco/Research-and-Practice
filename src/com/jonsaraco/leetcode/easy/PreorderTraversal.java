package com.jonsaraco.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
 * Memory Usage: 37.5 MB, less than 48.74% of Java online submissions for Binary Tree Preorder Traversal.
 */
public class PreorderTraversal {

    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root != null) {
            integers.add(root.val);
            integers.addAll(preorderTraversal(root.left));
            integers.addAll(preorderTraversal(root.right));
        }
        return integers;
    }

}
