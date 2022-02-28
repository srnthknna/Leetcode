// https://leetcode.com/problems/maximum-gap

class Solution {
    // https://www.youtube.com/watch?v=21XhR6r5jU8&ab_channel=CodingDecoded
    // n - 1 buckets to fill n - 2 values excluding max and min
    // bucket1 , bucket2
    // maxBucket1 - minBucket2 -> and the chain follows
    // finally for 2 elements do the max - min
    public int maximumGap(int[] nums) {
        int n = nums.length, maxGap = Integer.MIN_VALUE;
        if (n < 2) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int noOfBuckets = (int)Math.ceil((double)(max - min) / (n - 1));
        int[] minBVals = new int[n - 1], maxBVals = new int[n - 1];
        Arrays.fill(minBVals, Integer.MAX_VALUE);
        Arrays.fill(maxBVals, Integer.MIN_VALUE);
        
        for (int num : nums) {
            if (num == min || num == max) continue;
            int indexOfBucket = (num - min) / (noOfBuckets);
            minBVals[indexOfBucket] = Math.min(minBVals[indexOfBucket], num);
            maxBVals[indexOfBucket] = Math.max(maxBVals[indexOfBucket], num);
        }
        
        for (int i = 0; i < n - 1; i++) {
            if (maxBVals[i] == Integer.MIN_VALUE) continue;
            maxGap = Math.max(minBVals[i] - min, maxGap);
            min = maxBVals[i];
        }
        maxGap = Math.max(max - min, maxGap);
        return maxGap;
    }
}