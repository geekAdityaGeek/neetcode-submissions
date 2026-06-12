class Solution {
    private int dp[][];
    private int compute(String text1, String text2, int pos1, int pos2) {
        if (pos1 >= text1.length() || pos2 >= text2.length()) {
            return 0;
        }
        if (dp[pos1][pos2] != -1) {
            return dp[pos1][pos2];
        }
        char c1 = text1.charAt(pos1);
        char c2 = text2.charAt(pos2);
        int ans = 0;
        if (c1 == c2) {
            ans = compute(text1, text2, pos1 + 1, pos2 + 1) + 1;
        } else {
            int l1 = compute(text1, text2, pos1 + 1, pos2);
            int l2 = compute(text1, text2, pos1, pos2 + 1);
            ans = Math.max(l1, l2);
        }
        dp[pos1][pos2] = ans;
        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return compute(text1, text2, 0, 0);
    }
}
