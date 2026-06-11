class Solution {
    byte dp[];
    private boolean compute(String s, int start, Set<String> dict) {

        if(start >= s.length()) {
            return true;
        }
        if(dp[start] != -1) {
            return dp[start] == 1;
        }
        //System.out.println(s.substring(start, s.length()));
        boolean ans = false;
        for(int i = start; i<s.length();i++) {
            String t = s.substring(start, i+1);
            //System.out.println("\t "+t);
            if(dict.contains(t)) {
                ans = ans || compute(s, i+1, dict);
            }
        }
        dp[start] = ans ? (byte)1 : (byte)0;
        return ans;

    }
    public boolean wordBreak(String s, List<String> wordDict) {

        dp = new byte[s.length()];
        for(int i=0;i<dp.length;i++) {
            dp[i] = -1;
        }
        return compute(s, 0, new HashSet(wordDict));
        
    }
}
