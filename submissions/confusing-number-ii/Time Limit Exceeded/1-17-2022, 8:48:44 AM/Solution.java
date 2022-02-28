// https://leetcode.com/problems/confusing-number-ii

class Solution {
    int[] rotate = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    Set<Integer> candidates = new HashSet<>(Arrays.asList(0, 1, 6, 8, 9));
    int res = 0;
    
    public int confusingNumberII(int n) {
        helper(n, 0);
        return res;
    }
    
    private void helper(int n, int curr) {
        if (isConfusing(curr)) {
            res++;
        }
        
        for (int i : candidates) {
            if (curr * 10 + i <= n && curr * 10 + i != 0) {
                helper(n, curr * 10 + i);
            }
        }
    }
    
    private boolean isConfusing(long n) {
        long original = n, rev = 0;
        while (n > 0) {
            rev = rev * 10 + rotate[(int) n % 10];
            n /= 10;
        }
        return rev != original;
    }
}