/**
 * For each day, determines the distance to the next day having a
 * higher temperature using a monotonic stack.
 *
 * Approach:
 * ---------
 * 1. Initialize an array 'pos' where pos[i] initially stores i.
 * 2. Traverse the temperature array from right to left.
 * 3. Maintain a monotonic decreasing stack containing indices of
 *    candidate warmer days.
 *
 * 4. For each day:
 *      - Remove all indices whose temperatures are less than or
 *        equal to the current day's temperature because they can
 *        never be the next warmer day for the current index or any
 *        earlier index.
 *      - After popping, the stack top (if present) represents the
 *        nearest day to the right with a higher temperature.
 *      - Store that index in pos[i].
 *
 * 5. Convert the stored indices into distances:
 *
 *      answer[i] = nextWarmerIndex - i
 *
 *    If no warmer day exists, pos[i] remains equal to i, resulting
 *    in an answer of 0.
 *
 * Data Structures:
 * ----------------
 * - pos[]   : Stores the index of the next warmer day.
 * - stack   : Monotonic decreasing stack of temperature indices.
 *
 * Example:
 * --------
 * temperatures = [30, 40, 35, 50]
 *
 * Processing:
 * Day 0 (30) -> next warmer day at index 1
 * Day 1 (40) -> next warmer day at index 3
 * Day 2 (35) -> next warmer day at index 3
 * Day 3 (50) -> no warmer day
 *
 * Result:
 * [1, 2, 1, 0]
 *
 * Time Complexity:
 * ----------------
 * O(n)
 * Each index is pushed and popped at most once.
 *
 * Space Complexity:
 * -----------------
 * O(n)
 * For the stack and auxiliary arrays.
 *
 * @param temperatures Array of daily temperatures.
 * @return Number of days until a warmer temperature is encountered
 *         for each day, or 0 if no warmer day exists.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int pos[] = new int[temperatures.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(pos.length - 1);
        for (int i = pos.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                pos[i] = stack.peek();
            }
            stack.push(i);
        }

        int ans[] = new int[pos.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pos[i] - i;
        }

        return ans;
    }
}
