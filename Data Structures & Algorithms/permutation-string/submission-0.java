class Solution {
    private String getCode(String s, int start, int end) {
        int freq[] = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            sb.append((char) ('a' + i)).append(freq[i]).append("-");
        }
        return sb.toString();
    }
    public boolean checkInclusion(String s1, String s2) {
        String code1 = getCode(s1, 0, s1.length() - 1);
        // System.out.println(code1);
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            // System.out.println(i+":"+(i-s1.length()+1));
            String code2 = getCode(s2, i - s1.length() + 1, i);
            if (code1.equals(code2)) {
                return true;
            }
        }
        return false;
    }
}
