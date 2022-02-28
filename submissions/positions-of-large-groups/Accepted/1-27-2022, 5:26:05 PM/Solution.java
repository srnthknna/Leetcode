// https://leetcode.com/problems/positions-of-large-groups

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();
        
        while (i < s.length()) {
            j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            if (j - i >= 3) result.add(Arrays.asList(i, j - 1));
            i = j;
        }
        
        return result;
    }
}