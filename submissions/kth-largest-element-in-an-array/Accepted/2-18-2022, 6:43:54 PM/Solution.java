// https://leetcode.com/problems/kth-largest-element-in-an-array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) 
                pq.poll();
        }
        return pq.poll();
    }
}