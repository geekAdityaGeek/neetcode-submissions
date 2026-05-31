/**
 * Computes the area of the largest rectangle that can be formed
 * within a histogram.
 *
 * Problem:
 * --------
 * Given an array where each element represents the height of a histogram
 * bar of width 1, find the maximum rectangular area that can be formed.
 *
 * Example:
 *
 *      Heights = [2, 1, 5, 6, 2, 3]
 *
 *                 |
 *             |   |
 *             |   |
 *         |   |   |
 *         |   |   |   |
 *     |   |   |   |   |
 * ------------------------
 *
 * Largest rectangle = 5 × 2 = 10
 *
 * Approach:
 * ---------
 * For every bar, determine the widest range over which that bar can act
 * as the minimum height of a rectangle.
 *
 * To achieve this:
 *
 * 1. Find the Previous Smaller Element (PSE):
 *      - The nearest bar on the left having a smaller height.
 *
 * 2. Find the Next Smaller Element (NSE):
 *      - The nearest bar on the right having a smaller height.
 *
 * 3. For each bar i:
 *
 *      width =
 *          nextSmallerIndex
 *          - prevSmallerIndex
 *          - 1
 *
 *      area = heights[i] × width
 *
 * 4. The maximum area across all bars is the answer.
 *
 * Monotonic Stack Usage:
 * ----------------------
 * Previous Smaller Element:
 *      Traverse left → right while maintaining an increasing stack.
 *
 * Next Smaller Element:
 *      Traverse right → left while maintaining an increasing stack.
 *
 * Bars greater than or equal to the current height are removed because
 * they cannot serve as a boundary for the current rectangle.
 *
 * Boundary Handling:
 * ------------------
 * If no smaller element exists on the left:
 *
 *      prevSmallerIndex = -1
 *
 * If no smaller element exists on the right:
 *
 *      nextSmallerIndex = heights.length
 *
 * This allows the rectangle to extend to the histogram boundary.
 *
 * Rectangle Calculation:
 * ----------------------
 * For a bar at index i:
 *
 *      leftBoundary  = previous smaller element
 *      rightBoundary = next smaller element
 *
 *      width = rightBoundary - leftBoundary - 1
 *      area  = heights[i] * width
 *
 * Example:
 * --------
 * heights = [2,1,5,6,2,3]
 *
 * Previous Smaller:
 * [-1,-1,1,2,1,4]
 *
 * Next Smaller:
 * [1,-1,4,4,-1,-1]
 *
 * Areas:
 * index 0 -> 2 × 1 = 2
 * index 1 -> 1 × 6 = 6
 * index 2 -> 5 × 2 = 10
 * index 3 -> 6 × 1 = 6
 * index 4 -> 2 × 4 = 8
 * index 5 -> 3 × 1 = 3
 *
 * Maximum Area = 10
 *
 * Time Complexity:
 * ----------------
 * O(n)
 *
 * Each index is pushed and popped at most once from each stack.
 *
 * Space Complexity:
 * -----------------
 * O(n)
 *
 * Additional space is used for:
 * - Previous Smaller Element array
 * - Next Smaller Element array
 * - Monotonic stacks
 *
 * Pattern:
 * --------
 * Monotonic Stack
 * Previous Smaller Element (PSE)
 * Next Smaller Element (NSE)
 * Range Expansion Problems
 *
 * @param heights Histogram bar heights.
 * @return Maximum rectangular area that can be formed.
 */
class Solution {
    private void print(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " : ");
        }
        System.out.println();
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> prevSmallerHeightStack = new Stack<Integer>();
        int[] prevSmallerHeightPos = new int[heights.length];
        Stack<Integer> nextSmallerHeightStack = new Stack<Integer>();
        int[] nextSmallerHeightPos = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            prevSmallerHeightPos[i] = -1;
            nextSmallerHeightPos[i] = -1;
        }

        nextSmallerHeightStack.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!nextSmallerHeightStack.isEmpty()
                && heights[nextSmallerHeightStack.peek()] >= heights[i]) {
                nextSmallerHeightStack.pop();
            }
            if (!nextSmallerHeightStack.isEmpty()) {
                nextSmallerHeightPos[i] = nextSmallerHeightStack.peek();
            }
            nextSmallerHeightStack.push(i);
        }
        //print(nextSmallerHeightPos);

        prevSmallerHeightStack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!prevSmallerHeightStack.isEmpty()
                && heights[prevSmallerHeightStack.peek()] >= heights[i]) {
                prevSmallerHeightStack.pop();
            }
            if (!prevSmallerHeightStack.isEmpty()) {
                prevSmallerHeightPos[i] = prevSmallerHeightStack.peek();
            }
            prevSmallerHeightStack.push(i);
        }
        //print(prevSmallerHeightPos);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int rightBound = nextSmallerHeightPos[i] != -1 ? nextSmallerHeightPos[i] : heights.length;   
            int leftBound = prevSmallerHeightPos[i] != -1 ? prevSmallerHeightPos[i] : -1;
            int area = heights[i] * (rightBound-leftBound-1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
