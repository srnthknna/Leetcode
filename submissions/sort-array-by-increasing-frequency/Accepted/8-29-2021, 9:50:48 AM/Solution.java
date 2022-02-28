// https://leetcode.com/problems/sort-array-by-increasing-frequency

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.<Integer, Integer>comparing(i -> freq.get(i)).thenComparing(i -> -i));
        for (int i : nums)
            pq.offer(i);
        
        int[] ans = new int[nums.length];
        int index = 0;
        while (!pq.isEmpty())
            ans[index++] = pq.poll();
        return ans;
    }
}