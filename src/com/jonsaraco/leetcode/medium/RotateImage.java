package com.jonsaraco.leetcode.medium;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 * Memory Usage: 39.5 MB, less than 7.58% of Java online submissions for Rotate Image.
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int numShells = (int) Math.ceil(n / 2.);
        int row = 0;
        while (row < numShells) {
            for (int i = row; i < n - row - 1; i++) {
                int value = matrix[row][i];
                matrix[row][i] = matrix[n - 1 - i][row]; // Value on top = value on left
                matrix[n - 1 - i][row] = matrix[n - 1 - row][n - 1 - i]; // Value on left = value on bottom
                matrix[n - 1 - row][n - 1 - i] = matrix[i][n - 1 - row]; // Value on bottom = value on right
                matrix[i][n - 1 - row] = value; // Value on right = value on top
            }
            row++;
        }
    }

}
