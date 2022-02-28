// https://leetcode.com/problems/count-special-quadruplets

class Solution {
	public int countQuadruplets(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < nums.length - 2; i ++) {
			for (int j = i + 1; j < nums.length - 1; j ++) {
				for (int k = j + 1; k < nums.length; k ++) {
					int s = nums[i] + nums[j] + nums[k];
					map.putIfAbsent(s, new ArrayList<>());
					map.get(s).add(k);
				}
			}
		}
		for (int i = 0; i < nums.length; i ++) {
			if (map.containsKey(nums[i])) {
				for (int v: map.get(nums[i])) {
					if (i > v) {
						res++;
					}
				}
			}
		}
		return res;
	}
}