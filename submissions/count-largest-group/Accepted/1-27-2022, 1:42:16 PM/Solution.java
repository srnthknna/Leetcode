// https://leetcode.com/problems/count-largest-group

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, group = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }
        
        for (int val : map.values())
            if (val == max)
                group++;
        return group;
    }
    
    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}