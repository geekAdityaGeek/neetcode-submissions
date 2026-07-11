class Solution {
    List<String> ans = new ArrayList();
    Map<Character, String> digitMapping = new HashMap();
    private void compute(String digits, int pos, Stack<Character> res) {
        if (pos == digits.length()) {
            String str = "";
            for (char ch : res) {
                str = str + ch;
            }
            ans.add(str);
            return;
        }

        String seq = digitMapping.get(digits.charAt(pos));
        for (int i = 0; i < seq.length(); i++) {
            res.push(seq.charAt(i));
            compute(digits, pos + 1, res);
            res.pop();
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return ans;
        }
        digitMapping.put('2', "abc");
        digitMapping.put('3', "def");
        digitMapping.put('4', "ghi");
        digitMapping.put('5', "jkl");
        digitMapping.put('6', "mno");
        digitMapping.put('7', "pqrs");
        digitMapping.put('8', "tuv");
        digitMapping.put('9', "wxyz");
        compute(digits, 0, new Stack<Character>());
        return ans;
    }
}
