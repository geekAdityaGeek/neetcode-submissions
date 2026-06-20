/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>((a, b) -> a.end - b.end);
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int maxCount = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            while(!minHeap.isEmpty() && minHeap.peek().end <= interval.start ) {
                minHeap.remove();
            }
            minHeap.add(interval);
            maxCount = Math.max(maxCount, minHeap.size());
        }
        return maxCount;
    }
}
