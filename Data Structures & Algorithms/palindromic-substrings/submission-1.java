class Solution {
    private boolean isPallindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return start > end;
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length pallindrome
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (isPallindrome(s, i - j, i + j)) {
                    cnt++;
                }
            }
            // even length pallindrome
            for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
                if (isPallindrome(s, i - j, i + 1 + j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
