// https://leetcode.com/problems/add-to-array-form-of-integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length, i = n, carry = 0, curr = k;
        List<Integer> ans = new ArrayList<>();
        
        while (--i >= 0 || curr > 0) {
            if (i >= 0 && curr > 0) {
                int add = carry + (curr % 10) + num[i];
                ans.add(add % 10);
                carry = add / 10;
            } else if (i >= 0) {
                ans.add(num[i]);
            } else {
                ans.add(curr % 10);
            }
            curr /= 10;
        }
        
        if (carry != 0)
            ans.add(carry);
        
        Collections.reverse(ans);
        
        return ans;
    }
}