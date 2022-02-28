// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer

class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1, d;
        while (n > 0) {
            d = n % 10;
            sum += d;
            product *= d;
            n /= 10;
        }
        return product - sum;
    }
}