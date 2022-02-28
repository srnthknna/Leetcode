// https://leetcode.com/problems/reduce-array-size-to-the-half

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts);
        Collections.reverse(counts);
        
        int setSize = 0, total = 0;
        for (int count : counts) {
            total += count;
            setSize++;
            if (total >= arr.length / 2) {
                break;
            }
        }
        return setSize;
    }
}