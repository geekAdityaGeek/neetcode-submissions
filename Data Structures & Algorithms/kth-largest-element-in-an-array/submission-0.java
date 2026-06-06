class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int n : nums) {
            minHeap.add(n);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            //System.out.println(minHeap);
        }
        return minHeap.peek();
    }
}
