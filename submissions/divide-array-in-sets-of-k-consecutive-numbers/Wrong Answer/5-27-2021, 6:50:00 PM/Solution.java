// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers

class Solution {
    public boolean isPossibleDivide(int[] A, int k) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int num : A) {
            if (c.containsKey(num))
                c.put(num, c.get(num) + 1);
            else 
                c.put(num, 1);
        }
        for (int key : c.keySet())
            if (c.get(key) > 0)
                for (int i = k - 1; i >= 0; --i) {
                    if (c.containsKey(key + i) && (c.get(key + i) < c.get(key))) 
                        return false;
                    else
                        c.put(key + i, c.getOrDefault(key + i, 0) - c.get(key));
                }
        return true;
    }
}