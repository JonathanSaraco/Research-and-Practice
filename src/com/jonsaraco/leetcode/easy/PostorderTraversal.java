package com.jonsaraco.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
 * Memory Usage: 37.5 MB, less than 48.41% of Java online submissions for Binary Tree Postorder Traversal.
 */
public class PostorderTraversal {

    private List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) return integers;
        integers.addAll(postorderTraversal(root.left));
        integers.addAll(postorderTraversal(root.right));
        integers.add(root.val);
        return integers;
    }
}
