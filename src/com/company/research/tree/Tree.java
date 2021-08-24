package com.company.research.tree;

public class Tree {

    private TreeNode root = new TreeNode();

    public void add(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character currentLetter = word.charAt(i);
            current = current.getChildren().computeIfAbsent(currentLetter, c -> new TreeNode());
        }
        current.setEndOfWord(true);
    }

    public void formSuffixTrie(String word) {
        for (int i=0; i < word.length(); i++) {
            add(word.substring(i));
        }
    }

    public boolean find(String word) {
        TreeNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (current.getChildren().containsKey(character)) {
                current = current.getChildren().get(character);
            } else {
                return false;
            }
        }
        return current.isEndOfWord();
    }

    public boolean isSubstring(String substring) {
        TreeNode current = root;
        for (int i=0; i < substring.length(); i++) {
            char ch = substring.charAt(i);
            if (current.getChildren().containsKey(ch)) {
                current = current.getChildren().get(ch);
            } else {
                System.out.println(substring + " IS NOT a substring.");
                return false;
            }
        }
        System.out.println(substring + " IS a substring.");
        return true;
    }

    public static void main(String[] args) {
        // Let us build a suffix tree for text
        // "geeksforgeeks.org"
        String txt = "geeksforgeeks.org";
        Tree tree = new Tree();
        tree.formSuffixTrie(txt);

        System.out.println("Search for 'ee'");
        tree.isSubstring("ee");

        System.out.println("\nSearch for 'geek'");
        tree.isSubstring("geek");

        System.out.println("\nSearch for 'quiz'");
        tree.isSubstring("quiz");

        System.out.println("\nSearch for 'forgeeks'");
        tree.isSubstring("forgeeks");

        System.out.println();
    }
}
