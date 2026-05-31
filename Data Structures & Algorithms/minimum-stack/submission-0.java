class MinStack {

    private Stack<String> stack;
    private static final String sep = "@"; 

    public MinStack() {
        stack = new Stack<String>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(""+val+sep+val);
            return;
        }
        int min = Integer.parseInt(stack.peek().split(sep)[1]);
        String ele = val+sep+Math.min(min, val);
        stack.push(ele);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        int val = Integer.parseInt(stack.peek().split(sep)[0]);
        return val;
    }
    
    public int getMin() {
        int min = Integer.parseInt(stack.peek().split(sep)[1]);
        return min;
    }
}
