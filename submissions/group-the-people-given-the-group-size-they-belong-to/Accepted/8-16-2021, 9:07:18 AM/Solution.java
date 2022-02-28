// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int group = groupSizes[i];
            List<Integer> curr = map.getOrDefault(group, new ArrayList<>());
            curr.add(i);
            map.put(group, curr);
            
            if (curr.size() == group) {
                res.add(curr);
                map.remove(group);
            }
        }
        return res;
    }
}