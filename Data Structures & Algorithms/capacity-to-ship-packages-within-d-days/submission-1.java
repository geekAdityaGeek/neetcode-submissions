class Solution {
    private boolean check(int weights[], int capacity, int days) {
        int d = 1;
        int curr = 0;
        int idx = 0;
        while (idx < weights.length) {
            curr = curr + weights[idx];
            if (curr > capacity) {
                curr = weights[idx];
                d++;
            }
            idx++;
        }
        return d <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = Integer.MIN_VALUE;
        int h = 0;
        for (int i = 0; i < weights.length; i++) {
            l = Math.max(weights[i], l);
            h = h + weights[i];
        }

        int ans = 0;
        while (l <= h) {
            int mid = (l + h) / 2;
            // System.out.println(l + " : " + h + " : " + mid+" : "+ans);
            if (check(weights, mid, days)) {
                h = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}