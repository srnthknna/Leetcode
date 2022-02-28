// https://leetcode.com/problems/array-of-doubled-pairs

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a: arr)
            map.put(a, map.getOrDefault(a, 0) + 1);
        
        Integer[] brr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            brr[i] = arr[i];
        
        Arrays.sort(brr, Comparator.comparingInt(Math::abs));
        
        for (int b : brr) {
            if (map.get(b) == 0) {
                continue;
            }
            if (map.getOrDefault(2 * b, 0) <= 0) return false;
            
            map.put(b, map.get(b) - 1);
            map.put(2 * b, map.get(2 * b) - 1);
        }
        return true;
    }
}