class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 + n2);
            } else if ("-".equals(tokens[i])) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 - n1);
            } else if ("*".equals(tokens[i])) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n1 * n2);
            } else if ("/".equals(tokens[i])) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(n2 / n1);
            } else {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
