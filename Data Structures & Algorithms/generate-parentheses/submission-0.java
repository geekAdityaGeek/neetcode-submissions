class Solution {
    List<String> ans = new ArrayList();
    private void compute(int n, String curr, int open, int close) {
        if (n == 0) {
            while (open != close) {
                curr = curr + ")";
                close++;
            }
            ans.add(curr);
            return;
        }
        compute(n - 1, curr + "(", open + 1, close);
        if (open > close) {
            compute(n, curr + ")", open, close + 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        compute(n, "", 0, 0);
        return ans;
    }
}
