package com.jonsaraco.leetcode.easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Runtime: 10 ms, faster than 69.45% of Java online submissions for First Unique Character in a String.
 * Memory Usage: 39 MB, less than 97.00% of Java online submissions for First Unique Character in a String.
 */
public class FirstUniqueCharacterPriorityQueue {

    public static void main(String[] args) {
        String test = "aaabccc";
        System.out.println(firstUniqChar(test));
    }

    public static int firstUniqChar(String s) {
        PriorityQueue<CharacterWithIndex> characterIndexQueue = new PriorityQueue<>();
        Set<Character> duplicateCharacters = new HashSet<>();
        for (int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (duplicateCharacters.contains(ch)) continue;
            CharacterWithIndex chWithIndex = new CharacterWithIndex(ch, i);
            if (characterIndexQueue.contains(chWithIndex)) {
                characterIndexQueue.remove(chWithIndex);
                duplicateCharacters.add(ch);
            } else {
                characterIndexQueue.add(chWithIndex);
            }
        }
        if (characterIndexQueue.isEmpty()) return -1;
        return characterIndexQueue.poll().index;
    }

    static class CharacterWithIndex implements Comparable<CharacterWithIndex> {
        char ch;
        Integer index;

        public CharacterWithIndex(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }

        public int compareTo(CharacterWithIndex other) {
            return this.index.compareTo(other.index);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharacterWithIndex that = (CharacterWithIndex) o;
            return ch == that.ch;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ch);
        }
    }
}
