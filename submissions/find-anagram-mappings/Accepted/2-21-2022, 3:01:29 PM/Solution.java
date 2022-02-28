// https://leetcode.com/problems/find-anagram-mappings

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], new ArrayList<>());
            }
            map.get(nums2[i]).add(i);
        }
        
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                List<Integer> inMap = map.get(nums1[i]);
                result[i] = map.get(nums1[i]).get(inMap.size() - 1);
                inMap.remove(inMap.size() - 1);
            }
        }
        return result;
    }
}