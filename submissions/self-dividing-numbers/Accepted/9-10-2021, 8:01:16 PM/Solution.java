// https://leetcode.com/problems/self-dividing-numbers

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSD(i))
                ans.add(i);
        }
        return ans;
    }
    
    private boolean isSD(int num) {
        int copy = num;
        int digit = copy % 10;
        while (copy > 0) {
            if (digit == 0 || num % digit > 0)
                return false;
            copy /= 10;
            digit = copy % 10;
        }
        return true;
    }
}