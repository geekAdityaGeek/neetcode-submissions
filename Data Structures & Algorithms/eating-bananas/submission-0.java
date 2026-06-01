class Solution {
    private boolean canComplete(int[] piles, int h, int k) {
        int pos = 0;
        while (pos < piles.length) {
            int hr = (int) Math.ceil(1.0 * piles[pos] / k);
            h = h - hr;
            pos++;
        }
        return h >= 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) {
            max = Math.max(n, max);
        }
        int low = 1, high = max;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canComplete(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
