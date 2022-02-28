// https://leetcode.com/problems/minimum-index-sum-of-two-lists

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new HashSet<>();
        for (String list : list1) set1.add(list);
        for (String list : list2) set2.add(list);
        for (String list : set1) if (set2.contains(list)) set3.add(list);
        String[] result = new String[set3.size()];
        int i = 0;
        for (String list : set3) {
            result[i++] = list;
        }
        return result;
    }
}