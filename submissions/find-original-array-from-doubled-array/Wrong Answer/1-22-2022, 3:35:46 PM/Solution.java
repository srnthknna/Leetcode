// https://leetcode.com/problems/find-original-array-from-doubled-array

class Solution {
    public int[] findOriginalArray(int[] changed) {
        Set<Integer> set = new HashSet<>();
        
        if (changed.length % 2 != 0) return new int[0];
        
        for (int change : changed) {
            set.add(change);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int change : changed) {
            if (!set.contains(change)) continue;
            if (set.contains(change)) {
                if (set.contains(change * 2)) {
                    result.add(change);
                    set.remove(change);
                    set.remove(change * 2);
                } else if (set.contains(change / 2)) {
                    result.add(change / 2);
                    set.remove(change);
                    set.remove(change / 2);
                }
            }
        }
        
        if (!set.isEmpty()) return new int[0];
        
        int[] resultArr = new int[result.size()];
        int index = 0;
        for (int i : result) {
            resultArr[index++] = i;
        }
        return resultArr;
    }
}