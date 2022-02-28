// https://leetcode.com/problems/minimum-index-sum-of-two-lists

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) 
            map.put(list1[i], i );
        List<String> res = new ArrayList<>();
        
        int min = Integer.MAX_VALUE, sum;
        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map.containsKey(list2[i])) {
                sum = map.get(list2[i]) + i;
                if (sum < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}