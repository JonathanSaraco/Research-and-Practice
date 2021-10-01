package com.jonsaraco.microsoft;

/**
 * Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile
 * which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the
 * stack.
 * <p>
 * Determine the minimum number of steps required to make all of the piles equal in height.
 */

public class MakePilesEqualHeight {

    public static void main(String[] args) {
        int[] heights = {1, 1, 2, 2, 2, 3, 3, 3, 4, 4};
        System.out.println(swapsRequired(heights));
    }

    public static int swapsRequired(int[] heights) {
        // Sort heights in order of highest to lowest
        sortArray(heights);
        // Iterate through array and count the number of steps needed whenever we find a next lowest height
        int currentHeight = heights[0];
        int stepsNeeded = 0;
        for (int i = 1; i < heights.length; i++) {
            if (currentHeight != heights[i]) {
                stepsNeeded += i;
                currentHeight = heights[i];
            }
        }
        return stepsNeeded;
    }

    public static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
