class Solution {
    int dp[][];
    private int compute(String s1, String s2, int pos1, int pos2) {
        if (pos1 == s1.length()) {
            return s2.length() - pos2;
        }
        if (pos2 == s2.length()) {
            return s1.length() - pos1;
        }

        if (dp[pos1][pos2] != -1) {
            return dp[pos1][pos2];
        }

        int ans = Integer.MAX_VALUE;
        if (s1.charAt(pos1) == s2.charAt(pos2)) {
            ans = compute(s1, s2, pos1 + 1, pos2 + 1);
        } else {
            int insert = compute(s1, s2, pos1, pos2 + 1);
            int delete = compute(s1, s2, pos1 + 1, pos2);
            int replace = compute(s1, s2, pos1 + 1, pos2 + 1);
            ans = Math.min(insert, delete);
            ans = Math.min(ans, replace) + 1;
        }
        dp[pos1][pos2] = ans;
        return ans;
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return compute(word1, word2, 0, 0);
    }
}
