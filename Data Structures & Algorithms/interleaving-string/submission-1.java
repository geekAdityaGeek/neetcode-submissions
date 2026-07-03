class Solution {
    char dp[][][];
    private static final char NOT_VISITED = '?';
    private static final char NOT_POSSIBLE = 'X';
    private static final char POSSIBLE = 'O';
    private boolean compute(
        String s1, String s2, String s3, int pos1, int pos2, int pos3, int diff) {
        if (pos1 == s1.length() && pos2 == s2.length() && pos3 == s3.length()) {
            if (Math.abs(diff) <= 1) {
                return true;
            } else {
                return false;
            }
        }
        if (pos3 >= s3.length()) {
            return false;
        }

        char dpVal = dp[pos1][pos2][diff + 100];
        if (dpVal != NOT_VISITED) {
            return dpVal == POSSIBLE;
        }

        boolean firstMatch = pos1 < s1.length() && s1.charAt(pos1) == s3.charAt(pos3);
        boolean secondMatch = pos2 < s2.length() && s2.charAt(pos2) == s3.charAt(pos3);
        boolean ans = false;
        if (firstMatch) {
            ans = ans || compute(s1, s2, s3, pos1 + 1, pos2, pos3 + 1, diff + 1);
        }
        if (secondMatch) {
            ans = ans || compute(s1, s2, s3, pos1, pos2 + 1, pos3 + 1, diff - 1);
        }
        dp[pos1][pos2][diff + 100] = ans ? POSSIBLE : NOT_POSSIBLE;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new char[s1.length() + 1][s2.length() + 1][200];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                    for (int m = 0; m < 200; m++) {
                        dp[i][j][m] = NOT_VISITED;
                    }
                
            }
        }
        return compute(s1, s2, s3, 0, 0, 0, 0);
    }
}
