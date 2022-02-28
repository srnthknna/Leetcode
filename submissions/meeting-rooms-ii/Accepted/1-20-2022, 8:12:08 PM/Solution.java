// https://leetcode.com/problems/meeting-rooms-ii

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        for (int[] interval : intervals) {
            if (!allocator.isEmpty() && interval[0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.offer(interval[1]);
        }
        return allocator.size();
    }
}