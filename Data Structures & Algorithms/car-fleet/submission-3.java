/**
 * Calculates the number of car fleets that will arrive at the target.
 *
 * Problem:
 * --------
 * Given the target position, along with the current position and speed of each car,
 * determine how many fleets reach the destination.
 *
 * A car fleet is a group of one or more cars traveling together at the same speed.
 * A faster car cannot pass a slower car ahead of it. If a car catches up to another
 * car before reaching the target, it becomes part of that car's fleet and adopts
 * the fleet's effective arrival time.
 *
 * Approach:
 * ---------
 * 1. Pair each car's position and speed.
 * 2. Sort cars by position in ascending order (furthest from target to closest).
 * 3. Compute the time required for each car to reach the target:
 *
 *      time = (target - position) / speed
 *
 * 4. Traverse cars from right to left (closest car to target first).
 * 5. Use a monotonic stack to identify the nearest fleet ahead that the current
 *    car can potentially join.
 *
 *      - If the current car requires more time to reach the target than the fleet
 *        ahead, it cannot catch that fleet and becomes a new fleet.
 *      - Otherwise, it merges into an existing fleet.
 *
 * 6. A parent array is used to track the fleet leader for each car.
 *    Cars with parent[i] == -1 are fleet leaders.
 * 7. The final answer is the count of fleet leaders.
 *
 * Data Structures:
 * ----------------
 * - positionSpeed[][] : Stores (position, speed) pairs.
 * - time[]            : Time required for each car to reach the target.
 * - stack             : Monotonic stack used to find reachable fleets.
 * - parent[]          : Tracks fleet membership.
 *
 * Time Complexity:
 * ----------------
 * O(n log n)
 *   - Sorting dominates the runtime.
 *   - Stack processing is O(n).
 *
 * Space Complexity:
 * -----------------
 * O(n)
 *   - Additional arrays and stack.
 *
 * Example:
 * --------
 * target = 12
 * position = [10, 8, 0, 5, 3]
 * speed    = [ 2, 4, 1, 1, 3]
 *
 * Output: 3
 *
 * Explanation:
 * Cars eventually form 3 distinct fleets before reaching the target.
 *
 * @param target   Destination position.
 * @param position Position of each car.
 * @param speed    Speed of each car.
 * @return Number of fleets that arrive at the target.
 */
class Solution {

    private void print(double[] ar) {
        for(Double n: ar) {
            System.out.print(n+" : ");
        }
        System.out.println();
    }
    private void print(int[] ar) {
        for(int n: ar) {
            System.out.print(n+" : ");
        }
        System.out.println();
    }
    private void print(int[][] ar) {
        for(int[] n: ar) {
            System.out.print("("+n[0]+", "+n[1]+") : ");
        }
        System.out.println();
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] positionSpeed = new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            positionSpeed[i] = new int[] {position[i], speed[i]};
        }
        Comparator<int[]> comparator = (a, b) -> a[0] - b[0];
        Arrays.sort(positionSpeed, comparator);
        //print(positionSpeed);
        double time[] = new double[speed.length];
        for (int i = 0; i < speed.length; i++) {
            time[i] = (target * 1.0 - positionSpeed[i][0]) / positionSpeed[i][1];
        }
        //print(time);
        int[] effectiveTimePos = new int[time.length];
        int[] parent = new int[time.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < effectiveTimePos.length; i++) {
            effectiveTimePos[i] = i;
            parent[i] = -1;
        }
        stack.push(effectiveTimePos.length - 1);
        for (int i = effectiveTimePos.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && time[stack.peek()] < time[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                effectiveTimePos[i] = stack.peek();
                if (parent[stack.peek()] == -1) {
                    parent[i] = stack.peek();
                } else {
                    parent[i] = parent[stack.peek()];
                }
            }
            //System.out.println(stack);
            //print(effectiveTimePos);
            stack.push(i);
        }
       // print(parent);

        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }
}
