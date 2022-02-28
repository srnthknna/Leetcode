// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : nums) pq.add(num);
        while (k-- > 0) pq.add(-pq.poll());
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += pq.poll();
        return sum;
    }
}