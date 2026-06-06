class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Element> comparator = (a, b) -> {
            if (a.d > b.d) {
                return -1;
            } else if (a.d == b.d) {
                return 0;
            } else {
                return 1;
            }
        };
        PriorityQueue<Element> minHeap = new PriorityQueue(comparator);
        for (int i = 0; i < points.length; i++) {
            minHeap.add(new Element(points[i][0], points[i][1]));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            //System.out.println(minHeap);
        }
        int ans[][] = new int[minHeap.size()][2];
        int pos = 0;
        for (Element ele : minHeap) {
            ans[pos] = new int[] {ele.x, ele.y};
            pos++;
        }
        return ans;
    }
}

class Element {
    int x;
    int y;
    double d;
    Element(int x, int y) {
        this.x = x;
        this.y = y;
        this.d = computeDist();
    }
    private double computeDist() {
        return Math.sqrt(x * x + y * y);
    }

    public String toString() {
        return "(" + x + "," + y + " : " + d + ")";
    }
}