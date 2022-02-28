// https://leetcode.com/problems/array-transformation

class Solution {
    public List<Integer> transformArray(int[] arr) {
        int changes;
        List<Integer> result = new ArrayList<>(), prev = new ArrayList<>(result);
        
        for (int num : arr)
            result.add(num);
        prev = new ArrayList<>(result);
        
        do {
            changes = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (prev.get(i - 1) > prev.get(i) && prev.get(i + 1) > prev.get(i)) {
                    changes++;
                    result.set(i, prev.get(i) + 1);
                } else if (prev.get(i - 1) < prev.get(i) && prev.get(i + 1) < prev.get(i)) {
                    changes++;
                    result.set(i, prev.get(i) - 1);
                }
            }
            prev = new ArrayList<>(result);
        } while (changes != 0);
        
        return result;
    }
}