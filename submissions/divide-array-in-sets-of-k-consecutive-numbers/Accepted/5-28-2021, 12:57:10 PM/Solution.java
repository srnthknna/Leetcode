// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers

class Solution {
    public boolean isPossibleDivide(int[] A, int k) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int num : A) {
            c.merge(num, 1, (a, b) -> a + b);
        }
        for (int key : c.keySet()) {
            if (c.get(key) > 0)
                for (int i = k - 1; i >= 0; --i) {
                    if (c.getOrDefault(key + i, 0) < c.get(key)) {
                        return false;
                    }
                    c.merge(key + i, - c.get(key), (a, b) -> a + b);
                }
        }
        return true;
    }
}