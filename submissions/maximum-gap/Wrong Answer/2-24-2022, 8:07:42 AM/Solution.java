// https://leetcode.com/problems/maximum-gap

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length, maxGap = 0;
        if (n <= 2) return maxGap;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int noOfBuckets = (int)Math.ceil((double)(max - min) / (n - 1));
        int[] minBVals = new int[noOfBuckets], maxBVals = new int[noOfBuckets];
        Arrays.fill(minBVals, Integer.MAX_VALUE);
        Arrays.fill(maxBVals, Integer.MIN_VALUE);
        
        for (int num : nums) {
            if (num == min || num == max) continue;
            int indexOfBucket = (num - min) / (noOfBuckets);
            minBVals[indexOfBucket] = Math.min(minBVals[indexOfBucket], num);
            maxBVals[indexOfBucket] = Math.max(maxBVals[indexOfBucket], num);
        }
        
        for (int i = 0; i < noOfBuckets; i++) {
            if (maxBVals[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(minBVals[i] - min, maxGap);
            min = maxBVals[i];
        }
        maxGap = Math.max(max - min, maxGap);
        return maxGap;
    }
}