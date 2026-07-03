class Solution {
    int dp[][];
    private int compute(String s, String t, int pos1, int pos2) {
        if (pos2 == t.length()) {
            return 1;
        }
        if (pos1 >= s.length()) {
            return 0;
        }

        if(dp[pos1][pos2] != -1) {
            return dp[pos1][pos2];
        }
        int ans = compute(s, t, pos1 + 1, pos2);
        if (s.charAt(pos1) == t.charAt(pos2)) {
            ans = ans + compute(s, t, pos1 + 1, pos2 + 1);
        }
        dp[pos1][pos2] = ans;
        return ans;
    }
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return compute(s, t, 0, 0);
    }
}
