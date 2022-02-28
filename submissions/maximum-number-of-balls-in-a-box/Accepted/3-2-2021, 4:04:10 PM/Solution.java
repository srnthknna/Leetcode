// https://leetcode.com/problems/maximum-number-of-balls-in-a-box

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = sum(i);
            int times = map.getOrDefault(sum, 0) + 1;
            result = Math.max(result, times);
            map.put(sum, times);
        }
        return result;
    }
    
    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        } 
        return sum;
    }
}