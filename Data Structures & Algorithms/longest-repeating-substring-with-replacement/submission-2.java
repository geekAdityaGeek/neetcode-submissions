class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < s.length() && l <= r) {
            freq[s.charAt(r) - 'A']++;
            int max = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, freq[i]);
            }
            int remain = (r - l + 1) - max;
            if (remain <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                freq[s.charAt(l) - 'A']--;
                l++;
                r++;
            }
            // System.out.println(l + " : " + r + " : " + max + ":" + maxLen);
        }
        return maxLen;
    }
}
