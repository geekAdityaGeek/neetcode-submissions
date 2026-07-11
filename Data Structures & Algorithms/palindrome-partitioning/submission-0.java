class Solution {

    List<List<String>> ans = new ArrayList();

    private boolean isPallindrome(String s) {
        int l = 0 ;
        int h = s.length()-1;
        while(l < h && s.charAt(l) == s.charAt(h)) {
            l++;
            h--;
        }
        return l>=h;
    }
    private void compute(String s, int pos, Stack<String> res) {

        if(pos == s.length()) {
            ans.add(new ArrayList<String>(res));
            return;
        } 

        String curr = "";
        for(int i = pos; i<s.length();i++) {
            curr = curr + s.charAt(i);
            if(isPallindrome(curr)) {
                res.push(curr);
                compute(s, i+1, res);
                res.pop();
            }
        }
    }
    public List<List<String>> partition(String s) {
        compute(s, 0, new Stack());
        return ans; 
    }
}
