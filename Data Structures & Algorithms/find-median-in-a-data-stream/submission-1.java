class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue();

    public MedianFinder() {}

    public void addNum(int num) {
        // maxHeap - contains lesser elements
        // minHeap - contains larger elements

        if (minHeap.size() > 0 && num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
        //System.out.println("maxHeap : " + maxHeap);
        //System.out.println("minHeap : " + minHeap);
    }

    public double findMedian() {
        int len = maxHeap.size() + minHeap.size();
        if (len % 2 == 0) {
            int a = maxHeap.peek();
            int b = minHeap.isEmpty() ? 0 : minHeap.peek();
            return (1.0*a + b) / 2;
        }
        return maxHeap.peek();
    }
}
