/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        List<List<Integer>> bfs = new ArrayList();
        Queue<TreeNode> Q = new LinkedList();
        Q.add(root);
        while(!Q.isEmpty()) {
            int len = Q.size();
            List<Integer> ele = new ArrayList();
            while(len > 0) {
                len--;
                TreeNode node = Q.remove();
                if(node == null) {
                    ele.add(Integer.MIN_VALUE);
                    continue;
                }
                ele.add(node.val);
                Q.add(node.left);
                Q.add(node.right);
            }
            //System.out.println(ele);
            bfs.add(ele);
        }
        //System.out.println(bfs);
        StringBuilder sb = new StringBuilder();
        for(List<Integer> ele : bfs) {
            for(Integer num : ele) {
                sb.append(num == Integer.MIN_VALUE ? "N" : num+"").append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("@");
        }
        sb.deleteCharAt(sb.length()-1);    
        //System.out.println(sb.toString());
        return sb.toString();
    }


    private void print(String s[]) {
        for(String str : s) {
            System.out.println(str+" ");
        }
        System.out.println();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String breadth[] = data.split("@");
        //print(breadth);
        Queue<TreeNode> Q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(breadth[0]));
        Q.add(root);
        int level = 1;
        while(level < breadth.length) {
            String elements[] = breadth[level].split(",");
            int idx = 0;
            while(idx < elements.length) {
                TreeNode node = Q.remove();
                String ele = elements[idx];
                if(!"N".equalsIgnoreCase(ele)) {
                    node.left = new TreeNode(Integer.parseInt(ele));
                    Q.add(node.left);
                }
                idx++;
                ele = elements[idx];
                if(!"N".equalsIgnoreCase(ele)) {
                    node.right = new TreeNode(Integer.parseInt(ele));
                    Q.add(node.right);
                }
                idx++;
            } 
            level++;
        }
        return root;
    }
}
