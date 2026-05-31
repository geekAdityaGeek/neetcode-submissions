class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s == null) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }

        Map<Character, Integer> posMapping = new HashMap();
        int start = 0;
        int curr = 1;
        int maxLen = 1;
        posMapping.put(s.charAt(0), 0);
        //System.out.println(posMapping);
        while(curr < s.length()) {
            char ch = s.charAt(curr);
            if(posMapping.containsKey(ch) && posMapping.get(ch) >= start) {
                maxLen = Math.max(maxLen, curr-start);
                start = posMapping.get(ch)+1;
            }
            posMapping.put(ch, curr);
            //System.out.println(posMapping);
            curr++;
        }
        maxLen = Math.max(maxLen, curr-start);
        return maxLen;
    }
}
