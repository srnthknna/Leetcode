// https://leetcode.com/problems/find-the-most-competitive-subsequence

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while(!st.isEmpty() && nums[i] < nums[st.peek()] && st.size() + nums.length - i > k)
                st.pop();
            if (st.size() < k)
                st.push(i);
        }
        int i = k;
        int[] result = new int[k];
        while (!st.isEmpty()) {
            result[--i] = nums[st.pop()];
        }
        return result;
    }
}
