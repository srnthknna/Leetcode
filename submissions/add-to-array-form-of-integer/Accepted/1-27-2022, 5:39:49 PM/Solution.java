// https://leetcode.com/problems/add-to-array-form-of-integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length, i = n, add, carry = 0;
        List<Integer> ans = new ArrayList<>();
        
        while (--i >= 0 || k > 0) {
            if (i >= 0 && k > 0) {
                add = carry + (k % 10) + num[i];
            } else if (i >= 0) {
                add = carry + num[i];
            } else {
                add = carry + (k % 10);
            }
            ans.add(add % 10);
            carry = add / 10;
            k /= 10;
        }
        
        if (carry != 0)
            ans.add(carry);
        
        Collections.reverse(ans);     
        return ans;
    }
}