class Solution {
    public String longestPalindrome(String s) {
        int start = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            // compute odd length pallindrom
            int mid = i;
            int ptr = 0;
            while (mid - ptr >= 0 && mid + ptr < s.length()
                && s.charAt(mid - ptr) == s.charAt(mid + ptr)) {
                ptr++;
            }
            int newLen = 2 * ptr - 1;
            if (newLen > len) {
                start = mid - ptr + 1;
                len = newLen;
            }

            // compute even length pallindrome
            if (mid + 1 < s.length() && s.charAt(mid) == s.charAt(mid + 1)) {
                int nextMid = mid + 1;
                ptr = 0;
                while (mid - ptr >= 0 && nextMid + ptr < s.length()
                    && s.charAt(mid - ptr) == s.charAt(nextMid + ptr)) {
                    ptr++;
                }
                newLen = 2 * ptr;
                if (newLen > len) {
                    start = mid - ptr + 1;
                    len = newLen;
                }
                //System.out.println(start + " : " + len);
            }
        }

        return s.substring(start, start + len);
    }
}
