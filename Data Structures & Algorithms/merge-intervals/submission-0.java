class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList();
        ans.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] lastInterval = ans.getLast();
            if (interval[0] <= lastInterval[1]) {
                lastInterval[0] = Math.min(lastInterval[0], interval[0]);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                ans.add(interval);
            }
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
