// https://leetcode.com/problems/simplified-fractions

class Solution {
    public List<String> simplifiedFractions(int n) {
        Set<String> ans = new HashSet<>();
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (gcd(i, j) == 1) 
                    ans.add(i + "/" + j);
            }
        }
        return new ArrayList(ans);
    }
    
    private int gcd(int b, int a) {
        if (b == 0) return a;
        return gcd(a % b, b);
    }
}