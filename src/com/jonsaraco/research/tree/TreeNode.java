package com.jonsaraco.research.tree;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    private Map<Character, TreeNode> children = new HashMap<>();
    private boolean isEndOfWord = false;

    public Map<Character, TreeNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
}
