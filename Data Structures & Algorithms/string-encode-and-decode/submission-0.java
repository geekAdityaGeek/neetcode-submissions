class Solution {

    private final char sep = (char)260;
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String str : strs) {
            sb.append(str).append(sep);
        }
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList();
        int start = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == sep) {
                ans.add(str.substring(start, i));
                start = i+1;
            }
        }
        return ans;
    }
}
