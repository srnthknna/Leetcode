// https://leetcode.com/problems/find-k-pairs-with-smallest-sums

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> ((a.get(0) + a.get(1)) - (b.get(0) + b.get(1))));
        
        for (int a : nums1)
            for (int b : nums2)
                pq.offer(Arrays.asList(a, b));
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            answer.add(pq.poll());
        }
        return answer;
    }
}