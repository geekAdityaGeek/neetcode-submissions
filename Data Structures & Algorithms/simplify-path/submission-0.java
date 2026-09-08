class Solution {
    public String simplifyPath(String path) {
        String cmd[] = path.split("/");
        Stack<String> stack = new Stack();
        for(int i = 0 ; i < cmd.length ; i++) {
            if(".".equalsIgnoreCase(cmd[i]) || cmd[i].length() == 0) {
                continue;
            } else if ("..".equalsIgnoreCase(cmd[i])) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cmd[i]);
            }
        }
        if(stack.isEmpty()) {
            return "/";
        }
        String str = "";
        while(!stack.isEmpty()) {
            str = "/"+stack.pop()+str;
        }
        return str;
    }
}