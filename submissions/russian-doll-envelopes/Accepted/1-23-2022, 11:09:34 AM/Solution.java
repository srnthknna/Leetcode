// https://leetcode.com/problems/russian-doll-envelopes

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (env1, env2) -> (env1[0] == env2[0] ? (env2[1] - env1[1]) : (env1[0] - env2[0])));
        
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
            secondDim[i] = envelopes[i][1];
        return lengthOfLIS(secondDim);
    }
    
    private int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sub.get(sub.size() - 1)) {
                sub.add(nums[i]);
            } else {
                int j = Collections.binarySearch(sub, nums[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                sub.set(j, nums[i]);
            }
        }
        return sub.size();
    }
}