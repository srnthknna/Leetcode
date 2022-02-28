// https://leetcode.com/problems/describe-the-painting

class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> des = new HashMap<>();
        for (int[] segment : segments) {
            des.put(segment[0], des.getOrDefault(segment[0], 0L) + segment[2]);
            des.put(segment[1], des.getOrDefault(segment[1], 0L) - segment[2]);
        }
        
        List<List<Long>> result = new ArrayList<>();
        long i = 0, sum = 0;
        for (int key : des.keySet()) {
            if (sum > 0) {
                result.add(Arrays.asList(i, (long) key, sum));
            }
            sum += des.get(key);
            i = key;
        }
        return result;
    }
}