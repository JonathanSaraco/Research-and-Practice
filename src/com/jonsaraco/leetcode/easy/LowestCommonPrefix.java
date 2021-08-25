package com.jonsaraco.leetcode.easy;

/**
 * Runtime: 2 ms, faster than 33.57% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 36.9 MB, less than 90.53% of Java online submissions for Longest Common Prefix.
 */
public class LowestCommonPrefix {

    public static void main(String[] args) {
        String[] test = {"ab", "a"};
        System.out.println(longestCommonPrefix(test));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        // Create tree and add words to it, stopping if
        Tree tree = new Tree();
        tree.addWord(strs[0]);
        // Iterate through tree with each word, chopping off leaves from the tree as new words fail to contain them
        // as suffixes
        for (int wordIndex = 1; wordIndex < strs.length; wordIndex++) {
            String word = strs[wordIndex];
            if (tree.root.child == null || word.isEmpty()) return "";
            TreeNode current = tree.root;
            int letterIndex = 0;
            while (current.child != null && letterIndex < word.length()) {
                char ch = word.charAt(letterIndex);
                if (current.child.val == ch) {
                    current = current.child;
                    if (letterIndex == word.length() - 1) {
                        current.child = null;
                        break;
                    }
                } else {
                    current.child = null;
                    break;
                }
                letterIndex++;
            }
        }
        // Iterate through tree and construct the longest surviving prefix
        String result = "";
        TreeNode current = tree.root;
        while (current.child != null) {
            result += current.child.val;
            current = current.child;
        }
        return result;
    }

    static class Tree {
        TreeNode root = new TreeNode(Character.MIN_VALUE);

        public Tree() {
        }

        public void addWord(String word) {
            TreeNode current = root;
            for (char ch : word.toCharArray()) {
                current.child = new TreeNode(ch);
                current = current.child;
            }
        }
    }

    static class TreeNode {
        TreeNode child;
        Character val;

        public TreeNode(Character val) {
            this.val = val;
        }
    }
}
