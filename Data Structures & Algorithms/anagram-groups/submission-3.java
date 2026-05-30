class Solution {
    private String createKey(String a) {
        int freq[] = new int[26];
        for(int i=0;i<a.length();i++) {
            freq[a.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append((char)(i+'a')).append("-").append(freq[i]).append("_");
        }
        return sb.toString();
        
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        HashMap<String, List<String>> anagrams = new HashMap();
        for(int i=0;i<strs.length;i++) {
            String key = createKey(strs[i]);
            List<String> lists = anagrams.getOrDefault(key, new ArrayList());
            lists.add(strs[i]);
            anagrams.put(key, lists);
        }
        return new ArrayList(anagrams.values());
    }
}
