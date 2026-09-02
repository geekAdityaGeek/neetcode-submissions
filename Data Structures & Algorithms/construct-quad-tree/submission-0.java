/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private boolean allSame(int[][] grid, int[] leftcorner, int[] rightcorner) {
        int val = grid[leftcorner[0]][leftcorner[1]];
        for(int i=leftcorner[0] ; i<=rightcorner[0]; i++) {
            for(int j=leftcorner[1]; j <=rightcorner[1] ; j++) {
                if(val != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }
    private Node create(int[][] grid, int[] leftcorner, int[] rightcorner, int cnt) {
        if(cnt > 5) { 
            return null;
        }
        //System.out.println(leftcorner[0]+" : " + leftcorner[1] + "  |  "+rightcorner[0] + " : "+rightcorner[1] + "  |  "+allSame(grid, leftcorner, rightcorner));
        if(allSame(grid, leftcorner, rightcorner)) {
            boolean val = grid[leftcorner[0]][leftcorner[1]] == 0 ? false : true;
            return new Node(val, true, null, null, null, null);
        }
        int x = (rightcorner[0]+leftcorner[0]) / 2;
        int y = (rightcorner[1]+leftcorner[1]) / 2;
        //System.out.println(x+" : "+y);
        Node topleft = create(grid, new int[]{leftcorner[0], leftcorner[1]}, new int[]{x, y}, cnt+1);
        Node topright = create(grid, new int[]{leftcorner[0], y+1}, new int[]{x, rightcorner[1]}, cnt+1);
        Node downleft = create(grid, new int[]{x+1, leftcorner[1]}, new int[]{rightcorner[0], y}, cnt+1); 
        Node downright = create(grid, new int[]{x+1, y+1}, new int[]{rightcorner[0], rightcorner[1]}, cnt+1);
        return new Node(true, false, topleft, topright, downleft, downright);

    }
    public Node construct(int[][] grid) {
        int m = grid.length-1 ; 
        int n = grid[0].length-1;
        return create(grid, new int[]{0,0}, new int[]{m, n}, 0);

    }
}