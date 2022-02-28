// https://leetcode.com/problems/array-transformation

class Solution {
    public List<Integer> transformArray(int[] arr) {
        int changes;
        List<Integer> result = new ArrayList<>();
        
        for (int num : arr)
            result.add(num);
        
        do {
            changes = 0;
            for (int i = 1; i < arr.length - 1; i++) {
                if (result.get(i - 1) > result.get(i) && result.get(i + 1) > result.get(i)) {
                    changes++;
                    result.set(i, result.get(i) + 1);
                } else if (result.get(i - 1) < result.get(i) && result.get(i + 1) < result.get(i)) {
                    changes++;
                    result.set(i, result.get(i) - 1);
                }
            }
        } while (changes != 0);
        
        return result;
    }
}