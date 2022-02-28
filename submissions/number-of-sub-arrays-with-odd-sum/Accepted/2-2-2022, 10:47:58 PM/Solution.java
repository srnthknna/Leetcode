// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum

class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        int odd = 0, even = 0, sum = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                ans += odd;
                even++;
            } else {
                ans += even + 1;
                odd++;
            }
        }
        return (int)(ans % (1000000007));
    }
}