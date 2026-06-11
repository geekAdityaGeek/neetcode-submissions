class Solution {
    int dp[];
    private int compute(String s, int pos) {
        if(pos >= s.length()) {
            return 1;
        }
        if (s.charAt(pos) == '0') {
            return 0;
        }
        if (pos == s.length() - 1) {
            return 1;
        }
        if (dp[pos] != -1) {
            return dp[pos];
        }
        int ans = 0;
        int digits = Integer.parseInt(s.substring(pos, pos + 2));
        if (0 < digits && digits <= 26) {
            ans = ans + compute(s, pos + 2);
        }
        ans = ans + compute(s, pos + 1);
        dp[pos] = ans;
        return ans;
    }
    public int numDecodings(String s) {
        dp = new int[s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return compute(s, 0);
    }
}
