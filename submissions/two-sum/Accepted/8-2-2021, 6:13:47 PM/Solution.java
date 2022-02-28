// https://leetcode.com/problems/two-sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i], list);
        }
        //System.out.println(map);
        for (int num : nums) {
            System.out.println(num);
            if (num == (target - num) && map.get(num).size() > 1) {
                ans[0] = map.get(num).get(0);
                ans[1] = map.get(num).get(1);
                //System.out.println("if");
                //System.out.println(ans[0] + " " + ans[1]);
                return ans;
            } else if (map.containsKey(num) && map.containsKey(target - num) && num != (target - num)) {
                ans[0] = map.get(num).get(0);
                ans[1] = map.get(target - num).get(0);
                //System.out.println("second");
                //System.out.println(ans[0] + " " + ans[1]);
                return ans;
            }
                
        }
        return ans;
    }
}